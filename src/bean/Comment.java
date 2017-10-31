package bean;
import java.util.*;
import java.text.*;
public class Comment {
	public static final int CTYPE_TEXT = 0;
	public static final int CTYPE_PICTURE = 1;
	
	private int cID;
	private Date cTime;
	private String content;
	private int cType;
	private String username;
	private int gID;
	private String replyname;
	private List<Comment> childList;
	
	public Comment(){
		
	}

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public Date getcTime() {
		return cTime;
	}

	public void setcTime(Date cTime) {
		this.cTime = cTime;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getcType() {
		return cType;
	}

	public void setcType(int cType) {
		this.cType = cType;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getgID() {
		return gID;
	}

	public void setgID(int gID) {
		this.gID = gID;
	}

	public String getReplyname() {
		return replyname;
	}

	public void setReplyname(String replyname) {
		this.replyname = replyname;
	}

	public List<Comment> getChildList() {
		return childList;
	}

	public void setChildList(List<Comment> childList) {
		this.childList = childList;
	}

}