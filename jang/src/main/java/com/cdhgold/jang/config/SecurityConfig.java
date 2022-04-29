package com.cdhgold.jang.config;
/*
 * 인증관련 action설정 
 */
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration // IoC 빈(bean)을 등록
@EnableWebSecurity // 필터 체인 관리 시작 어노테이션
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true) // 특정 주소 접근시 권한 및 인증을 위한 어노테이션 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	// 패스워드 자동비교가 이루어진다 
	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	 
	@Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/resources/css/**" );
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable();
		http.authorizeRequests() 
			.mvcMatchers("/css/**").permitAll()
         	.antMatchers("/workspace/**").permitAll() 
		    .antMatchers("/").authenticated()
            .antMatchers("/user/**").authenticated()
			//.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
			//.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN') and hasRole('ROLE_USER')")
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN1')")
			 
		.and()
			.formLogin()
			.loginPage("/loginFrm")
			.loginProcessingUrl("/login")// login주소가 호출되면 security가 interceptor해서 로그인 진행,userdetailservice.loadUserByUsername 호출 
			.defaultSuccessUrl("/user/home", true)
		    .usernameParameter("username")
            .passwordParameter("password")
		    //.failureHandler(failureHandler())
		    // 로그인 실패 URL을 설정함 
		    //.failureForwardUrl("/loginerr")
 
		.and()
		.exceptionHandling().accessDeniedPage("/denied");
		
		http.logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/loginFrm")
        .invalidateHttpSession(true);
	}
 
   



}





