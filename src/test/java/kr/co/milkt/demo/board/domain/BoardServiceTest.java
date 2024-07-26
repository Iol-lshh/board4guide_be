package kr.co.milkt.demo.board.domain;

import kr.co.milkt.demo.board.domain.command.CreateBoardCommand;
import kr.co.milkt.demo.board.domain.command.CreateBoardPostCommand;
import kr.co.milkt.demo.board.domain.component.BoardRepository;
import kr.co.milkt.demo.board.domain.entity.Board;
import kr.co.milkt.demo.board.domain.entity.BoardPost;
import kr.co.milkt.demo.common.library.domain.Result;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    @Autowired
    private BoardRepository boardRepository;

    @Nested
    class CreateBoardTest{
        @Test
        void testCreateBoard_Success() {
            CreateBoardCommand command = new CreateBoardCommand("board_testCreateBoard_Success");

            Result result = boardService.createBoard(command);

            assertEquals(Result.success(), result);
            Optional<Board> board = boardRepository.findByName("board_testCreateBoard_Success");
            assertTrue(board.isPresent());
        }
    }

    @Nested
    class CreateBoardPostTest{
        @Test
        void testCreateBoardPost_Success() {
            CreateBoardCommand createBoardCommand = new CreateBoardCommand("board_testCreateBoardPost_Success");
            boardService.createBoard(createBoardCommand);
            Board board = boardRepository.findByName("board_testCreateBoardPost_Success").orElseThrow();
            CreateBoardPostCommand command = new CreateBoardPostCommand("post_testCreateBoardPost_Success", "Test Content", board.getId());

            Result result = boardService.createBoardPost(command);

            assertEquals(Result.success(), result);
            Optional<BoardPost> post = boardRepository.findPostByTitle("post_testCreateBoardPost_Success");
            assertTrue(post.isPresent());
        }
    }


}
