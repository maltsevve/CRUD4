package com.maltsevve.crud4.model;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "posts")
@Data @Getter @Setter @NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PostId")
    private Long id;
    @Column(name = "Content")
    private String content;
    @Column(name = "Created")
    private Date created;
    @Column(name = "Updated")
    private Date updated;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "UserId")
    private User user;
}
