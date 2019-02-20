package com.jarvis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

/**
 * User
 */
@Data
@Entity
@Table(name = "users", catalog = "test", uniqueConstraints = @UniqueConstraint(columnNames = { "emailId" }))
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

  @Column(name = "emailId")
  private String emailId;

  public User() {
  }

}