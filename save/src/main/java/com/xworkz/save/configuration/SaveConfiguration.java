package com.xworkz.save.configuration;

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
@ComponentScan(basePackages = "com.xworkz.save")
@EnableWebMvc
public class SaveConfiguration implements WebMvcConfigurer {

    public SaveConfiguration(){
        System.out.println("no args of Config...");
    }


    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }


    @Bean
    InternalResourceViewResolver internalResourceViewResolver(){
        return new InternalResourceViewResolver("/",".jsp");
    }


    @Bean
   public EntityManagerFactory emf(){
        return Persistence.createEntityManagerFactory("save");
   }



    

}
