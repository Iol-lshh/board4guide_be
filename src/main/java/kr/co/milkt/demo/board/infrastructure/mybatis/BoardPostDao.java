package kr.co.milkt.demo.board.infrastructure.mybatis;

import kr.co.milkt.demo.board.domain.dto.view.SimpleBoardPostView;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardPostDao {
    List<SimpleBoardPostView> findAllBoardPosts();

}
