package kr.co.milkt.demo.board.infrastructure.mybatis;

import kr.co.milkt.demo.board.domain.dto.BoardSimpleView;
import kr.co.milkt.demo.board.domain.entity.Board;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface BoardDao {
    @Select("SELECT board.id, board.name FROM board WHERE name = #{name}")
    Board findByName(String name);

    @Select("SELECT board.id, board.name FROM board WHERE id = #{id}")
    Board findById(Long id);

    @Insert("INSERT INTO board (name) VALUES (#{name})")
    void insert(Board newBoard);

    @Update("UPDATE board SET name = #{name} WHERE id = #{id}")
    void update(Board newBoard);

    @Update("UPDATE board SET deleted = #{deleted} WHERE id = #{id}")
    void delete(Long id, LocalDateTime deleted);

    @Select("SELECT board.id, board.name FROM board WHERE deleted IS NULL")
    List<BoardSimpleView> findAllView();
}
