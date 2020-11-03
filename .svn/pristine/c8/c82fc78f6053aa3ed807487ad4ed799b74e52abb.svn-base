package com.fa.inventory.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fa.inventory.config.security.LoginAuthenticationFailureHandler;
import com.fa.inventory.config.security.LoginAuthenticationProvider;
import com.fa.inventory.config.security.LoginAuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Bean
	public HttpSessionEventPublisher httpSessionEventPublisher() {
		return new HttpSessionEventPublisher();
	}

	@Resource
	LoginAuthenticationProvider loginAuthenticationProvider;

	@Resource
	LoginAuthenticationFailureHandler failureHandler;

	@Resource
	LoginAuthenticationSuccessHandler successHandler;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(loginAuthenticationProvider);
		// super.configure(auth);
		// auth.inMemoryAuthentication().withUser("s").password("s").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().authorizeRequests().antMatchers("/resources/**").permitAll()
        .antMatchers("/ForgotPassword/**").permitAll()
        .antMatchers("/getAllSecretQuestions.json/**").permitAll()
        .antMatchers("/ForgotPasswordDetails.json/**").permitAll()
        .antMatchers("/sendSms.json/**").permitAll()
        .antMatchers("/getPasswordRules.json/**").permitAll()
        .antMatchers(HttpMethod.GET,"/officeAdmin/**").access("hasAuthority('OFFICE ADMINISTRATOR')")
        .antMatchers(HttpMethod.GET,"/warehouseAdmin/**").access("hasAuthority('WAREHOUSE ADMINISTRATOR')")
        .antMatchers(HttpMethod.GET,"/common/**").access("hasAuthority('USER') or hasAuthority('SAFETY ENGINEER') or hasAuthority('ENQUIRY') or hasAuthority('SUPER USER')")
        .anyRequest().authenticated().and().formLogin()
		.failureHandler(failureHandler).successHandler(successHandler).loginPage("/").permitAll().and()
		.logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).deleteCookies("JSESSIONID")
		.logoutSuccessUrl("/login").invalidateHttpSession(true).clearAuthentication(true).and()
		.sessionManagement().sessionFixation().changeSessionId().maximumSessions(1)
		.maxSessionsPreventsLogin(false).and().and().csrf().disable();
	}

}
