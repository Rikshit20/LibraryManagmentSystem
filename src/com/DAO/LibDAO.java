package com.DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.Bean.books;
import com.Bean.StudentInfo;
import com.Bean.lmanage;
import com.Configure.Data_Connection;
import com.mysql.cj.protocol.Resultset;

public class LibDAO {
	Scanner sc = new Scanner(System.in);
	lmanage lm = new lmanage();
	books b = new books();
	StudentInfo ls = new StudentInfo();
	int rs = 0;
	int rs1 = 0;

	public void addBook(Connection con) {
		String sql = "insert into books(bid, bname, nocopies, price, auname) values(?,?,?,?,?)";

		System.out.println("Enter bid");
		int bid = sc.nextInt();
		
		System.out.println("Enter bname");
		String bname = sc.next();
		
		System.out.println("Enter  nocopies");
		int nocopies = sc.nextInt();
		
		System.out.println("Enter price");
		int price = sc.nextInt();
		
		System.out.println("Enter auname");
		String auname = sc.next();
		

		b.setBid(bid);
		b.setBname(bname);
		b.setNocopies(nocopies);
		b.setPrice(price);
		b.setAuname(auname);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, b.getBid());
			ps.setString(2, b.getBname());
			ps.setInt(3, b.getNocopies());
			ps.setInt(4, b.getPrice());
			ps.setString(5, b.getAuname());
			ps.executeUpdate();
			System.out.println(" Data succesufully Added!");
		} 
		catch (Exception e) 
		{
			System.out.println("Data insuffient "+e.toString());
		}

	}

	public void deleteBook(Connection con) {
		String sql = "delete from books  where bid=?";
		System.out.println("Enter book id");
		int bid = sc.nextInt();

		b.setBid(bid);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, b.getBid());
			ps.execute();
			System.out.println("Data Successfully Deleted");
		} catch (Exception e) {
			System.out.println("Data can't Deleted");
		}
	}

	public void updateData(Connection con) {
		String sql = "update books set auname=?,price=? where bid=?";
		System.out.println("Enter book id");
		int bid = sc.nextInt();

		System.out.println("Enter Author Name");
		String auname = sc.next();

		System.out.println("Enter price");
		int price = sc.nextInt();

		b.setBid(bid);
		b.setAuname(auname);
		b.setPrice(price);

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(3, b.getBid());
			ps.setString(1, b.getAuname());
			ps.setInt(2, b.getPrice());
			rs = ps.executeUpdate();
			System.out.println("Data successfully Updated");

		} catch (Exception e) {
			System.out.println("Insufficient data");
			e.printStackTrace();
		}
	}

	public void searchData(Connection con) {
		String sql = "select * from books where  bname =?;";

		
		System.out.println("Enter Book name");
		String bname = sc.next();

		b.setBname(bname);

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, b.getBname());
			
			System.out.println(sql+"yes");
			ResultSet rs2 = ps.executeQuery();
			
			if (rs2.next()) {
				System.out.println("book id::" + rs2.getInt(1));
				System.out.println("book name::" + rs2.getString(2));
				System.out.println("nocopies::" + rs2.getInt(3));
				System.out.println("price::" + rs2.getInt(4));
				System.out.println("author name::" + rs2.getString(5));
				
			} else {
				System.out.println("Give proper name");
			}

		} catch (SQLException e) {
			System.out.println("Give proper book_name");
			e.printStackTrace();
		}
	}

	public void addMember(Connection con) {
		String sql = "insert into studentinfo (sid, sname, gender, saddress) values(?,?,?,?)";
		System.out.println("Enter stud_id");
		int sid = sc.nextInt();

		System.out.println("Enter name");
		String sname = sc.next();

		System.out.println("Enter gender");
		String gender = sc.next();

		System.out.println("Enter address");
		String saddress = sc.next();

		
		ls.setSid(sid);
		ls.setSname(sname);
		ls.setGender(gender);
		ls.setSaddress(saddress);
		
		System.out.println(ls);

		try {
			PreparedStatement ps = con.prepareStatement(sql);
	
			ps.setInt(1, ls.getSid());
			ps.setString(2, ls.getSname());
			ps.setString(3, ls.getGender());
			ps.setString(4, ls.getSaddress());
			
			ps.execute();
			System.out.println("Student Record succesfully added");
		} catch(SQLException e) {
			System.out.println("Invalid data");
			e.printStackTrace();
		}
	}

	public void removeMember(Connection con) {
		String sql = "delete from studentinfo where sid= ?";
		System.out.println("Enter student id");
		int stud_id = sc.nextInt();

		ls.setSid(stud_id);
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, ls.getSid());
			ps.executeUpdate();
			System.out.println("Memeber remove successfully");
		} catch (SQLException e) {
			System.out.println("Enter proper student id");
			e.printStackTrace();
		}
	}

	public void updateMemberInfo(Connection con) {
		String sql = "update studentinfo set sname=?,gender=?,saddress=? where sid=?;";
		System.out.println("Enter student id");
		int sid = sc.nextInt();

		System.out.println("Enter name");
		String sname = sc.next();

		System.out.println("Enter gender");
		String gender = sc.next();

		System.out.println("Enter address");
		String saddress = sc.next();


		ls.setSid(sid);
		ls.setSname(sname);
		ls.setGender(gender);
		ls.setSaddress(saddress);

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(4, ls.getSid());
			ps.setString(1, ls.getSname());
			ps.setString(2, ls.getGender());
			ps.setString(3, ls.getSaddress());
			ps.executeUpdate();
			System.out.println("Upadte information succesfully");
		} catch (SQLException e) {
			System.out.println("acc_no is Invalid");
			e.printStackTrace();
		}
	}

	public void issueBook(Connection con) {
		
		System.out.println("Enter bid");
		int bid = sc.nextInt();

		System.out.println("Enter student id");
		int sid = sc.nextInt();

		System.out.println("Enter issue date");
		String doissue = sc.next();

		System.out.println("Enter due date");
		String dued = sc.next();

		lm.setBid(bid);
		lm.setSid(sid);
		lm.setDoissue(doissue);
		lm.setDued(dued);
		
		
		try {
			PreparedStatement ps = con.prepareStatement("insert into lmanage(bid, sid, doissue, dued) values(?,?,?,?);");
			ps.setInt(1, lm.getBid());
			ps.setInt(2, lm.getSid());
			ps.setString(3, lm.getDoissue());
			ps.setString(4, lm.getDued());
			
			int temp = ps.executeUpdate();
			
			if (temp == 1)
				System.out.println("Book issues successfully");
			else
				System.out.println("sorry");
		} catch (SQLException e) {
			System.out.println("Book issues successfully");
		}
	}
	public void recordReturn(Connection con)
	{
			String sql="select l.bid, b.bname from books b inner join  lmanage l on b.bid = l.bid where l.sid = ?";
			
			
			System.out.println("Enter student id");
			int sid=sc.nextInt();
		
			ls.setSid(sid);
			
			try
			{
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, ls.getSid());
				ResultSet rs3 = ps.executeQuery();
				
				if (rs3.next()) {	
					System.out.println("bid::" + rs3.getInt(1));
					System.out.println("bname::" + rs3.getString(2));

				System.out.println("Record Return succesfully");
				}
				else
				{
					System.out.println("Invalid student id");
				}
			}
			catch(SQLException e)
			{
				System.out.println("Invalid student id");
				e.printStackTrace();
			}
	}
		public void fine(Connection con)
		{
			final int fine=10;
			String sql="select sid, rdate,dued ,datediff(rdate,dued) as diff from lmanage where sid=?";
			System.out.println("Enter student id");
			int sid=sc.nextInt();
			
			lm.setSid(sid);
			try
			{
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1, lm.getSid());
		
				
				ResultSet rs4=ps.executeQuery();
				while(rs4.next()) {
					int pay=10*rs4.getInt(4);
					System.out.println("fine is "+pay);
				}
			}
			catch(SQLException e)
			{
				System.out.println("Error");
				e.printStackTrace();
			}
		}		
}
