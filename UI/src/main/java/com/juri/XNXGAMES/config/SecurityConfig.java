package com.juri.XNXGAMES.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.CorsUtils;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.CorsFilter;

import com.juri.XNXGAMES.service.MemberService;

import lombok.AllArgsConstructor;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	private MemberService memberService;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(memberService).passwordEncoder(passwordEncoder());
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "/js/**", "/fonts/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 한글 처리
		CharacterEncodingFilter filter = new CharacterEncodingFilter();        
	    filter.setEncoding("UTF-8");        
	    filter.setForceEncoding(true);        
	    http.addFilterBefore(filter, CsrfFilter.class);
		
		http.csrf().ignoringAntMatchers("http://localhost:8000/public/**");
		
		http.authorizeRequests()
				.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
        		.antMatchers("/**").permitAll()
        	.and()
            	.formLogin()
            	.loginPage("/login")
            	.loginProcessingUrl("/login")
            	.defaultSuccessUrl("/")
            	.failureUrl("/login/error")
            .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/logout/success")
                .invalidateHttpSession(true)
            .and()
            	.exceptionHandling().accessDeniedPage("/denied");
	}
	
}
