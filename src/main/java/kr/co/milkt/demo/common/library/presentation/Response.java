package kr.co.milkt.demo.common.library.presentation;

import kr.co.milkt.demo.common.library.domain.Result;
import kr.co.milkt.demo.common.library.domain.ResultStatus;

public record Response (
    ResultStatus status,
    Object data
) {
    public static Response of(ResultStatus status, Object data) {
        return new Response(status, data);
    }

    public static Response of(Result result) {
        return new Response(result.status(), result.data());
    }
}
