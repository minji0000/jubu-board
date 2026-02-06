package com.jubu.entity;

import lombok.*;
import javax.persistence.*;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;


@Data
@EqualsAndHashCode(callSuper = false) //부모 필드들은 신경쓰지마 
@Entity
@Table(name = "board")
@SQLDelete(sql = "UPDATE board SET is_deleted = true WHERE board_id = ?")
@Where(clause = "is_deleted = false")
// 2. JPA를 위한 필수 생성자 추가
@NoArgsConstructor 
@AllArgsConstructor
@Builder // 나중에 객체 생성할 때 편해요!
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
    
    @Builder.Default
    @Column(name = "is_deleted")
    private boolean isDeleted = false;
}