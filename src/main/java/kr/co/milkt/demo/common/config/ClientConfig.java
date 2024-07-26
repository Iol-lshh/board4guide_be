package kr.co.milkt.demo.common.config;

import kr.co.milkt.demo.common.library.client.MemberClient;
import kr.co.milkt.demo.common.library.client.MemberClientImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClientConfig {
    @Bean
    public MemberClient memberClient() {
        return new MemberClientImplement();
    }
}
