package com.xworkz.skanda_XworkzModule.configuration;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@Configuration
@ComponentScan("com.xworkz.skanda_XworkzModule")
@EnableWebMvc
public class XworkzConfiguration implements WebMvcConfigurer {

    public XworkzConfiguration() {
        System.out.println("X-WorkZ Configuration Constructor");
    }

//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//        return new
//    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public EntityManagerFactory getEntityManagerFactory()
    {
        return Persistence.createEntityManagerFactory("X-workZ");
    }
}



