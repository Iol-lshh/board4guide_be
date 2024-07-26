package kr.co.milkt.demo.board.domain.component;

import kr.co.milkt.demo.board.domain.dto.BoardSimpleView;

import java.util.List;

// projection dto 읽기 전용
public interface BoardReader {

    List<BoardSimpleView> findAllView();
}
