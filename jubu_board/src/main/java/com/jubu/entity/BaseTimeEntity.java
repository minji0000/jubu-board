package com.jubu.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
// @EntityListeners(AuditingEntityListener.class) // <-- 일단 주석!
public abstract class BaseTimeEntity {

    // @CreatedDate // <-- 일단 주석!
    @Column(updatable = false)
    private Instant regDate;
    
    // @LastModifiedDate // <-- 일단 주석!
    private Instant modDate;
    
    private Instant deletedDate; // 삭제 시점 기록용

    private boolean isDeleted = false; // Soft Delete 여부 (기본값 false)

    // 자동으로 안 채워주니까, 데이터 넣을 때 수동으로 넣어줄 메서드를 만듭니다.
    @PrePersist
    public void prePersist() {
    	Instant now = Instant.now();
    	this.regDate = now;
        this.modDate = now;
    }

    @PreUpdate
    public void preUpdate() {
        this.modDate = Instant.now();
    }
    
    // 삭제 시 호출할 편의 메서드
    public void delete() {
        this.isDeleted = true;
        this.deletedDate = Instant.now();
    }
}