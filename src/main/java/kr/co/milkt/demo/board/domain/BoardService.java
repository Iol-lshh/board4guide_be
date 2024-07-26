package kr.co.milkt.demo.board.domain;

import kr.co.milkt.demo.board.domain.dto.command.CreateBoardCommand;
import kr.co.milkt.demo.board.domain.dto.command.CreateBoardPostCommand;
import kr.co.milkt.demo.board.domain.dto.command.UpdateBoardCommand;
import kr.co.milkt.demo.board.domain.dto.command.UpdateBoardPostCommand;
import kr.co.milkt.demo.board.domain.component.BoardReader;
import kr.co.milkt.demo.board.domain.component.BoardRepository;
import kr.co.milkt.demo.board.domain.component.BoardValidator;
import kr.co.milkt.demo.board.domain.dto.view.BoardSimpleView;
import kr.co.milkt.demo.board.domain.entity.Board;
import kr.co.milkt.demo.common.library.clock.ClockManager;
import kr.co.milkt.demo.common.library.domain.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;
    private final BoardValidator boardValidator;
    private final BoardReader boardReader;
    private final ClockManager clockManager;

    @Transactional(readOnly = true)
    public Result findAllBoards() {
        List<BoardSimpleView> boardSimpleViews = boardReader.findAllView();
        return Result.success(boardSimpleViews);
    }

    @Transactional
    public Result createBoard(CreateBoardCommand command) {
        if(boardValidator.existsSameName(command.name())){
            return Result.fail("Exists same name");
        }
        Board newBoard = command.toEntity();
        boardRepository.save(newBoard);
        return Result.success();
    }

    @Transactional
    public Result updateBoard(UpdateBoardCommand command){
        if(!boardValidator.exists(command.boardId())){
            return Result.fail("Not exists board");
        }
        Board board = boardRepository.findById(command.boardId()).orElseThrow();
        board.update(command);
        boardRepository.save(board);
        return Result.success();
    }

    @Transactional
    public Result deleteBoard(Long boardId){
        if(!boardValidator.exists(boardId)){
            return Result.fail("Not exists board");
        }
        Board board = boardRepository.findById(boardId).orElseThrow();
        board.setDeleted(clockManager.now());
        boardRepository.save(board);
        return Result.success();
    }

    @Transactional
    public Result createBoardPost(CreateBoardPostCommand command) {
        if(!boardValidator.exists(command.boardId())){
            return Result.fail("Not exists board");
        }
        Board board = boardRepository.findById(command.boardId()).orElseThrow();
        board.addPost(command);
        boardRepository.save(board);
        return Result.success();
    }

    @Transactional
    public Result updateBoardPost(UpdateBoardPostCommand command) {
        if(!boardValidator.exists(command.boardId())){
            throw new IllegalArgumentException("Not exists board");
        } else if(!boardValidator.existsPost(command.postId())) {
            throw new IllegalArgumentException("Not exists post");
        }
        Board board = boardRepository.findById(command.boardId()).orElseThrow();
        board.updatePost(command);
        boardRepository.save(board);
        return Result.success();
    }

    @Transactional
    public Result deleteBoardPost(Long boardId, Long postId) {
        if(!boardValidator.exists(boardId)){
            throw new IllegalArgumentException("Not exists board");
        } else if(!boardValidator.existsPost(postId)) {
            throw new IllegalArgumentException("Not exists post");
        }
        Board board = boardRepository.findById(boardId).orElseThrow();
        board.deletePost(postId, clockManager.now());
        boardRepository.save(board);
        return Result.success();
    }
}
