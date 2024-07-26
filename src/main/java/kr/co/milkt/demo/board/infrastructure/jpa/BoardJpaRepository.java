package kr.co.milkt.demo.board.infrastructure.jpa;

import kr.co.milkt.demo.board.domain.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BoardJpaRepository extends JpaRepository<Board, Long> {
    @Query("SELECT b FROM Board b WHERE b.deleted IS NULL")
    List<Board> findAll();

    @Query("SELECT b FROM Board b WHERE b.id = :id AND b.deleted IS NULL")
    Optional<Board> findById(Long id);

    @Query("SELECT b FROM Board b WHERE b.name = :name AND b.deleted IS NULL")
    Optional<Board> findByName(String name);

    boolean existsByName(String name);

    boolean existsById(Long id);

}
