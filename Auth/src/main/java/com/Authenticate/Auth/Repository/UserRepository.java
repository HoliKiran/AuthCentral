package com.Authenticate.Auth.Repository;

import com.Authenticate.Auth.Models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<Author, Integer> {

    Author findByName(String name);
}
