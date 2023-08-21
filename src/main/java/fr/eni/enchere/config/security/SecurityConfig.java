//package fr.eni.enchere.config.security;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.provisioning.JdbcUserDetailsManager;
//import org.springframework.security.provisioning.UserDetailsManager;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//import org.springframework.web.servlet.handler.HandlerMappingIntrospector;
//
//import javax.sql.DataSource;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    @Bean
//    UserDetailsManager userDetailsManager(DataSource datasource){
//        JdbcUserDetailsManager manager = new JdbcUserDetailsManager(datasource);
//        manager.setUsersByUsernameQuery("select pseudo, mot_de_passe, 1 from utilisateur where pseudo = ?");
//
//        return manager;
//    }
//
//    @Bean
//    SecurityFilterChain filterChain(HttpSecurity http, HandlerMappingIntrospector introspector) throws Exception{
//
//        MvcRequestMatcher.Builder mvcBuilder = new MvcRequestMatcher.Builder(introspector);
//
//        http.authorizeHttpRequests(
//                auth -> {
//                    auth
//                            .requestMatchers(mvcBuilder.pattern("/enchere")).hasRole("Encherir")
//                            .requestMatchers(mvcBuilder.pattern("/ ")).hasRole(" ")
//                            .requestMatchers(mvcBuilder.pattern("/*")).permitAll()
//                            .requestMatchers(mvcBuilder.pattern("/css/*")).permitAll()
//                            .requestMatchers(mvcBuilder.pattern("/images/*")).permitAll()
//                            .anyRequest().denyAll();
//
//                }
//        );
////        http.formLogin(Customizer.withDefaults());
//        http.formLogin(form -> {
//            form.loginPage("/login").permitAll();
//            form.defaultSuccessUrl("/");
//        });
//
//        http.logout(logout -> logout
//                .invalidateHttpSession(true)
//                .clearAuthentication(true)
//                .deleteCookies("JSESSIONID")
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .logoutSuccessUrl("/")
//                .permitAll()
//        );
//
//        return http.build();
//    }
//}
