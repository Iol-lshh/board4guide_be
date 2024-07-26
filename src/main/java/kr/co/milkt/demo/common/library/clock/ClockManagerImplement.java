package kr.co.milkt.demo.common.library.clock;

import java.time.Clock;
import java.time.LocalDateTime;

public class ClockManagerImplement implements ClockManager{
    // TODO: 분산 환경에서의 통일된 시간으로 가져와야 합니다.
    private final Clock clock = Clock.systemDefaultZone();

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now(clock);
    }
}
