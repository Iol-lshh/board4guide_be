package kr.co.milkt.demo.board.domain.dto.view;

import kr.co.milkt.demo.board.domain.entity.Board;

public record SimpleBoardView(
    Long id,
    String name
) {
    public static SimpleBoardView of(Board entity) {
        return new SimpleBoardView(entity.getId(), entity.getName());
    }
}
