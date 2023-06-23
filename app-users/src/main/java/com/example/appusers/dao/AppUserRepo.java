package com.example.appusers.dao;

import com.example.appusers.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AppUserRepo extends JpaRepository<AppUser, String> {

    Optional<AppUser> findByEmailAndPassword(String email, String password);

}
