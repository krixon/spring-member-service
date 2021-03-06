package com.krixon.memberservice;

import com.krixon.resourceserver.security.OAuth2UserInfoTokenServices;
import com.krixon.resourceserver.security.ResourceServerSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@SpringBootApplication
@EnableResourceServer
@Configuration
@Import(ResourceServerSecurityConfig.class)
public class MemberServiceApplication
{
    private final ResourceServerProperties sso;

    @Autowired
    public MemberServiceApplication(ResourceServerProperties sso)
    {
        this.sso = sso;
    }

    public static void main(String[] args)
    {
        SpringApplication.run(MemberServiceApplication.class, args);
    }

    @Bean
    public ResourceServerTokenServices userInfoTokenServices() {
        return new OAuth2UserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
    }
}
