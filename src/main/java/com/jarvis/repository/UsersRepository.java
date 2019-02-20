package com.jarvis.repository;

import java.util.List;
import java.util.Optional;

import com.jarvis.model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * UsersRepository
 */
public interface UsersRepository extends JpaRepository<User, Integer> {
  Optional<List<User>> findByName(String name);

  @Transactional
  Optional<User> deleteByEmailId(String emailId);

  Optional<User> findByEmailId(String emailId);
}