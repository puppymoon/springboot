package com.moontea.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moontea.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
