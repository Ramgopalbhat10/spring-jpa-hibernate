package com.jarvis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * User
 */
@Data
@Entity
@Table(name = "users", catalog = "test")
public class User {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Integer id;

  @Column(name = "name")
  private String name;

  @Column(name = "team")
  private String team;

  @Column(name = "salary")
  private Integer salary;

  public User() {
  }

}