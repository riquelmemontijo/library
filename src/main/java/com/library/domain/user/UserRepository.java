package com.library.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<UserDomain, UUID> {
    Optional<UserDetails> findByUsername(String username);
    Optional<UserDomain> findByEmail(String email);
}
