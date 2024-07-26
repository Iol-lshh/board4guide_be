package kr.co.milkt.demo.board.infrastructure.jpa;

import kr.co.milkt.demo.board.domain.entity.BoardPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BoardPostJpaRepository extends JpaRepository<BoardPost, Long> {
    @Query("SELECT b FROM BoardPost b WHERE b.id = :id AND b.deleted IS NULL")
    Optional<BoardPost> findById(Long id);

    boolean existsById(Long id);
}