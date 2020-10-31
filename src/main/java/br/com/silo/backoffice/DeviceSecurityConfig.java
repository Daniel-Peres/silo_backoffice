package br.com.silo.backoffice;

import org.javatuples.Triplet;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

@Configuration
@EnableWebSecurity
@Order(2)
public class DeviceSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        ApiKeyAuthFilter filterDevice = new ApiKeyAuthFilter("api-key", "device-serial", "deviceId");
        filterDevice.setAuthenticationManager(new AuthenticationManager() {
            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                Triplet<String, String, String> principal = (Triplet<String, String, String>) authentication.getPrincipal();
                String apiKey = principal.getValue0();
                String serialNumber = principal.getValue1();

                return authentication;
            }
        });

        httpSecurity
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/device/api/**").permitAll().anyRequest().authenticated()
                .and()//.antMatcher("/api/device/update/**").authorizeRequests().and()//.httpBasic().and()
                .antMatcher("/device/api/**")
                .addFilter(filterDevice);
    }

}
