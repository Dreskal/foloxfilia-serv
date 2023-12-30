package com.foloxfilia.foloxfiliaserv.DTO;

import com.foloxfilia.foloxfiliaserv.entity.enums.ERole;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;


@Builder
@Data
public class UserDTO {

    private Long id;
    private String username;
    private LocalDateTime createDate;
    private List<ERole> role;

}
