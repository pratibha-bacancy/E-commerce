package com.bacancy.spboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bacancy.spboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
