package login.submit.registration;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FacultyDAOImpl implements FacultyLoginDAO {
static Connection con;
static PreparedStatement ps,ps2,ps3;
	@Override
	public int insertFacultyLogin(Faculty f) {
		int status=0;
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("insert into Faculty values(?,?,?,?,?,?,?,?,?)");
			ps2=con.prepareStatement("insert into login values(?,?)");
			ps3=con.prepareStatement("insert into F_Address values(?,?,?,?,?,?,?");
			ps.setString(1, f.getUsername());
			ps.setString(2,f.getTitle());
			ps.setString(3, f.getFname());
			ps.setString(4,f.getLname());
			ps.setString(5, f.getDepartment());
			ps.setString(6,f.getEmail());
			ps.setString(7, f.getPhone());
			long dob=f.getDOB().getTime();
			java.sql.Date DOB=new java.sql.Date(dob);
			ps.setDate(8,DOB);
			long doj=f.getDOJ().getTime();
			java.sql.Date DOJ=new java.sql.Date(doj);
			ps.setDate(9,DOJ);
			status=ps.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println("1");
		}
		try {
			con=MyConnectionProvider.getCon();
			ps2=con.prepareStatement("insert into login values(?,?)");
			ps2.setString(1,f.getUsername());
			ps2.setString(2,f.getPassword());
			status=ps2.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println("2");
		}
		try {
			con=MyConnectionProvider.getCon();
			ps3=con.prepareStatement("insert into F_Address values(?,?,?,?,?,?,?)");
			ps3.setString(1,f.getUsername());
			ps3.setString(2,f.getHouse_no());
			ps3.setString(3,f.getDistrict());
			ps3.setString(4,f.getPin());
			ps3.setString(5,f.getState());
			ps3.setString(6,f.getCountry());
			ps3.setString(7,f.getCity());
			status=ps3.executeUpdate();
			con.close();
		}catch(Exception e) {
			System.out.println("3");
		}
		return 0;
	}

	@Override
	public FacultyLogin getFacultyLogin(String username, String pass) {
		FacultyLogin f=new FacultyLogin();
		try {
			
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("select * from login where user_name=? and password=?");
		ps.setString(1,username);
		ps.setString(2,pass);
		
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			f.setUsername(rs.getString(1));
			f.setPassword(rs.getString(2));
		}
		}catch(Exception e) {
			System.out.println(e);
		}
	
		return f;
	}
	
	public List<String> facultylist() {
		List<String> list=new ArrayList<String>();
		
			try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("Select * from faculty");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				String f=rs.getString("user_name");
			//	System.out.print(f+"hi");
				if(!f.contentEquals("Admin")) {
				list.add(f);
				}
		//	System.out.print(f);
				
			}
			con.close();
			}
		catch(Exception e) {
			System.out.println("hihihi");
		}

		return list;
	}

	@Override
	public Faculty getdetails(String Username) {
		Faculty f=new Faculty();
		System.out.print(Username);
		try {
		con=MyConnectionProvider.getCon();
		ps=con.prepareStatement("Select * from faculty where user_name=?");
		ps.setString(1,Username);
	ResultSet rs=ps.executeQuery();
		while(rs.next() ) {
			f.setUsername(rs.getString("user_name"));
			f.setFname(rs.getString("fname"));
			f.setTitle(rs.getString("title"));
			f.setLname(rs.getString("lname"));
			f.setDepartment(rs.getString("department"));
			f.setEmail(rs.getString("email"));
			f.setPhone(rs.getString("phone"));
			f.setDOB(rs.getDate("DOB"));
			f.setDOJ(rs.getDate("DOJ"));
			
		//System.out.print("Welcome"+f.getDOB());
		}
		con.close();
		}
	catch(Exception e) {
		System.out.println("hihihi");
	}

		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("Select * from f_address where user_name=?");
			ps.setString(1,Username);
			ResultSet rs=ps.executeQuery();
			while(rs.next() ) {
				f.setHouse_no(rs.getString("houseno"));
				f.setCity(rs.getString("city"));
				f.setDistrict(rs.getString("district"));
				f.setState(rs.getString("state"));
				f.setPin(rs.getString("pin"));
				f.setCountry(rs.getString("country"));
		//	System.out.println("Welcome2"+f.getCity());
			}
			con.close();
			}
		catch(Exception e) {
			System.out.println("hihihi");
		}
		return f;
	}

}
