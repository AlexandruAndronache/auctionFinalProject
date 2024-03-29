package com.sda.auction.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class ApplicationConfig {
    @Bean(name = "messageSource")
    public MessageSource messageSource () {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource ();
        messageSource.setBasename ( "classpath:/validation/messages" );
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean validator ( MessageSource messageSource ) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean ();
        bean.setValidationMessageSource ( messageSource );
        return bean;
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder ();
    }
}