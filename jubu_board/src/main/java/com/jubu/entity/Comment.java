package com.jubu.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false) //부모 필드들은 신경쓰지마 
@Entity
@Table(name = "comment")
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Integer commentId;

    @Column(name = "board_id")
    private Integer boardId;

    @Column(name = "writer_id")
    private Integer writerId;

    private String content;

    @Column(name = "parent_id")
    private Integer parentId;

    @Transient 
    private List<Comment> children = new ArrayList<>();
}