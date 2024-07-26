package kr.co.milkt.demo.board.domain.entity;

import jakarta.persistence.*;
import kr.co.milkt.demo.board.domain.dto.command.UpdateBoardPostCommand;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class BoardPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Setter
    private LocalDateTime deleted;

    @Setter
    @ManyToOne
    private Board board;

    public void update(UpdateBoardPostCommand command) {
        this.title = command.title();
        this.content = command.content();
    }

}
