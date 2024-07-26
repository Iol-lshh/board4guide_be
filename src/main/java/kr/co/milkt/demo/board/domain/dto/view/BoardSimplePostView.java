package kr.co.milkt.demo.board.domain.dto.view;

import kr.co.milkt.demo.board.domain.entity.BoardPost;

public record BoardSimplePostView(
        Long id,
        String title,
        String content,
        Long boardId
){
    public static BoardSimplePostView of(BoardPost entity) {
        return new BoardSimplePostView(entity.getId(), entity.getTitle(), entity.getContent(), entity.getBoard().getId());
    }
}
