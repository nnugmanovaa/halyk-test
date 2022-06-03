package com.test.sipmlePorject.service;

import com.test.sipmlePorject.domain.UserEntity;
import com.test.sipmlePorject.model.UserCreateRequest;
import com.test.sipmlePorject.model.UserResponse;
import java.util.List;

public interface IUsersService {
  UserEntity createUser(UserCreateRequest userDto);

  List<UserResponse> getUserByPerNum(Long perNum);
}
