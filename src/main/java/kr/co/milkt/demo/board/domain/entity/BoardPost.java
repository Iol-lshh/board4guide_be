package kr.co.milkt.demo.board.domain.entity;

import jakarta.persistence.*;
import kr.co.milkt.demo.board.domain.command.UpdateBoardPostCommand;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class BoardPost {
    @Id
    private Long id;
    private String title;
    private String content;
    @Setter
    private LocalDateTime deleted;

    @Setter
    @ManyToOne
    private Board board;

    @OneToMany(mappedBy = "boardPost", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BoardPostComment> comments;

    public void update(UpdateBoardPostCommand command) {
        this.title = command.title();
        this.content = command.content();
    }

}
