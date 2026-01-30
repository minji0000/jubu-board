package com.jubu.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode; 

@Data
@EqualsAndHashCode(callSuper = false) //부모 필드들은 신경쓰지마 
@Entity
@Table(name = "board")
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id") // DB의 board_id 컬럼과 연결
    private Integer boardId; // PK (자동 증가)

    @Column(name = "writer_id")
    private String writerId;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private int view; // 조회수
    private int good; // 좋아요 수
}