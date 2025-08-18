package com.xworkz.skanda_XworkzModule.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@ComponentScan("com.xworkz.skanda_XworkzModule")
@EnableWebMvc
public class XworkzConfiguration implements WebMvcConfigurer {

    public XworkzConfiguration(){
        System.out.println("X-WorkZ Configuration Constructor");
    }


    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer defaultServletHandlerConfigurer){
        defaultServletHandlerConfigurer.enable();

    }

@Bean
    InternalResourceViewResolver internalResourceViewResolver(){
        return new InternalResourceViewResolver("/",".jsp");
}

@Bean
    public LocalContainerEntityManagerFactoryBean l (){
        return  new LocalContainerEntityManagerFactoryBean();
}

}
