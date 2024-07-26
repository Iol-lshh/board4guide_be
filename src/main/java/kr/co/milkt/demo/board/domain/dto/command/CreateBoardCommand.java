package kr.co.milkt.demo.board.domain.dto.command;

import kr.co.milkt.demo.board.domain.entity.Board;

public record CreateBoardCommand(
    String name
) {
    public Board toEntity() {
        return Board.builder()
                .name(name)
                .build();
    }
}
