package com.foloxfilia.foloxfiliaserv.Service;

import com.foloxfilia.foloxfiliaserv.DTO.request.ApplicationRequest;
import com.foloxfilia.foloxfiliaserv.entity.Applications;
import com.foloxfilia.foloxfiliaserv.repository.ApplicationReposiroty;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
public class ApplicationService {

    private final ApplicationReposiroty applicationReposiroty;

    public Applications create(ApplicationRequest request, Principal principal){
        Applications applications = Application.builder()
                .createDate(LocalDateTime.now())
                .dueDate(null)
                .build();
    }
}
