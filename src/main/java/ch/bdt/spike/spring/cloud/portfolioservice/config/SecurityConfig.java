package ch.bdt.spike.spring.cloud.portfolioservice.config;

import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.web.http.CookieSerializer;
import org.springframework.session.web.http.DefaultCookieSerializer;


@Configuration
@EnableWebSecurity
@Slf4j
public class SecurityConfig {
    @Value("${spring.application.name}")
    private String applicationName;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // 1. Désactiver les fonctionnalités de login et logout par défaut
                .formLogin(AbstractHttpConfigurer::disable)
                .logout(AbstractHttpConfigurer::disable)
                .csrf(c -> c.disable())
                // 2. Configurer la gestion des requêtes non autorisées
                .exceptionHandling(exceptions -> exceptions
                        // Important : pour les requêtes non authentifiées, ne pas rediriger !
                        // Renvoyer un code 401 (Unauthorized) ou 403 (Forbidden)
                        .authenticationEntryPoint((request, response, authException) ->
                                                  {
                                                      log.error("erreur d'authentification", authException);
                                                      response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                                                                         "Non authentifié (Gestion par Gateway)");
                                                  })
                )
                .authorizeHttpRequests(auth -> auth
                        .anyRequest().authenticated()
                );

        return http.build();
    }

    /**
     * Pour avoir des sessions indépendantes, le cookie de session doit porter un nom différent.
     * Voir aussi spring.session.redis.namespace.
     */
    @Bean
    public CookieSerializer cookieSerializer() {
        DefaultCookieSerializer s = new DefaultCookieSerializer();
        //s.setCookieName(applicationName + "_SESSION");
        s.setUseBase64Encoding(false);
        return s;

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }
}