package com.test.sipmlePorject.domain;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "ID")
  private Long id;

  @Column(name = "PER_NUM")
  private Long perNum;

  @Column(name = "FIO")
  private String fio;

  @Column(name = "BIRTH_DATE")
  private LocalDate birthDate;

  @Column(name = "ROLE")
  private String role;
}
