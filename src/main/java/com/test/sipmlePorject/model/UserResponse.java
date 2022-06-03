package com.test.sipmlePorject.model;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
  private Long id;
  private Long perNum;
  private String fio;
  private LocalDate birthDate;
  private String role;
}
