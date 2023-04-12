package com.agile.solarerc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.agile.solarerc.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
