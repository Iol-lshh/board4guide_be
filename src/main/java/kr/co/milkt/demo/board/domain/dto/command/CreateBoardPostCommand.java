package kr.co.milkt.demo.board.domain.dto.command;

public record CreateBoardPostCommand(
        String title,
        String content,
        Long boardId
) {

}
