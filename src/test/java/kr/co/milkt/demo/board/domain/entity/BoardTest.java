package kr.co.milkt.demo.board.domain.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import kr.co.milkt.demo.board.domain.command.CreateBoardPostCommand;

import java.util.ArrayList;

public class BoardTest {

    @Nested
    @DisplayName("게시글 추가")
    class AddPostTest {
        @Test
        @DisplayName("게시글을 추가하면 게시판의 게시글 목록에 추가된다")
        public void testAddPost() {
            // Prepare test data
            Board board = new Board(1L, "Test Board", null, new ArrayList<>());
            CreateBoardPostCommand command = new CreateBoardPostCommand("Test Title", "Test Content", board.getId());

            // Call method under test
            board.addPost(command);

            // Verify the effects of method call
            Assertions.assertEquals(1, board.getPosts().size());
            Assertions.assertEquals("Test Title", board.getPosts().get(0).getTitle());
            Assertions.assertEquals("Test Content", board.getPosts().get(0).getContent());
            Assertions.assertEquals(board, board.getPosts().get(0).getBoard());
        }
    }

}