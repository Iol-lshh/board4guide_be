package kr.co.milkt.demo.common.config;

import kr.co.milkt.demo.common.library.clock.ClockManager;
import kr.co.milkt.demo.common.library.clock.ClockManagerImplement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClockConfig {
    @Bean
    public ClockManager clockManager() {
        return new ClockManagerImplement();
    }
}
