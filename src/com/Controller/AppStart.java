package com.Controller;

import java.sql.Connection;
import java.util.Scanner;

import com.Bean.books;
import com.Configure.Data_Connection;
import com.DAO.LibDAO;

public class AppStart {

	public static void main(String[] args) {

		Connection con = Data_Connection.myConn();

		LibDAO ld = new LibDAO();

		Scanner sc = new Scanner(System.in);
		while (true) {
			if (con != null) {
				System.out.println("Enter 1 for Add book");
				System.out.println("Enter 2 for Delete Data");
				System.out.println("Enter 3 for Update Data");
				System.out.println("Enter 4 for Search Data");
				System.out.println("Enter 5 for Add New Student");
				System.out.println("Enter 6 for Remove Student");
				System.out.println("Enter 7 for Update Student Info");
				System.out.println("Enter 8 for Issue Book");
				System.out.println("Enter 9 for Record Book");
				System.out.println("Enter 10 for Fine Calculation");
				System.out.println("Enter Your Choice :- ");
				int ch = sc.nextInt();

				switch (ch) {
				case 1:
					System.out.println("Add new book to library");
					ld.addBook(con);
					break;
				case 2:
					System.out.println("Delete data from library");
					ld.deleteBook(con);
					break;
				case 3:
					System.out.println("Update data from library");
					ld.updateData(con);
					break;
				case 4:
					System.out.println("Search data from library");
					ld.searchData(con);
					break;
				case 5:
					System.out.println("Add new member");
					ld.addMember(con);
					break;
				case 6:
					System.out.println("Remove member");
					ld.removeMember(con);
					break;
				case 7:
					System.out.println("Update memeber info");
					ld.updateMemberInfo(con);
					break;
				case 8:
					System.out.println("Book Issue ");
					ld.issueBook(con);
					break;
				case 9:
					System.out.println("Record Return");
					ld.recordReturn(con);
					break;
				case 10:
					System.out.println("Fine Calculation ");
					ld.fine(con);
					break;
				}
			} else {
				System.out.println("Invalid username and password");
				System.exit(0);
			}
		}
	}

}