package kr.co.milkt.demo.board.domain.command;

public record CreateBoardPostCommand(
        String title,
        String content,
        Long boardId
) {

}
