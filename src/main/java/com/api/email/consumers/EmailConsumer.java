package com.api.email.consumers;

import com.api.email.dtos.EmailRecordDTO;
import com.api.email.model.EmailEntity;
import com.api.email.services.EmailService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.BeanUtils;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class EmailConsumer {
    private final EmailService emailService;

    @RabbitListener(queues = "${spring.rabbitmq.template.default-receive-queue}")
    public void listen(@Payload EmailRecordDTO emailDTO) {
        EmailEntity emailEntity = new EmailEntity();
        BeanUtils.copyProperties(emailDTO, emailEntity);
        emailService.sendEmail(emailEntity);
    }
}
