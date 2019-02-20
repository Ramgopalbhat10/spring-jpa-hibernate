package com.jarvis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * UserBankDetails
 */
@Data
@Entity
@Table(name = "users_bank_details", catalog = "test")
public class UserBankDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Integer id;

  @Column(name = "bankName")
  private String bankName;

  @Column(name = "balance")
  private Integer balance;

  public UserBankDetails() {
  }

}