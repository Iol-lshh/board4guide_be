package kr.co.milkt.demo.board.domain.dto.view;

import kr.co.milkt.demo.board.domain.entity.Board;

public record BoardSimpleView(
    Long id,
    String name
) {
    public static BoardSimpleView of(Board entity) {
        return new BoardSimpleView(entity.getId(), entity.getName());
    }
}
