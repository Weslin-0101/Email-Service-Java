package com.api.email.controllers;

import com.api.email.dtos.EmailDTO;
import com.api.email.model.EmailEntity;
import com.api.email.services.EmailService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/email")
public class EmailController {

    private final EmailService emailService;

    @PostMapping(value = "/sending-email")
    public ResponseEntity<EmailEntity> sendingEmail(@RequestBody @Valid EmailDTO request) {
        EmailEntity emailEntity = new EmailEntity();
        BeanUtils.copyProperties(request, emailEntity);
        emailService.sendEmail(emailEntity);

        return new ResponseEntity<>(emailEntity, HttpStatus.CREATED);
    }
}
