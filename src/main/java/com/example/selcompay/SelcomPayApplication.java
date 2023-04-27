package com.example.selcompay;

import org.apache.http.HttpHeaders;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.reactive.function.client.WebClient;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;

@SpringBootApplication
public class SelcomPayApplication {

    public static void main(String[] args) {
        SpringApplication.run(SelcomPayApplication.class, args);
    }


    @Bean
    public WebClient getWebClient() {

        final String consumerKey = "a3LGqfaFkfSQeB56u0SB2ETN9V40GC78";
        final String ConsumerSecret = "j58OOsw5bOpXYuWFE29OOHs9XAc=";

        return WebClient
                .builder()
                .baseUrl("https://cybqa.pesapal.com/pesapalv3")
                .defaultHeader(CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .defaultHeader(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        var userDetailsService = new InMemoryUserDetailsManager();
        var user = User.withUsername("kelvin")
                .password("alex")
                .authorities("read")
                .roles("ADMIN")
                .build();

        userDetailsService.createUser(user);
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }



}
