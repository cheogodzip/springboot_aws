package org.example.springboot_aws.config.auth;

import lombok.RequiredArgsConstructor;
import org.example.springboot_aws.domain.user.Role;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity // Spring Security 설정 활성화
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().headers().frameOptions().disable() // h2-console 화면을 사용하기 위해 옵션 비활성화
                .and().authorizeRequests() // URL 별 권한 관리를 설정하는 옵션의 시작점
                .antMatchers("/", "/css/**", "/images/**", "/js/**", "/h2-console/**").permitAll() // 권한 관리 대상을 지정하는 옵션.
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated() // 설정된 값들 이외 나머지 URL들은 모두 인증된 사용자드에게만 허용.(로그인 사용자)
                .and().logout().logoutSuccessUrl("/") // 로그아웃 기능에 대한 여러 설정의 진입점
                .and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);

    }
}
