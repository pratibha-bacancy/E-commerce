package com.bacancy.spboot.repository;

import org.springframework.data.repository.CrudRepository;
import com.bacancy.spboot.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
