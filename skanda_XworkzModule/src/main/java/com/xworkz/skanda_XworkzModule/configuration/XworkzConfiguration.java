package com.xworkz.skanda_XworkzModule.configuration;

import com.sun.org.apache.xml.internal.security.algorithms.implementations.IntegrityHmac;
import org.springframework.beans.factory.xml.ResourceEntityResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

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
    InternalResourceViewResolver internalResourceViewResolver(){
        return new InternalResourceViewResolver("/",".jsp");
    }

//    @Bean
//    public EntityManagerFactory getEntityManagerFactory()
//    {
//        return Persistence.createEntityManagerFactory("X-workZ");
//    }

    @Bean
    public LocalContainerEntityManagerFactoryBean localContainerEntityManagerFactoryBean(){
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(dataSource());
        factoryBean.setPackagesToScan("com.xworkz.skanda_XworkzModule.entity");
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        return factoryBean;
    }

   @Bean
   public DataSource dataSource(){
       DriverManagerDataSource dataSource = new DriverManagerDataSource();
       dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
       dataSource.setUrl("jdbc:mysql://localhost:3306/xworkz ");
       dataSource.setUsername("root");
       dataSource.setPassword("4JN21IS103");
       return dataSource;
   }

}



