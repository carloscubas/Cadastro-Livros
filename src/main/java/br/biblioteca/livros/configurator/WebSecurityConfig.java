package br.biblioteca.livros.configurator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig {

	private static String REALM = "MY_TEST_REALM";

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder());
	}

	@Configuration
	public class WebSecurityConfigForm extends WebSecurityConfigurerAdapter {
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable();
			http.authorizeRequests().antMatchers("/h2-console").permitAll();
			http.headers().frameOptions().disable();

			http.authorizeRequests().antMatchers(HttpMethod.GET, "/user/registration").permitAll()
					.antMatchers(HttpMethod.GET, "/list/livros").permitAll()
					.antMatchers(HttpMethod.POST, "/user/registration").permitAll()
					.antMatchers(HttpMethod.GET, "/user/list").hasRole("BASIC")
					.antMatchers(HttpMethod.GET, "/livros/lista").hasRole("BASIC")
					.antMatchers(HttpMethod.GET, "/user/listadmin").hasRole("ADMIN").antMatchers("/user/form**")
					.permitAll().and().formLogin().loginPage("/login").permitAll().and().logout().logoutSuccessUrl("/")
					.permitAll().and().requestCache();

		}

		@Bean
		@Override
		public AuthenticationManager authenticationManagerBean() throws Exception {
			return super.authenticationManagerBean();
		}

	}

	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {
		protected void configure(HttpSecurity http) throws Exception {
			http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET, "/api/**").hasRole("API")
					.antMatchers(HttpMethod.POST, "/api/**").hasRole("API").and().httpBasic().and().sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		}
	}
}
