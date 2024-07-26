package kr.co.milkt.demo.board.infrastructure.mybatis;

import kr.co.milkt.demo.board.domain.entity.BoardPost;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;

@Mapper
public interface BoardPostDao {
    @Insert("INSERT INTO board_post (title, content, board_id) VALUES (#{title}, #{content}, #{boardId})")
    BoardPost insert(BoardPost newPost);

    @Update("UPDATE board_post SET title = #{title}, content = #{content} WHERE id = #{id}")
    BoardPost update(BoardPost post);

    @Delete("UPDATE board_post SET deleted = #{deleted} WHERE id = #{postId}")
    void delete(Long postId, LocalDateTime deleted);

    @Select("SELECT * FROM board_post WHERE id = #{postId}")
    BoardPost findById(Long postId);
}
