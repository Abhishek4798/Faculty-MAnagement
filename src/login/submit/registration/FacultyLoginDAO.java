package login.submit.registration;

import java.util.List;

public interface FacultyLoginDAO {
	public int insertFacultyLogin(Faculty f);
	public FacultyLogin getFacultyLogin(String username,String pass);
	public List<String> facultylist();
	public Faculty getdetails(String Username);
	}
