package com.jarvis.repository;

import com.jarvis.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * UsersRepository
 */
public interface UsersRepository extends JpaRepository<User, Integer> {

}