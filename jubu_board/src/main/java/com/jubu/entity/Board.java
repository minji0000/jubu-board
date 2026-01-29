package com.jubu.entity;

import javax.persistence.*; 

@Entity
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id") // DB의 board_id 컬럼과 연결
    private Long BoardId; // PK (자동 증가)

    @Column(name = "writer_id")
    private String writerId;
    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    private int view; // 조회수
    private int good; // 좋아요 수

    private String modDate; // 수정일 (자동 업데이트)

    private String regDate; // 등록일 (자동 생성)


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

	public Long getBoardId() {
		return BoardId;
	}

	public void setBoardId(Long boardId) {
		BoardId = boardId;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
}