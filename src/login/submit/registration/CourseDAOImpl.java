package login.submit.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class CourseDAOImpl implements CourseDAO {
static Connection con=null;
static Connection con1=null;
static PreparedStatement ps=null;
static PreparedStatement ps1=null;
	@Override
	public int addcourse(Course c) {
	int status=0;
	try {
		con=MyConnectionProvider.getCon();
		ps=con.prepareStatement("insert into course values(?,?)");
		ps.setString(1, c.getC_id());
		ps.setString(2,c.getCourse_name());
		status=ps.executeUpdate();
		con.close();
		
	}
	catch(Exception e) {
		System.out.println(e);
	}
		return status;
	}

	@Override
	public int removecourse(String c) {
	    int status=0;
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("Delete from course where c_id=?");
			ps.setString(1,c);
			status=ps.executeUpdate();
			con.close();
			System.out.println("removed");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return status;
	}
	
	@Override
	public List<Course> list() {
		List<Course> courselist=new ArrayList<Course>();
		
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("Select * from course");
			
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next()) {
				Course c=new Course();
				c.setC_id(rs.getString("c_id"));
				c.setCourse_name(rs.getString("course_name"));
				courselist.add(c);	
			//	System.out.print(courselist.get(i++).getCourse_name());
				
			}
			con.close();
			
		}
		catch(Exception e) {
			System.out.println("hi");
		}

		return courselist;
	}

	@Override
	public int assigncourse(String assign_faculty, String assign_course,String year,String semester,String batch) {
		int i=0;
		try {
			con=MyConnectionProvider.getCon();
			System.out.print(assign_course);
			System.out.print(assign_faculty);
			System.out.print(year);
			System.out.print(batch);
			System.out.print(semester);
			ps=con.prepareStatement("Select * from course_record where user_name=? and c_id=? and year=? and semester=? and batch=?");
			ps.setString(1,assign_faculty);
			ps.setString(2,assign_course);
			ps.setString(3,year);
			ps.setString(4,semester);
			ps.setString(5,batch);
			ResultSet rs=ps.executeQuery();
			
				if(rs.next()==false){
				System.out.println("hihiihih");
				i=0;
				try {
					ps=con.prepareStatement("insert into course_record values(?,?,?,?,?)");
					ps.setString(1,assign_faculty);
					ps.setString(2,assign_course);
					ps.setString(3,year);
					ps.setString(4,semester);
					ps.setString(5,batch);
					ps.executeUpdate();
					System.out.println("assigned");
				}
				catch(Exception e) {
					System.out.println("hi");
				}
			}
			else {
				i=1;
			}
		
			con.close();
			
		}
		catch(Exception e) {
			System.out.println("hiAbhishek");
		}
		return i;
	}

	@Override
	public List<String> coursedetails(String Username) {
		System.out.println("coursedetails"+Username);
		LocalDate currentDate = LocalDate.now(); 
		int m = currentDate.getMonthValue();
		String y = Integer.toString(currentDate.getYear());
		String sem=null;
		List<String> c=new ArrayList<>();
		if(m>=7) {
			sem="odd";
		}
		else {
			sem="even";
		}
	//	System.out.print(sem+" "+y+" "+Username);
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("Select * from course_record where user_name=? and semester=? and year=?");
			ps.setString(1,Username);
			ps.setString(2,sem);
			ps.setString(3,y);
			ResultSet rs=ps.executeQuery();
			
			int i=0;
			while(rs.next()) {
			try {
				con1=MyConnectionProvider.getCon();
				ps1=con1.prepareStatement("Select course_name from course where c_id=?");
				ps1.setString(1, rs.getString("c_id"));
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next()) {
					c.add(rs1.getString("course_name"));
				}
				con1.close();
			}
			
			catch(Exception e) {
				System.out.println("Second Query");
			}
			c.add(rs.getString("batch"));
			System.out.print(c.get(i)+" "+c.get(i+1));
			i=i+2;
				
			}
			con.close();
			//System.out.println("removed");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return c;
	}

	@Override
	public List<courserecord> showcourses(String year, String sem) {
		System.out.println(year+sem);
		List<courserecord> list=new ArrayList<>();
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("Select * from course_record where year=? and semester=?");
			ps.setString(1,year);
			ps.setString(2,sem);
			ResultSet rs=ps.executeQuery();
			int i=1;
			while(rs.next()) {
				courserecord c=new courserecord();
				c.setUser_name(rs.getString("user_name"));
				c.setBatch(rs.getString("batch"));
				try {
					ps1=con.prepareStatement("Select * from course where c_id=?");
					ps1.setString(1,rs.getString("c_id"));
					ResultSet rs1=ps1.executeQuery();
					while(rs1.next()) {
						c.setC_name(rs1.getString("course_name"));
					}
				}
				catch(Exception e) {
					System.out.println("hi");
				}
				list.add(c);	
			//	System.out.print(courselist.get(i++).getCourse_name());
				
			}
			con.close();
			
		}
		catch(Exception e) {
			System.out.println("hi");
		}
		return list;
	}

	

}
