package kr.co.milkt.demo.board.domain.component;

import kr.co.milkt.demo.board.domain.dto.view.SimpleBoardPostView;
import kr.co.milkt.demo.board.domain.dto.view.SimpleBoardView;

import java.util.List;

// projection dto 읽기 전용
public interface BoardReader {

    List<SimpleBoardView> findAllView();

    List<SimpleBoardPostView> findAllBoardPostView();
}
