package com.sda.training.spring.notepad;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.StandardPasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.inMemoryAuthentication()
               .withUser("user1")
               .password("a2904b5a9e4ad9d038dde08f645847905afffdb9aad135ec3f5eb8a6f138a8bebaf7030bda196e43")
               .roles(Roles.USR.getFullName())
               .and()
               .withUser("admin")
               .password("65d71ddea8aa7583c00894daa7cef91463aa274febf244e5c1601b96419eab5c2e4f01ae0fedec14")
               .roles(Roles.ADM.getFullName());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        super.configure(http);
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET, "v1/api/notes/helloworld")
                .permitAll()
                .antMatchers(HttpMethod.GET, "/v1/api/notes/*")
                .hasRole(Roles.USR.getFullName())
                //uzytknik moze wejsc tylko
                .antMatchers(HttpMethod.GET, "/v1/api/notes")
                .hasRole(Roles.ADM.getFullName())
                //tylko dostęp admina
                .antMatchers(HttpMethod.POST, "/v1/api/notes")
                .permitAll()
                //wyjątek dodany w NoteServise
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .logout()
                .and()
                .httpBasic()
                //wlacz h2-console
                .and()
                .headers()
                .frameOptions()
                .disable()
                .and()
                .csrf()
                .disable();
    }

    @Bean
    public PasswordEncoder initPasswordEncoder(){
      //  return NoOpPasswordEncoder.getInstance();
        StandardPasswordEncoder standardPasswordEncoder = new StandardPasswordEncoder();
        return standardPasswordEncoder;
    }

}
