package kr.co.milkt.demo.board.domain.component;

public interface BoardValidator {

    boolean existsSameName(String boardName);

    boolean exists(Long aLong);

    boolean existsPost(Long id);
}
