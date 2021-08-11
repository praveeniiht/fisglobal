package com.example.noteservice.model;

public class CommentDto {
	
	int commentId;
	int pid;
	String fromAuthor;
	String toAuthor;
	String comment;
	public CommentDto() {
		
	}
	
	public CommentDto(int commentId, int pid, String fromAuthor, String toAuthor, String comment) {
		super();
		this.commentId = commentId;
		this.pid = pid;
		this.fromAuthor = fromAuthor;
		this.toAuthor = toAuthor;
		this.comment = comment;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getFromAuthor() {
		return fromAuthor;
	}
	public void setFromAuthor(String fromAuthor) {
		this.fromAuthor = fromAuthor;
	}
	public String getToAuthor() {
		return toAuthor;
	}
	public void setToAuthor(String toAuthor) {
		this.toAuthor = toAuthor;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
}
