package com.jubu.dto;

import java.time.Instant;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class BoardDTO {
    private Integer boardId;
    private String title;
    private String content;
    private String writerId;
    
    private int view;
    private int good;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Instant regDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Instant modDate;

}