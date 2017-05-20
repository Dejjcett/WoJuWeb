package entity;

public class ActivityInfor {
	
	
//		String Username=null;
	private static String activityID=null;
	private static String actName=null;
	private static String deadtime=null;
	private static String starttime=null;	
	private static String type=null;
	private static int member=0;
	private static String actabstract=null;
	private static String Content=null;
	private static String releaser=null;
	
	
	public static String getReleaser() {
		return releaser;
	}
	public static void setReleaser(String releaser) {
		ActivityInfor.releaser = releaser;
	}
	public static String getActivityID() {
		return activityID;
	}
	public static void setActivityID(String activityID) {
		ActivityInfor.activityID = activityID;
	}
	public static String getActName() {
		return actName;
	}
	public static void setActName(String actName) {
		ActivityInfor.actName = actName;
	}
	public static String getDeadtime() {
		return deadtime;
	}
	public static void setDeadtime(String deadtime) {
		ActivityInfor.deadtime = deadtime;
	}
	public static String getStarttime() {
		return starttime;
	}
	public static void setStarttime(String starttime) {
		ActivityInfor.starttime = starttime;
	}
	public static String getType() {
		return type;
	}
	public static void setType(String type) {
		ActivityInfor.type = type;
	}
	public static int getMember() {
		return member;
	}
	public static void setMember(int member) {
		ActivityInfor.member = member;
	}
	public static String getActabstract() {
		return actabstract;
	}
	public static void setActabstract(String actabstract) {
		ActivityInfor.actabstract = actabstract;
	}
	public static String getContent() {
		return Content;
	}
	public static void setContent(String content) {
		Content = content;
	}
	
	
	
}
