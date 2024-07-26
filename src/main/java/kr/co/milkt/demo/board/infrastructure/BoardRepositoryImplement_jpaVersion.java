package kr.co.milkt.demo.board.infrastructure;

import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.milkt.demo.board.domain.component.BoardReader;
import kr.co.milkt.demo.board.domain.component.BoardRepository;
import kr.co.milkt.demo.board.domain.component.BoardValidator;
import kr.co.milkt.demo.board.domain.dto.view.SimpleBoardPostView;
import kr.co.milkt.demo.board.domain.dto.view.SimpleBoardView;
import kr.co.milkt.demo.board.domain.entity.Board;
import kr.co.milkt.demo.board.domain.entity.BoardPost;
import kr.co.milkt.demo.board.infrastructure.jpa.BoardJpaRepository;
import kr.co.milkt.demo.board.infrastructure.jpa.BoardPostJpaRepository;
import com.querydsl.core.types.Projections;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static kr.co.milkt.demo.board.domain.entity.QBoard.board;
import static kr.co.milkt.demo.board.domain.entity.QBoardPost.boardPost;

@Repository
@RequiredArgsConstructor
public class BoardRepositoryImplement_jpaVersion implements BoardRepository, BoardReader, BoardValidator {
    private final BoardJpaRepository boardJpaRepository;
    private final BoardPostJpaRepository boardPostJpaRepository;
    private final JPAQueryFactory queryFactory;

    @Override
    public Board save(Board newBoard) {
        return boardJpaRepository.save(newBoard);
    }

    @Override
    public List<Board> findAll() {
        return boardJpaRepository.findAll();
    }

    @Override
    public Optional<Board> findByName(String name) {
        return boardJpaRepository.findByName(name);
    }

    @Override
    public Optional<Board> findById(Long id) {
        return boardJpaRepository.findById(id);
    }

    @Override
    public List<BoardPost> findPostByTitle(String postName) {
        return boardPostJpaRepository.findByTitle(postName);
    }

    @Override
    public boolean existsSameName(String boardName) {
        return boardJpaRepository.existsByName(boardName);
    }

    @Override
    public boolean exists(Long id) {
        return boardJpaRepository.existsById(id);
    }

    @Override
    public boolean existsPost(Long id) {
        return boardPostJpaRepository.existsById(id);
    }

    @Override
    public List<SimpleBoardView> findAllView() {
        return queryFactory
                .select(Projections.constructor(SimpleBoardView.class,
                        board.id, board.name))
                .from(board)
                .fetch();
    }

    @Override
    public List<SimpleBoardPostView> findAllBoardPostView() {
        return queryFactory
                .select(Projections.constructor(SimpleBoardPostView.class,
                        boardPost.id, boardPost.title, boardPost.content, boardPost.board.id))
                .from(boardPost)
                .fetch();
    }
}
