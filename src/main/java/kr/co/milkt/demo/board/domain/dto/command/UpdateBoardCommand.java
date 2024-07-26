package kr.co.milkt.demo.board.domain.dto.command;

public record UpdateBoardCommand(
        Long boardId,
        String name
) {

}
