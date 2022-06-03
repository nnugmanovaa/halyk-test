package com.test.sipmlePorject.repository;

import com.test.sipmlePorject.domain.UserEntity;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends CrudRepository<UserEntity, Long> {

  UserEntity findByPerNum(Long perNum);

  List<UserEntity> findAll();

  Optional<UserEntity> findByPerNumAndFioAndBirthDate(Long perNum, String fio, LocalDate date);
}
