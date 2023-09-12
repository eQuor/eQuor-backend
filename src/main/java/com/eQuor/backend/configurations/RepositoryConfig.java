package com.eQuor.backend.configurations;

import com.eQuor.backend.models.APIRequest;
import com.eQuor.backend.models.Lecturer;
import com.eQuor.backend.models.Staff;
import com.eQuor.backend.models.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

@Component
public class RepositoryConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
        config.exposeIdsFor(Staff.class, APIRequest.class, Test.class, Lecturer.class);
    }
}