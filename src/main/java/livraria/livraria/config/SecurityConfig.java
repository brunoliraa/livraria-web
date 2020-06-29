package livraria.livraria.config;

import livraria.livraria.service.AdminUserDetailsService;
import livraria.livraria.service.ClienteUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Configuration
    @Order(1)
//    @Order(Ordered.HIGHEST_PRECEDENCE)
    public static class AdminConfigureAdapter extends WebSecurityConfigurerAdapter{
        public AdminConfigureAdapter (){
            super();
        }
        @Autowired
        private AdminUserDetailsService adminUserDetailsService;
        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;


        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(adminUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.csrf().disable()
                    .antMatcher("/admin/**")
                    .authorizeRequests()
                    .anyRequest()
                    .hasRole("ADMIN")

                    .and().formLogin()
                    .loginPage("/login")
                    .loginProcessingUrl("/admin/entrar")
                    .defaultSuccessUrl("/admin/edicao")
                    .failureUrl("/login")
                    .usernameParameter("login").passwordParameter("senha")
                    .and().logout()
                    .logoutUrl("/logout").logoutSuccessUrl("/login");
//                    .deleteCookies("JSESSIONID")
//                    .and()
//                    .exceptionHandling()
//                    .accessDeniedPage("/403");

        }

    }

    @Configuration
    @Order(2)
    public static class ClienteConfigureAdapter extends WebSecurityConfigurerAdapter{
        public ClienteConfigureAdapter (){
            super();
        }
        @Autowired
        private ClienteUserDetailsService clienteUserDetailsService;
        @Autowired
        private BCryptPasswordEncoder bCryptPasswordEncoder;

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.userDetailsService(clienteUserDetailsService).passwordEncoder(bCryptPasswordEncoder);
        }
        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.csrf().disable()
                    .authorizeRequests()
                    .antMatchers("/carrinho").hasRole("USER")
                    .anyRequest().permitAll()
                    .and().formLogin()
                    .loginPage("/home").loginProcessingUrl("/autent").defaultSuccessUrl("/carrinho").failureUrl("/cliente")
                    .usernameParameter("cliente").passwordParameter("password")
                    .and().logout()
                    .logoutUrl("/logout").logoutSuccessUrl("/cliente");
//                    .deleteCookies("JSESSIONID")
//                    .and()
//                    .exceptionHandling()
//                    .accessDeniedPage("/403");
        }
    }






    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

}
