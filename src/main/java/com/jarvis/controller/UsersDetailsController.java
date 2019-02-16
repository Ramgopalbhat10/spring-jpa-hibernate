package com.jarvis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.model.User;
import com.jarvis.repository.UsersRepository;;

/**
 * UsersDetailsController
 */
@RestController
@RequestMapping("/users")
public class UsersDetailsController {

  @Autowired
  private UsersRepository usersRepository;

  // Get all users
  @GetMapping
  public List<User> getAllUsers() {
    return usersRepository.findAll();
  }

  // Update and get all users
  @PostMapping
  public List<User> saveUser(@RequestBody User user) {
    usersRepository.save(user);
    return usersRepository.findAll();
  }
}