package com.jubu.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

@Entity
@Table(name = "user") // DB 테이블 이름은 user이므로 명시해줍니다!
//Lombok 인식이 안 되는 것 같아서 추후 수정 예정 
public class Auth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(nullable = false, unique = true)
    private String username;

    private String password;

    private String nickname;
    
    @Column(name = "reg_date", insertable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;
    
    @Column(name = "mod_date", insertable = false, updatable = false)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modDate;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public LocalDateTime getModDate() {
		return modDate;
	}

	public void setModDate(LocalDateTime modDate) {
		this.modDate = modDate;
	}
}