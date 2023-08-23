package fr.eni.enchere.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    @Bean
//    InMemoryUserDetailsManager userDetailsManager(){
//        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//        String moiChiffre = encoder.encode("moi");
//        System.out.println("moi : " + moiChiffre);
//        UserDetails a = User.builder().username("admin").password(moiChiffre).roles("ADMIN").build();
//        UserDetails b = User.builder().username("client").password(moiChiffre).roles("CLIENT").build();
//        UserDetails c = User.builder().username("autre").password(moiChiffre).roles("AUTRE").build();
//        UserDetails d = User.builder().username("chef").password(moiChiffre).roles("AUTRE","ADMIN","CLIENT").build();
//        UserDetails e = User.builder().username("user").password(moiChiffre).roles("USER").build();
//
//        return new InMemoryUserDetailsManager(a, b, c, d,e);
//    }

    @Bean
    UserDetailsManager userDetailsManager(DataSource datasource){
        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(datasource);
        manager.setUsersByUsernameQuery("select pseudo, mdp, 1 from UTILISATEURS where pseudo = ?");
        manager.setAuthoritiesByUsernameQuery("select pseudo, role from ROLES where pseudo = ?");

        return manager;
    }

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception{

        MvcRequestMatcher.Builder mvcBuilder = new MvcRequestMatcher.Builder(introspector);

        http.authorizeHttpRequests(
                auth -> {
                    auth
                            .requestMatchers(mvcBuilder.pattern("/enchere")).hasRole("USER")
                            .requestMatchers(mvcBuilder.pattern("/private")).hasRole("ADMIN")
                            .requestMatchers(mvcBuilder.pattern("/login")).permitAll()
                            .requestMatchers(mvcBuilder.pattern("/auto")).permitAll()
                            .requestMatchers(mvcBuilder.pattern("/succes")).permitAll()
                            .requestMatchers(mvcBuilder.pattern("/subscribe")).permitAll()



                            .requestMatchers(mvcBuilder.pattern("/")).permitAll()
//                            /* = /index,/accueil,/toto,etc
                            .requestMatchers(mvcBuilder.pattern("/*")).permitAll()
                            .requestMatchers(mvcBuilder.pattern("/css/*")).permitAll()
                            .requestMatchers(mvcBuilder.pattern("/images/*")).permitAll()
                            .anyRequest().denyAll();

                }
        );
//        http.formLogin(Customizer.withDefaults());
        http.formLogin(form -> {
            form.loginPage("/login").permitAll();
            form.defaultSuccessUrl("/profil");
        });


//quand tu logout tu appelle ca, et l'appli te passe en parametre un objet logout
        http.logout(logout -> logout
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutRequestMatcher(new AntPathRequestMatcher("/deconnexion"))
                .logoutSuccessUrl("/accueil")
                .permitAll()
        );

        return http.build();
    }
}
