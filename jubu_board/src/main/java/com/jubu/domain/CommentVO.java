package com.jubu.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class CommentVO {
    private int commentId;      // comment_id (PK)
    private int boardId;        // board_id (FK)
    private String writerId;    // writer_id (작성자 ID ex:3)
    private String content;     // content
    private Integer parentId;   // parent_id (부모 댓글 ID, 대댓글이 아니면 null)
    private Date regDate;       // reg_date

    // ★ 대댓글들
    private List<CommentVO> children = new ArrayList<>();

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Date getRegDate() {
		return regDate;
	}

	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}

	public List<CommentVO> getChildren() {
		return children;
	}

	public void setChildren(List<CommentVO> children) {
		this.children = children;
	}
    
}