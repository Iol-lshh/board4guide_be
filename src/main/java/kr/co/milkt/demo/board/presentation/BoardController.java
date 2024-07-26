package kr.co.milkt.demo.board.presentation;

import kr.co.milkt.demo.board.domain.BoardService;
import kr.co.milkt.demo.board.domain.dto.command.CreateBoardCommand;
import kr.co.milkt.demo.board.domain.dto.command.CreateBoardPostCommand;
import kr.co.milkt.demo.board.domain.dto.command.UpdateBoardCommand;
import kr.co.milkt.demo.board.domain.dto.command.UpdateBoardPostCommand;
import kr.co.milkt.demo.common.library.domain.Result;
import kr.co.milkt.demo.common.library.presentation.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/board")
@RestController
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/all")
    public Response findAllView(){
        Result result = boardService.findAllBoards();
        return Response.of(result);
    }

    @PostMapping("/")
    public Response createBoard(CreateBoardCommand command){
        Result result = boardService.createBoard(command);
        return Response.of(result);
    }

    @PostMapping("/{boardId}")
    public Response updateBoard(UpdateBoardCommand command){
        Result result = boardService.updateBoard(command);
        return Response.of(result);
    }

    @DeleteMapping("/{boardId}")
    public Response deleteBoard(Long boardId){
        Result result = boardService.deleteBoard(boardId);
        return Response.of(result);
    }

    @PostMapping("/{boardId}/post")
    public Response createBoardPost(CreateBoardPostCommand command){
        Result result = boardService.createBoardPost(command);
        return Response.of(result);
    }

    @PostMapping("/{boardId}/post/{postId}")
    public Response updateBoardPost(UpdateBoardPostCommand command){
        Result result = boardService.updateBoardPost(command);
        return Response.of(result);
    }

    @DeleteMapping("/{boardId}/post/{postId}")
    public Response deleteBoardPost(Long boardId, Long postId){
        Result result = boardService.deleteBoardPost(boardId, postId);
        return Response.of(result);
    }
}
