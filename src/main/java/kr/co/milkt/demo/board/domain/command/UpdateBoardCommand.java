package kr.co.milkt.demo.board.domain.command;

public record UpdateBoardCommand(
        Long boardId,
        String name
) {

}
