package com.geekymon2.carmarketplace.userservice.repository;

import com.geekymon2.carmarketplace.userservice.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
