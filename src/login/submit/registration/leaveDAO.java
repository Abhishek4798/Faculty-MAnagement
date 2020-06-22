package login.submit.registration;

import java.util.Date;
import java.util.List;

public interface leaveDAO {

	public String checkStatus(String Username);
	public int addleave(String user_name);
	public int applyLeave(leave l);
	public int cancelleave(String user_name);
	public List<leave> leavelist();
	public List<leave> showleaves(Date l_from,Date l_to);
}
