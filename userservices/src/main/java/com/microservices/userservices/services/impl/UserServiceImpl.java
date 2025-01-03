package com.microservices.userservices.services.impl;

import com.microservices.userservices.entities.Hotel;
import com.microservices.userservices.entities.Rating;
import com.microservices.userservices.entities.User;
import com.microservices.userservices.exceptions.ResourceNotFoundException;
import com.microservices.userservices.external.services.HotelService;
import com.microservices.userservices.respositories.UserRepository;
import com.microservices.userservices.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;


    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }


    //get single user
    @Override
    public User getUser(String userId) {
        //get user from database with the help  of user repository
        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User with given id is not found on server !! : " + userId));
        // fetch rating of the above  user from RATING SERVICE
        //http://localhost:8083/ratings/users/47e38dac-c7d0-4c40-8582-11d15f185fad

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATINGSERVICE:8083/ratings/users/" + user.getUserId(), Rating[].class);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();
        List<Rating> ratingList = ratings.stream().map(rating -> {
            //api call to hotel service to get the hotel
            //http://localhost:8082/hotels/1cbaf36d-0b28-4173-b5ea-f1cb0bc0a791

//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE:8080/hotels/" + rating.getHotelId(), Hotel.class);
//            Hotel hotel = forEntity.getBody();
             Hotel hotel = hotelService.getHotel(rating.getHotelId());
            //set the hotel to rating
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(String id, User user) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setAbout(user.getAbout());
        return userRepository.save(existingUser);
    }
}
