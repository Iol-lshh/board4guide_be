package kr.co.milkt.demo.board.presentation;

import kr.co.milkt.demo.common.library.domain.ResultStatus;
import kr.co.milkt.demo.common.library.presentation.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "kr.co.milkt.demo.board.presentation")
public class BoardControllerAdvice {

    @ExceptionHandler(IllegalArgumentException.class)
    public Response handleIllegalArgumentException(IllegalArgumentException e) {
        log.warn("IllegalArgumentException: {}", e.getMessage());
        return Response.of(ResultStatus.FAIL, e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        log.error("Exception: {}", e.getMessage());
        return Response.of(ResultStatus.ERROR, e.getMessage());
    }
}
