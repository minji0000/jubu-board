package com.jubu.entity;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.time.Instant;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // JPA Auditing 활성화
public abstract class BaseTimeEntity {

    /**
     * [민지님 메모] 
     * 스프링 레거시 환경에서 카멜케이스 필드명을 스네이크케이스 컬럼명으로 
     * 자동 변환하지 못하는 설정 이슈를 방지하기 위해 @Column(name)을 명시함.
     */

    @CreatedDate
    @Column(name = "reg_date", updatable = false) // 등록일은 처음 생성 시에만 저장
    private Instant regDate;
    
    @LastModifiedDate
    @Column(name = "mod_date") // 수정 시마다 자동으로 시간 업데이트
    private Instant modDate;
    
    @Column(name = "deleted_date") // 삭제 시점 기록 (null이면 미삭제, 값이 있으면 삭제된 것)
    private Instant deletedDate;

    // 논리 삭제(Soft Delete)를 위한 메서드
    public void delete() {
        this.deletedDate = Instant.now();
    }
}