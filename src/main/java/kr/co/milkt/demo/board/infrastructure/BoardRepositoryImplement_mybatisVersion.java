package kr.co.milkt.demo.board.infrastructure;

import kr.co.milkt.demo.board.domain.component.BoardReader;
import kr.co.milkt.demo.board.domain.component.BoardRepository;
import kr.co.milkt.demo.board.domain.component.BoardValidator;
import kr.co.milkt.demo.board.domain.dto.view.BoardSimpleView;
import kr.co.milkt.demo.board.domain.entity.Board;
import kr.co.milkt.demo.board.domain.entity.BoardPost;
import kr.co.milkt.demo.board.infrastructure.mybatis.BoardDao;
import kr.co.milkt.demo.board.infrastructure.mybatis.BoardPostDao;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

//@Repository
@RequiredArgsConstructor
public class BoardRepositoryImplement_mybatisVersion implements BoardRepository, BoardReader, BoardValidator {
    private final BoardDao boardDao;
    private final BoardPostDao boardPostDao;

    @Override
    public Board save(Board newBoard) {
        if(newBoard.getId() == null) {
            boardDao.insert(newBoard);
        }else {
            boardDao.update(newBoard);
        }
        return boardDao.findByName(newBoard.getName());
    }

    @Override
    public Optional<Board> findByName(String name) {
        Board board = boardDao.findByName(name);
        return Optional.ofNullable(board);
    }

    @Override
    public Optional<Board> findById(Long id) {
        Board board = boardDao.findById(id);
        return Optional.ofNullable(board);
    }

    @Override
    public Optional<BoardPost> findPostById(Long postId) {
        BoardPost post = boardPostDao.findById(postId);
        return Optional.ofNullable(post);
    }

    @Override
    public Optional<BoardPost> findPostByTitle(String postName) {
        return Optional.empty();
    }

    @Override
    public boolean existsSameName(String boardName) {
        return false;
    }

    @Override
    public boolean exists(Long aLong) {
        return false;
    }

    @Override
    public boolean existsPost(Long id) {
        return false;
    }

    @Override
    public List<BoardSimpleView> findAllView() {
        return boardDao.findAllView();
    }
}
