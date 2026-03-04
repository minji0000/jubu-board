package com.jubu.entity;

import lombok.*;
import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 1. 테이블명 'user'는 DB 예약어일 수 있으므로 @Table(name = "user")로 확실히 명시.
 * 2. 레거시 환경의 Naming Strategy 이슈 방지를 위해 모든 컬럼에 @Column(name) 추가.
 */
@Data
@EqualsAndHashCode(callSuper = false) 
@Entity
@Table(name = "user")
@Getter
@Setter
@Builder           // 빌더 패턴으로 객체 생성 가능하게
@AllArgsConstructor // 빌더가 쓸 생성자
@NoArgsConstructor  // JPA가 쓸 생성자
public class Auth extends BaseTimeEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id") // DB 컬럼: user_id
    private Integer userId;

    @Column(name = "username", nullable = false, unique = true) // 아이디
    private String username;

    @Column(name = "password", nullable = false) // 비밀번호
    private String password;

    @Column(name = "nickname") // 닉네임
    private String nickname;
}