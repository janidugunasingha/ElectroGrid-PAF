package com.emeter.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.emeter.DBConnection.DBConnect;

public class Meter {

// insert method
	public String insertMeter(String account_no, String name, String address, String units,String date) {
		Connection con = DBConnect.connect();
		String output = "";
		if (con == null) {
			return "Error while connecting to the database";
		}

		// create a prepared statement
		String query = " insert into meter (`id`,`account_no`,`name`,`address`,`units`,`date`)" + " values (?, ?, ?, ?, ?, ?)";
		PreparedStatement preparedStmt;
		try {
			preparedStmt = con.prepareStatement(query);

			preparedStmt.setInt(1, 0);
			preparedStmt.setString(2, account_no);
			preparedStmt.setString(3, name);
			preparedStmt.setString(4, address);
			preparedStmt.setString(5, units);
			preparedStmt.setString(6, date);
            preparedStmt.execute();
            
			con.close();
			output = "Inserted successfully";
		} catch (SQLException e) {
			output = "Error while inserting";
			System.err.println(e.getMessage());
		}

		return output;
	}

	public String readMeter() {
		String output = "";
		try {
			Connection con = DBConnect.connect();
			if (con == null) {
				return "Error while connecting to the database for reading Customers.";
			}
			// Prepare the html table to be displayed
			output = "<table border='1'><tr><th>Account No</th><th>Name</th>"+ "<th>Address</th>" + "<th>Units</th>"+ "<th>Date</th>"+ "<th>Update</th><th>Remove</th></tr>";
	        
			String query = "select * from meter";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			// iterate through the rows in the result set
			while (rs.next()) {
				String id = Integer.toString(rs.getInt("id"));
				String account_no= rs.getString("account_no");
				String name = rs.getString("name");
				String address = rs.getString("address");
				String units = rs.getString("units");
				String date = rs.getString("date");

				// Add into the html table
				output += "<td>" + account_no + "</td>";
				output += "<td>" + name + "</td>";
				output += "<td>" + address + "</td>";
				output += "<td>" + units + "</td>";
				output += "<td>" + date + "</td>";
				
				 //buttons
		          output += "<td><input name='btnUpdate' " + " type='button' value='Update'></td>" + "<td><form method='post' action='meter.jsp'>" + "<input name='btnRemove' " + " type='submit' value='Remove'>" + "<input name='id' type='hidden' " + " value='" + id + "'>" + "</form></td></tr>"; } con.close();
		          
			
			con.close();

			output += "</table>";
		}

		catch (Exception e) {
			output = "Error while reading the meter.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String updateMeter(String id, String account_no, String name, String address, String units,String date)

	{
		String output = "";
		try {
			Connection con = DBConnect.connect();
			if (con == null) {
				return "Error while connecting to the database for updating.";
			}
			// create a prepared statement

			String query = " update meter set account_no= ? , name = ? , address = ? , units = ? , date = ?  where id = ? ";

			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			
			preparedStmt.setString(1, account_no);
			preparedStmt.setString(2, name);
			preparedStmt.setString(3, address);
			preparedStmt.setString(4, units);
			preparedStmt.setString(5, date);
			preparedStmt.setInt(6, Integer.parseInt(id));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Updated successfully";
		} catch (Exception e) {
			output = "Error while updating the Meter.";
			System.err.println(e.getMessage());
		}
		return output;
	}

	public String deleteMeter(String id) {
		String output = "";
		try {
			Connection con = DBConnect.connect();
			if (con == null) {
				return "Error while connecting to the database for deleting.";
			}
			// create a prepared statement
			String query = "delete from meter where id=?";
			PreparedStatement preparedStmt = con.prepareStatement(query);
			// binding values
			preparedStmt.setInt(1, Integer.parseInt(id));
			// execute the statement
			preparedStmt.execute();
			con.close();
			output = "Deleted successfully";
		} catch (Exception e) {
			output = "Error while deleting the meter.";
			System.err.println(e.getMessage());
		}
		return output;
	}
}