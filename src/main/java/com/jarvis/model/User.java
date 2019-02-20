package com.jarvis.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
  @GeneratedValue(strategy = GenerationType.AUTO)
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

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private UserBankDetails bankDetails;

  public User() {
  }

}