package kr.co.milkt.demo.board.domain.entity;

import jakarta.persistence.*;
import kr.co.milkt.demo.board.domain.command.CreateBoardPostCommand;
import kr.co.milkt.demo.board.domain.command.UpdateBoardCommand;
import kr.co.milkt.demo.board.domain.command.UpdateBoardPostCommand;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Setter
    private LocalDateTime deleted;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BoardPost> posts;

    public void addPost(CreateBoardPostCommand command) {
        BoardPost newPost = BoardPost.builder()
                .title(command.title())
                .content(command.content())
                .board(this)
                .build();
        posts.add(newPost);
    }

    public void update(UpdateBoardCommand command) {
        this.name = command.name();
    }

    public Optional<BoardPost> findPostById(Long postId) {
        return posts.stream()
                .filter(p -> p.getId().equals(postId))
                .findFirst();
    }

    public void updatePost(UpdateBoardPostCommand command) {
        BoardPost post = findPostById(command.boardId()).orElseThrow();
        post.update(command);
    }

    public void deletePost(Long postId, LocalDateTime now) {
        BoardPost post = findPostById(postId).orElseThrow();
        post.setDeleted(now);
    }
}
