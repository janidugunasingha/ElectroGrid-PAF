package org.restapi.crud.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.restapi.crud.crud.model.crudmodel;

public class crudservice {
  Connection con;
 
  public crudservice() {
	 
	  try {
		  
		  String url = String.format("jdbc:mysql://localhost:3306/electrogrid");
		  String uname = "root";
		  String pwd = "";
		  
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  con = DriverManager.getConnection(url,uname,pwd);
		  
	  }catch(Exception e) {
			System.out.println(e +"data insert unsecess.");  
	  }
	  
  }
  
  public crudmodel insertNotice(crudmodel notice) {
	  String insert = "insert into notice(header,content) values(?,?)";
	  
	  try {
		  PreparedStatement ps = con.prepareStatement(insert);
		  ps.setString(1,notice.getNoticehead());
		  ps.setString(2,notice.getNoticecontent());
		  
		  ps.execute();
	  }catch(Exception e) {
		System.out.println(e +"data insert unsecess.");  
	  }
	  
	  return notice;
  }
}



