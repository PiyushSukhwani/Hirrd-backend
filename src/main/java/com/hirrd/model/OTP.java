package com.hirrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "otp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OTP {

    @Id
    private String email;
    private String otpCode;
    private LocalDateTime creationTime;

}
