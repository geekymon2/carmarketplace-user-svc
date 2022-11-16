package com.geekymon2.carmarketplace.userservice.repository;

import com.geekymon2.carmarketplace.userservice.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<User, Long> {
    @Query("SELECT u FROM user u WHERE (u.email = :email) and (u.password = :password)")
    User findByUsernameAndPassword(@Param("email") String email, @Param("password") String password);
}
