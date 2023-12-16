package com.foloxfilia.foloxfiliaserv.repository;

import com.foloxfilia.foloxfiliaserv.entity.Contacts;
import com.foloxfilia.foloxfiliaserv.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactsRepository extends JpaRepository<Contacts, Users> {


}
