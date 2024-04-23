package edu.sejong.ex.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().requestMatchers(PathRequest.toStaticResources().atCommonLocations());
		// web.ignoring().antMatchers("/css/**", "/js/**", "/img/**", "/lib/**");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
			.withUser("member").password("{noop}member").roles("USER")
			.and()
			.withUser("admin").password("{noop}admin").roles("ADMIN")
		;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/user/**").hasAnyRole("USER")
			.antMatchers("/admin/**").hasAnyRole("ADMIN")
			//.antMatchers("/board/**").hasAnyRole("ADMIN")
			.antMatchers("/emp/list").hasAnyRole("ADMIN")
			.antMatchers("/board/list").hasAnyRole("ADMIN")
			.antMatchers("/**").permitAll()
		;
		//http.formLogin();
		http.formLogin()
			.loginPage("/login")
			.usernameParameter("id")
			.passwordParameter("pw")
			//.defaultSuccessUrl("/board/list")
			.defaultSuccessUrl("/")
			.permitAll()
		;
	}
}