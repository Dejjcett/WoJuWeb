package entity;

public class Comment {
	private static String comId =null;
	private static String reviewer =null;
	private static String actId = null;
	private static String comment =null;
	public static String getComId() {
		return comId;
	}
	public static void setComId(String comId) {
		Comment.comId = comId;
	}
	public static String getReviewer() {
		return reviewer;
	}
	public static void setReviewer(String reviewer) {
		Comment.reviewer = reviewer;
	}
	public static String getActId() {
		return actId;
	}
	public static void setActId(String actId) {
		Comment.actId = actId;
	}
	public static String getComment() {
		return comment;
	}
	public static void setComment(String comment) {
		Comment.comment = comment;
	}
	
}
