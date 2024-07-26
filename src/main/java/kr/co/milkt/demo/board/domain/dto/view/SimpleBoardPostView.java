package kr.co.milkt.demo.board.domain.dto.view;

import kr.co.milkt.demo.board.domain.entity.BoardPost;

public record SimpleBoardPostView(
        Long id,
        String title,
        String content,
        Long boardId
){
    public static SimpleBoardPostView of(BoardPost entity) {
        return new SimpleBoardPostView(entity.getId(), entity.getTitle(), entity.getContent(), entity.getBoard().getId());
    }
}
