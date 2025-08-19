package com.xworkz.save.configuration;

import com.xworkz.save.repository.SaveRepository;
import com.xworkz.save.repository.SaveRepositoryImp;
import com.xworkz.save.service.SaveService;
import com.xworkz.save.service.SaveServiceImp;
import org.hibernate.engine.jdbc.connections.internal.DriverManagerConnectionCreator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.xworkz.save")
@EnableWebMvc
public class SaveConfiguration implements WebMvcConfigurer {

    public SaveConfiguration(){
        System.out.println("no args of Config...");
    }


    public void DefaultServletHandlerConfigurer(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer)  {
        defaultServletHandlerConfigurer.enable();
    }

    @Bean
    InternalResourceViewResolver internalResourceViewResolver(){
        return new InternalResourceViewResolver("/",".jsp");
    }


   public EntityManagerFactory entityManagerFactory(){
        return Persistence.createEntityManagerFactory("save");
   }

   @Bean
    public SaveService saveService(){
        return new SaveServiceImp();
   }

   @Bean
    public SaveRepository saveRepository(){
        return new SaveRepositoryImp();
   }

    

}
