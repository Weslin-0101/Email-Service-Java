package com.api.email.dtos;

import java.util.UUID;

public record EmailRecordDTO(
        UUID userID,
        String emailTo,
        String subject,
        String text
) { }
