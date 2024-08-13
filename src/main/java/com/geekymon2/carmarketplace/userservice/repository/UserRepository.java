package com.geekymon2.carmarketplace.userservice.repository;

import com.geekymon2.carmarketplace.userservice.entities.AppUser;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends CrudRepository<AppUser, Long> {
    @Query("SELECT u FROM appuser u WHERE (u.email = :email) and (u.password = :password)")
    AppUser findByUsernameAndPassword(@Param("email") String email, @Param("password") String password);
    @Query("SELECT u FROM appuser u WHERE (u.email = :email)")
    AppUser findByEmail(@Param("email") String email);
}
