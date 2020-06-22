package login.submit.registration;

import java.util.Date;

public class leave {
	private String user_name;
	private String type;
	private Date l_from;
	private Date l_to;
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Date getL_from() {
		return l_from;
	}
	public void setL_from(Date l_from) {
		this.l_from = l_from;
	}
	public Date getL_to() {
		return l_to;
	}
	public void setL_to(Date l_to) {
		this.l_to = l_to;
	}
}
