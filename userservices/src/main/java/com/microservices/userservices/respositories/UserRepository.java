package com.microservices.userservices.respositories;

import com.microservices.userservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
    //user other query can write here


}
