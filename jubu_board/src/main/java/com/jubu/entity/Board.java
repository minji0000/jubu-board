package com.jubu.entity;

import lombok.*;
import javax.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

/**
 * 1. 스프링 레거시(XML 설정) 환경에서는 스프링 부트와 달리 '카멜케이스 -> 스네이크케이스' 자동 변환 설정이 까다로움.
 * 2. @Column(name = "...")을 명시하여 DB 컬럼명과 필드명을 1:1로 직접 매핑 (가장 확실하고 안전한 방법).
 * 3. 별도의 네이밍 전략(NamingStrategy) 설정 없이도 서버 기동 및 쿼리 실행 시 에러를 방지함.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "board")
// 삭제 시 실제로 Delete 하지 않고 deleted_date에 현재 시간을 기록 (Soft Delete)
@SQLDelete(sql = "UPDATE board SET deleted_date = NOW() WHERE board_id = ?")
// 조회 시 deleted_date가 null인(삭제되지 않은) 데이터만 필터링
@Where(clause = "deleted_date IS NULL")
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id") 
    private Integer boardId;

    @Column(name = "writer_id") 
    private String writerId;

    @Column(name = "title")
    private String title;

    @Column(name = "content", columnDefinition = "TEXT")
    private String content;

    @Column(name = "view")
    private int view;

    @Column(name = "good")
    private int good;
}