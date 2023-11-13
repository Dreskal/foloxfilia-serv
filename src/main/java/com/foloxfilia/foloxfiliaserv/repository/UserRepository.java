package com.foloxfilia.foloxfiliaserv.repository;


import com.foloxfilia.foloxfiliaserv.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Long, Users> {

}
