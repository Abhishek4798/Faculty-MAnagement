package login.submit.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class leaveDAOImpl implements leaveDAO {
	static Connection con;
	static PreparedStatement ps,ps1,ps2;
	@Override
	public String checkStatus(String Username) {
		String status=null;
		int j=0;
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("Select * from leave_status where user_name=?");
			ps.setString(1,Username);
			ResultSet rs=ps.executeQuery();
			int i=0;
			while(rs.next()) {
				i++;
			status=rs.getString("status");
			if(!status.contentEquals("pending")) {
				System.out.print("hey");
				try {
					ps1=con.prepareStatement("Delete from leave_status where user_name=?");
					ps1.setString(1,Username);
					j=ps1.executeUpdate();
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			}
			con.close();
			System.out.println("leave status");
			if(i==0) {
				status="No Leave Applied";
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}

		return status;
	}

	@Override
	public int addleave(String user_name) {
		con=MyConnectionProvider.getCon();
		int i=0;
		try {
			System.out.print(" jhgfds"+user_name);
			ps1=con.prepareStatement("Select * from leave_status where user_name=?");
			ps1.setString(1,user_name);
			ResultSet rs=ps1.executeQuery();
			while(rs.next()) {
			System.out.print(" jhgfds"+rs.getString("user_name"));
			try {
			ps=con.prepareStatement("insert into leave_record values(?,?,?,?)");
			ps.setString(1,rs.getString("user_name"));
			ps.setString(2,rs.getString("type"));
			ps.setDate(3, rs.getDate("l_from"));
			ps.setDate(4,rs.getDate("l_to"));
			i=ps.executeUpdate();
			try {
				ps2=con.prepareStatement("update leave_status set status=? where user_name=?");
				ps2.setString(1,"approved");
				ps2.setString(2,user_name);
				i=ps2.executeUpdate();
				}
				catch(Exception e) {
					System.out.println(e);
				}
			}
			catch(Exception e) {
				System.out.println(e);
			}
			}
			
			System.out.println("approved");
			
			
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return i;
	}

	@Override
	public int applyLeave(leave l) {
		java.sql.Date l_from = new java.sql.Date(l.getL_from().getTime());
		java.sql.Date l_to = new java.sql.Date(l.getL_to().getTime());
		System.out.println(l.getUser_name()+" " +l.getType()+" " +l_from+" " +l_to);
		int status=0;
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("insert into leave_status values(?,?,?,?,?)");
			ps.setString(1,l.getUser_name());
			ps.setString(2,"pending");
			ps.setString(3, l.getType());
			ps.setDate(4,l_from);
			ps.setDate(5,l_to);
			status=ps.executeUpdate();
			con.close();
			System.out.println("leave applied");
		}
		catch(Exception e) {
			System.out.println(e);
		}

		return 0;
	}

	@Override
	public List<leave> leavelist() {
		List<leave> list=new ArrayList<>();
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("select * from leave_status where status=?");
			ps.setString(1,"pending");
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				leave l=new leave();
				l.setUser_name(rs.getString("user_name"));
				l.setType(rs.getString("type"));
				l.setL_from(rs.getDate("l_from"));
				l.setL_to(rs.getDate("l_to"));
				list.add(l);
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}

		return list;
	}

	@Override
	public int cancelleave(String user_name) {
		int j=0;
		con=MyConnectionProvider.getCon();
		try {
			ps2=con.prepareStatement("update leave_status set status=? where user_name=?");
			ps2.setString(1,"cancelled");
			ps2.setString(2,user_name);
			j=ps2.executeUpdate();
			con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		
		return j;
	}

	@Override
	public List<leave> showleaves(Date l_from, Date l_to) {
		List<leave> list=new ArrayList<leave>();
		java.sql.Date R_from = new java.sql.Date(l_from.getTime());
		java.sql.Date R_to = new java.sql.Date(l_to.getTime());
		con=MyConnectionProvider.getCon();
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("select * from leave_record where l_from>=? and l_to<=?");
			ps.setDate(1,R_from);
			ps.setDate(2, R_to);
			
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				leave l=new leave();
				l.setUser_name(rs.getString("user_name"));
				l.setType(rs.getString("type"));
				l.setL_from(rs.getDate("l_from"));
				l.setL_to(rs.getDate("l_to"));
				list.add(l);
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
