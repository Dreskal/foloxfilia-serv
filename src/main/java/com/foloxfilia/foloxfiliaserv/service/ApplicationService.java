package com.foloxfilia.foloxfiliaserv.service;

import com.foloxfilia.foloxfiliaserv.DTO.request.ApplicationRequest;
import com.foloxfilia.foloxfiliaserv.entity.Applications;
import com.foloxfilia.foloxfiliaserv.entity.Users;
import com.foloxfilia.foloxfiliaserv.entity.enums.EState;
import com.foloxfilia.foloxfiliaserv.repository.ApplicationReposiroty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ApplicationService {

    private final UserService userService;
    private final ApplicationReposiroty applicationReposiroty;

    public Applications create(ApplicationRequest request, Principal principal){
        Users user = userService.getByPrincipal(principal);
        Applications applications = Applications.builder()
                .description(request.getDescription())
                .createDate(LocalDateTime.now())
                .dueDate(LocalDateTime.now().plusDays(7))  // в propertiers
                .state(EState.NOT_VIEW)
                .user(user)
                .build();

        return applicationReposiroty.save(applications);
    }

    public List<Applications> getAll(){
        return applicationReposiroty.findAll();
    }
}
