package com.example.pizzarest.persistence.repository;

import com.example.pizzarest.persistence.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, String> {
}
