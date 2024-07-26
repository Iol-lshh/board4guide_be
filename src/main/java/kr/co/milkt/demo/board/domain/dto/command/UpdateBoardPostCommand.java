package kr.co.milkt.demo.board.domain.dto.command;

public record UpdateBoardPostCommand(
        Long boardId,
        Long postId,
        String title,
        String content
) {

}
