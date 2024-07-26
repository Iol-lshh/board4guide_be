package kr.co.milkt.demo.board.domain.component;

import kr.co.milkt.demo.board.domain.entity.Board;
import kr.co.milkt.demo.board.domain.entity.BoardPost;

import java.util.Optional;

// entity 전용
public interface BoardRepository {
    Board save(Board newBoard);

    Optional<Board> findByName(String name);

    Optional<Board> findById(Long id);

    Optional<BoardPost> findPostById(Long postId);
}
