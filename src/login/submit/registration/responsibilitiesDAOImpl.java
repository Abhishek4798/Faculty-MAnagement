package login.submit.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List; 

public class responsibilitiesDAOImpl implements responsibilitiesDAO {
	static Connection con;
	static PreparedStatement ps,ps1;
	@Override
	public List<responsibility> getresponsibilities(String Username) {
		List<responsibility> r=new ArrayList<>();
		
		 java.util.Date currentDate = new java.util.Date();
		java.sql.Date Current = new java.sql.Date(currentDate.getTime());
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("Select * from r_record where user_name=? and r_to>=?");
			ps.setString(1,Username);
			ps.setDate(2,Current);
			System.out.println("responsibility"+""+Username+""+Current);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				responsibility R=new responsibility();
				R.setUser_name(Username);
				R.setR_from(rs.getDate("r_from"));
				R.setR_to(rs.getDate("r_to"));
				R.setR_id(rs.getString("r_id"));
				try {
					ps1=con.prepareStatement("Select r_name from responsibility where r_id=?");
					ps1.setString(1, rs.getString("r_id"));
					ResultSet rs1=ps1.executeQuery();
					while(rs1.next()) {
						System.out.println(rs1.getString("r_name"));
						R.setR_name(rs1.getString("r_name"));
						
					}
				}
				catch(Exception e) {
					System.out.println("finding resp error");
				}
				r.add(R);
			}
			
		}
		catch(Exception e) {
			System.out.println("Responsibility error");
		}
		return r;
	}
	@Override
	public int addresponsibility(String r_id, String r_name) {
		int status=0;
		System.out.println(r_id+" "+r_name);
		try {
			con=MyConnectionProvider.getCon();
			System.out.println(r_name);
			ps=con.prepareStatement("insert into responsibility values(?,?)");
			ps.setString(1, r_id);
			ps.setString(2,r_name);
			status=ps.executeUpdate();
			con.close();
			System.out.println("Responsibility added");
		}
		catch(Exception e) {
			System.out.println("Responsibility add error");
		}
		
		return status;
	}
	@Override
	public void removeresponsibility(String r_id) {
		int status=0;
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("Delete from responsibility where r_id=?");
			ps.setString(1,r_id);
			status=ps.executeUpdate();
			con.close();
			System.out.println("removed");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return;
	}
	@Override
	public int assignresponsibility(String user_name, String r_id, String r_from, String r_to) {

		int status=0;
		try {
			con=MyConnectionProvider.getCon();
					ps=con.prepareStatement("insert into r_record values(?,?,?,?)");
					ps.setString(1,user_name);
					ps.setString(2,r_id);
					SimpleDateFormat Formatter = new SimpleDateFormat("dd-MM-yyyy");
					java.util.Date FROM = Formatter.parse(r_from);
					java.sql.Date from = new java.sql.Date(FROM.getTime());
					java.util.Date TO = Formatter.parse(r_to);
					java.sql.Date to= new java.sql.Date(TO.getTime());
					ps.setDate(3,from);
					ps.setDate(4,to);
					System.out.println(user_name+"\n"+r_id);
					System.out.println("this is conversion"+" "+from+" \t"+to);
					status=ps.executeUpdate();
					System.out.println("assigned ");
				
				
			
		
			con.close();
			
		}
		catch(Exception e) {
			System.out.println("assign resp error");
		}
		return status;
		
	}
	@Override
	public List<responsibility> rlist() {
		List<responsibility> rlist=new ArrayList<responsibility>();
		
		//System.out.print("working");
		try {
			con=MyConnectionProvider.getCon();
			ps=con.prepareStatement("select * from responsibility");
		ResultSet rs=ps.executeQuery();
		while(rs.next()) {
			responsibility r=new responsibility();
			r.setR_id(rs.getString("r_id"));
			r.setR_name(rs.getString("r_name"));
			r.setR_from(null);
			r.setR_to(null);
			r.setUser_name(null);
			//System.out.println(r.getR_id()+" "+r.getR_name());
			rlist.add(r);
		}
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		/*for(int i=0;i<rlist.size();i++){
			System.out.println(rlist.get(i).getR_id()+" "+rlist.get(i).getR_name());
		}*/
		return rlist;
	}
	@Override
	public List<responsibility> show(Date r_from, Date r_to) {
		List<responsibility> list=new ArrayList<responsibility>();
		java.sql.Date R_from = new java.sql.Date(r_from.getTime());
		java.sql.Date R_to = new java.sql.Date(r_to.getTime());
		con=MyConnectionProvider.getCon();
		try {
			ps=con.prepareStatement("select * from r_record where r_from>=? and r_to<=?");
			ps.setDate(1,R_from);
			ps.setDate(2,R_to);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				responsibility R=new responsibility();
				R.setUser_name(rs.getString("user_name"));
				R.setR_from(rs.getDate("r_from"));
				R.setR_to(rs.getDate("r_to"));
				R.setR_id(rs.getString("r_id"));
				try {
					ps1=con.prepareStatement("Select r_name from responsibility where r_id=?");
					ps1.setString(1, rs.getString("r_id"));
					ResultSet rs1=ps1.executeQuery();
					while(rs1.next()) {
						//System.out.println(rs1.getString("r_name"));
						R.setR_name(rs1.getString("r_name"));
						
					}
				}
				catch(Exception e) {
					System.out.println("finding resp error");
				}
				list.add(R);
			
			}
			con.close();
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
		return list;
	}

}
