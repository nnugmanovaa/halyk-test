package com.test.sipmlePorject.controller;

import com.test.sipmlePorject.domain.UserEntity;
import com.test.sipmlePorject.model.UserCreateRequest;
import com.test.sipmlePorject.service.IUsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/users")
@RequiredArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
public class UsersController {
  private final IUsersService usersService;

  @PostMapping
  public ResponseEntity<UserEntity> createUser(@RequestBody UserCreateRequest userDto) {
    return ResponseEntity.ok(usersService.createUser(userDto));
  }

  @GetMapping(path = "/{perNum}")
  public ResponseEntity<?> getUserByPerNum(@PathVariable("perNum") Long perNum) {
    return ResponseEntity.ok(usersService.getUserByPerNum(perNum));
  }
}
