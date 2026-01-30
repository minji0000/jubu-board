package com.jubu.dto;

import java.time.LocalDateTime;
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
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime modDate;
    
    // 트리 구조를 위한 자식 리스트
    private List<CommentDTO> children = new ArrayList<>();

}