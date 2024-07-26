package kr.co.milkt.demo.board.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class BoardPostComment {
    @Id
    private Long id;

    @Setter
    @ManyToOne
    private BoardPost boardPost;
    private LocalDateTime deleted;
}
