package kr.co.milkt.demo.common.library.domain;

public record Result(
    ResultStatus status,
    Object data
) {
    public static Result of(ResultStatus status, String message, Object data) {
        return new Result(status, data);
    }
    public static Result ok(Object message) {
        return new Result(ResultStatus.OK, message);
    }
    public static Result success(Object data) {
        return new Result(ResultStatus.SUCCESS, data);
    }
    public static Result success(){
        return new Result(ResultStatus.SUCCESS, null);
    }
    public static Result fail(Object message) {
        return new Result(ResultStatus.FAIL, message);
    }
}
