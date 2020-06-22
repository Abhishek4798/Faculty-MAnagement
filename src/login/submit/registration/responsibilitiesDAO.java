package login.submit.registration;

import java.util.Date;
import java.util.List;

public interface responsibilitiesDAO {

	public List<responsibility> getresponsibilities(String Username);
	public int addresponsibility(String r_id,String r_name);
	public void removeresponsibility(String r_id);
	public int assignresponsibility(String user_name,String r_id,String r_from,String r_to);
	public List<responsibility> rlist();
	public List<responsibility> show(Date r_from,Date r_to);
}
