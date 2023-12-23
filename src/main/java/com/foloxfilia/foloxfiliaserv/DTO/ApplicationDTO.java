package com.foloxfilia.foloxfiliaserv.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.foloxfilia.foloxfiliaserv.entity.enums.EState;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ApplicationDTO {
    private Long id;
    private String description;
    private LocalDateTime createDate;
    private LocalDateTime dueDate;
    private EState state;
    private UserDTO user;

}
