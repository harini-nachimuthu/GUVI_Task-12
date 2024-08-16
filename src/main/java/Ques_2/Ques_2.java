package Ques_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ques_2 {

	public static void main(String[] args) throws SQLException {
		String database_url="jdbc:mysql://localhost:3306/";
		String database_username="root";
		String database_password="Root@123";
		
		
		try {
			Connection connectn;
			connectn=DriverManager.getConnection(database_url, database_username, database_password);
			
			if(connectn!=null) {
				System.out.println(connectn);
				System.out.println("The database connection is successful..");
			}else {
				System.out.println("The database connection is not successful..");

			}
			
			Statement statement=connectn.createStatement();
			
			String createDB="create database employee";
			String use="use employee";
			String creatable="create table employee1(empcode int,empname varchar(10),empage int,empsalary int)";
			String insert = "insert into employee1 values " +
	                "(101, 'Jenny', 25, 10000), " +
	                "(102, 'Jacky', 30, 20000), " +
	                "(103, 'Joe', 20, 40000), " +
	                "(104, 'John', 40, 80000), " +
	                "(105, 'Shameer', 25, 90000)";
			String select="select * from employee1";
			
			
			
			statement.execute(createDB);
			statement.execute(use);
			statement.execute(creatable);
			statement.execute(insert);
			
			ResultSet resultset=statement.executeQuery(select);
			while(resultset.next()) {
				System.out.println(resultset.getInt("empcode")+" "+resultset.getString("empname")+" "+resultset.getInt("empage")+" "+resultset.getInt("empsalary"));	
			}
			
			connectn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
