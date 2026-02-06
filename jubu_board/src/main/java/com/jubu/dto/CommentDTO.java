package com.jubu.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class CommentDTO {
    private Integer commentId;
    private Integer boardId;
    private Integer writerId;
    private String content;
    private Integer parentId;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Instant regDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Instant modDate;
    
    // 트리 구조를 위한 자식 리스트
    private List<CommentDTO> children = new ArrayList<>();

}