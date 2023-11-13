package com.foloxfilia.foloxfiliaserv.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@Entity
public class Contacts {
    @Id
    @OneToOne
    @JoinColumn(name = "users_id", referencedColumnName = "id")
    private Users user;

    @Column(length = 16)
    private String name;

    private String email;
    private boolean licence;
    private String country;
    private String bio;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss" )
    private LocalDateTime birthDate;
}
