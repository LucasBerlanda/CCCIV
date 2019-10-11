package br.edu.unoesc;

import br.edu.unoesc.service.UsuarioBancoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
// como colocar o crsf dentro do formulário

    @Autowired
    private UsuarioBancoService service;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.inMemoryAuthentication()
//                .withUser("admin")
//                .password("{noop}123")
//                .roles("USER", "ADMIN", "SECRETARIA")
//                .and()
//                .passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
        auth.userDetailsService(service).passwordEncoder(PasswordEncoderFactories.createDelegatingPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/bootstrap/**", "/css/**", "/scripts/**", "/images/**").permitAll()
                .antMatchers("/pessoa/**").hasRole("ADMIN")
                .antMatchers("/livro/**").hasRole("SECRETARIA")
                .antMatchers("/**").hasRole("USER")

            .and()
                .formLogin()
                    .loginPage("/login").permitAll()
                    .loginProcessingUrl("/loginUser").permitAll()
                    .defaultSuccessUrl("/pessoa/lista");
    }
}
