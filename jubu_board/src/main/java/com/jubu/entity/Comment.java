package com.jubu.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
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

    @Column(name = "content")
    private String content;

    @Column(name = "parent_id")
    private Integer parentId;

}