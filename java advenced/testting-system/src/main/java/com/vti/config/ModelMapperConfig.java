package com.vti.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.ModelMap;
@Configuration
public class ModelMapperConfig {
    @Bean
    public ModelMapper GetMoDelMapper() {
        return new ModelMapper();
    }

}