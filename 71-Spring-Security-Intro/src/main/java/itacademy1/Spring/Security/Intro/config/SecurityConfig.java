package itacademy1.Spring.Security.Intro.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin").password("{noop}1234").roles("ADMIN").and()
                .withUser("user").password("{noop}4321").roles("USER").and()
                .withUser("login").password("{noop}password").roles("USER").and()
                .withUser("moderator").password("{noop}qwerty").roles("MODERATOR").and()
                .withUser("alex").password("{noop}agent007").roles("MODERATOR");
    }

   @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and().authorizeRequests()
                .antMatchers(HttpMethod.POST, "/api/task").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/task").hasRole("ADMIN")
                .antMatchers(HttpMethod.PUT, "/api/task").hasRole("USER")
                .antMatchers(HttpMethod.PUT, "/api/task").hasRole("MODERATOR") //hw
                .antMatchers(HttpMethod.DELETE, "/api/task").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/task/api/check-user").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/api/task/api/check-admin").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/api/task/api/check-moder").hasRole("MODERATOR")
                .and().csrf().disable();
    }
}

