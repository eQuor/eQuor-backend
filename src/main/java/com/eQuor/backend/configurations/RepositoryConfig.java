package com.eQuor.backend.configurations;

import com.eQuor.backend.models.*;
import com.eQuor.backend.models.Module;
import com.eQuor.backend.models.Module;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
public class RepositoryConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Staff.class, APIRequest.class, Test.class, Lecturer.class, Student.class, Module.class, Module.class, LecturerRegisterModule.class,StudentRegisterModule.class);
    }
}