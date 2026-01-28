package com.jubu.domain;

import java.util.Date;
import lombok.Data;

@Data
public class BoardVO {
    private int boardId;      // board_id (PK)
    private String writerId;  // writer_id (작성자 ID)
    private String title;     // title
    private String content;   // content
    private int view;         // view (조회수)
    private int good;         // good (추천수)
    private Date modDate;     // mod_date (수정일)
    private Date regDate;     // reg_date (등록일)
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getWriterId() {
		return writerId;
	}
	public void setWriterId(String writerId) {
		this.writerId = writerId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public int getGood() {
		return good;
	}
	public void setGood(int good) {
		this.good = good;
	}
	public Date getModDate() {
		return modDate;
	}
	public void setModDate(Date modDate) {
		this.modDate = modDate;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
    
    
}