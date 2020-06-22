package login.submit.registration;

import java.util.List;

public interface CourseDAO {
	public int addcourse(Course c);
	public int removecourse(String c);
	public int assigncourse(String faculty,String c_id,String year,String semester,String batch);
	public List<Course> list();
	public List<String> coursedetails(String Username);
	public List<courserecord> showcourses(String year,String sem);

}
