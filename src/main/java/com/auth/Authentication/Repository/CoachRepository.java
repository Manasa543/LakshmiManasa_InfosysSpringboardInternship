package com.auth.Authentication.Repository;

import com.auth.Authentication.entity.Coach;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CoachRepository extends JpaRepository<Coach, Long> {

    Optional<Coach> findByUserId(Long userId);
}