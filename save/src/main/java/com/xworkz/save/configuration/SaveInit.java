package com.xworkz.save.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SaveInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    public SaveInit(){
        System.out.println("no args const of Init...");
    }


    @Override
    protected String[] getServletMappings() {
        return new String[]{"/save"};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{SaveConfiguration.class};
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }
}
