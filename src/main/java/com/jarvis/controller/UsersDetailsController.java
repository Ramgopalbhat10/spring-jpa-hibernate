package com.jarvis.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jarvis.exceptions.UniqueEmailIdException;
import com.jarvis.exceptions.UserNotFoundException;
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

  // Save and get all users
  @PostMapping
  public List<User> saveUser(@RequestBody User user) {
    Optional<User> userDetails = usersRepository.findByEmailId(user.getEmailId());
    if (userDetails.isPresent()) {
      throw new UniqueEmailIdException("EmailId aleady exists");
    }
    usersRepository.save(user);
    return usersRepository.findAll();
  }

  // Get user by name
  @GetMapping("/{userName}")
  public List<User> getUserByName(@PathVariable("userName") String userName) {
    Optional<List<User>> users = usersRepository.findByName(userName);
    return users.orElseThrow(() -> new UserNotFoundException("User not found"));
  }

  // Delete user and get all
  @DeleteMapping("/{emailId}")
  public List<User> deleteUser(@PathVariable("emailId") String emailId) {
    Optional<User> user = usersRepository.findByEmailId(emailId);
    if (!user.isPresent()) {
      throw new UserNotFoundException("User not found");
    }
    usersRepository.deleteByEmailId(emailId);
    return usersRepository.findAll();
  }

  // Update User and get
  @PutMapping("/{emailId}")
  public User updateUser(@PathVariable("emailId") String emailId, @RequestBody User user) {
    Optional<User> userDetails = usersRepository.findByEmailId(emailId);
    User userDetailsToUpdate = new User();

    if (userDetails.isPresent()) {
      userDetailsToUpdate = userDetails.get();
    } else {
      throw new UserNotFoundException("User not found");
    }
    userDetailsToUpdate.setSalary(user.getSalary());
    userDetailsToUpdate.setTeam(user.getTeam());
    usersRepository.save(userDetailsToUpdate);

    return usersRepository.findByEmailId(emailId).get();
  }
}