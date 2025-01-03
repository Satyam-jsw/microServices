package com.microservices.userservices.controllers;

import com.microservices.userservices.entities.User;
import com.microservices.userservices.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private static final Logger logger = Logger.getLogger(UserController.class.getName());


    int count = 1;

    // Get User by ID
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")

    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")

    public ResponseEntity<User> getUserById(@PathVariable String userId) {

        count++;

        logger.info(String.valueOf(count));


        User user = userService.getUser(userId);
        return ResponseEntity.ok(user); // 200 OK
    }

    //creating fall back method for circuit breaker

    public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
        User user = new User();
        user.setEmail("rajabhai@gmail.com");
        user.setName("Raja Bhai");
        user.setAbout("Working as Pradhan for village developement");
        user.setUserId("123454");
        return new ResponseEntity(user, HttpStatus.OK);
    }

    // Create New User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User newUser = userService.saveUser(user);
        return ResponseEntity.status(HttpStatus.CREATED) // 201 Created
                .body(newUser);
    }

    // Get All Users
    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<User> userList = userService.getAllUser();
        if (userList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build(); // 204 No Content
        }
        return ResponseEntity.ok(userList); // 200 OK
    }

    // Delete User by ID
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUserById(@PathVariable String userId) {
        userService.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully with ID: " + userId); // 200 OK
    }

    // Update User by ID
    @PutMapping("/{userId}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable String userId) {
        User updatedUser = userService.updateUser(userId, user);
        return ResponseEntity.ok(updatedUser); // 200 OK
    }
}

