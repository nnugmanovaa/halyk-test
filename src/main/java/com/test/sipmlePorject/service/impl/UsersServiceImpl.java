package com.test.sipmlePorject.service.impl;

import com.test.sipmlePorject.domain.UserEntity;
import com.test.sipmlePorject.model.UserCreateRequest;
import com.test.sipmlePorject.model.UserResponse;
import com.test.sipmlePorject.repository.UsersRepository;
import com.test.sipmlePorject.service.IUsersService;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements IUsersService {
  private final UsersRepository usersRepository;

  @Override
  public UserEntity createUser(UserCreateRequest userDto) {
    Optional<UserEntity> user = usersRepository
        .findByPerNumAndFioAndBirthDate(userDto.getPerNum(),
            userDto.getFio(),
            userDto.getBirthDate());
    if (user.isPresent()) {
      return user.get();
    }
    return usersRepository.save(getModelMapper().map(userDto, UserEntity.class));
  }

  @Override
  public List<UserResponse> getUserByPerNum(Long perNum) {
    if (perNum != 0) {
      return Collections
          .singletonList(getModelMapper()
              .map( usersRepository.findByPerNum(perNum), UserResponse.class));
    }
    return usersRepository
        .findAll()
        .stream()
        .map(user -> getModelMapper().map(user, UserResponse.class))
        .collect(Collectors.toList());
  }

  private ModelMapper getModelMapper() {
    return new ModelMapper();
  }
}
