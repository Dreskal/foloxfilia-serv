package com.foloxfilia.foloxfiliaserv.DTO.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class RegisterRequest {

    private String username;
    private String password;
    private String name;
    private String email;

}
