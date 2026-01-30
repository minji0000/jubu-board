package com.jubu.entity;

import javax.persistence.*;

import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = false) //부모 필드들은 신경쓰지마 
@Entity
@Table(name = "user") // DB 테이블 이름은 user이므로 명시해줍니다!
public class Auth extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    private String nickname;
}