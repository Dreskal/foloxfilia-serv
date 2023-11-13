package com.foloxfilia.foloxfiliaserv.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.foloxfilia.foloxfiliaserv.entity.enums.ERole;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true, nullable = false, length = 32)
    private String username;
    @Column(nullable = false, length = 3000)
    private String password;
    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss" )
    @Column(updatable = false )
    private LocalDateTime createDate;

    @ElementCollection(targetClass = ERole.class)
    @JoinTable(name = "user_role",
    joinColumns = @JoinColumn(name = "user_id"))
    private Set<ERole> role;

    @OneToOne(mappedBy = "user")
    private Contacts contacts;

    @OneToMany(mappedBy = "user")
    private List<Applications> applications;

    @OneToMany(mappedBy = "user")
    private List<Posts> posts;

    @OneToMany(mappedBy = "user")
    private List<Comments> comments;

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
        createDate = LocalDateTime.now();
    }
}
