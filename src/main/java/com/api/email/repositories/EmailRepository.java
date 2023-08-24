package com.api.email.repositories;

import com.api.email.model.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface EmailRepository extends JpaRepository<EmailEntity, UUID> {
}
