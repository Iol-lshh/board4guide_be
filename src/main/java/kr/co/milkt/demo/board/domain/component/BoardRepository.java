package kr.co.milkt.demo.board.domain.component;

import kr.co.milkt.demo.board.domain.entity.Board;
import kr.co.milkt.demo.board.domain.entity.BoardPost;

import java.util.List;
import java.util.Optional;

// entity 전용
public interface BoardRepository {
    Board save(Board newBoard);

    List<Board> findAll();
    Optional<Board> findByName(String name);
    Optional<Board> findById(Long id);
    List<BoardPost> findPostByTitle(String postName);

}
