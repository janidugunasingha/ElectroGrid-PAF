package org.restapi.crud.crud.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
  
  
  public ArrayList<crudmodel> getnotice() throws SQLException{
	  
	  ArrayList<crudmodel> data = new ArrayList<crudmodel>();
	  String select = "select * from notice";
	  PreparedStatement ps = con.prepareStatement(select);
	  ResultSet rs = ps.executeQuery();
	  
	  while(rs.next()) {
		  crudmodel model = new crudmodel();
		  
		  model.setNoticehead(rs.getString("header"));
		  model.setNoticecontent(rs.getString("content"));
		  
		  data.add(model);
		  
	  }
	  
	  return data;
  }
  
  
public ArrayList<crudmodel> getnoticeById(int id) throws SQLException{
	  
	  ArrayList<crudmodel> data = new ArrayList<crudmodel>();
	  String select = "select * from notice where id =?";
	  PreparedStatement ps = con.prepareStatement(select);
	  ps.setInt(1,id);
	  ResultSet rs = ps.executeQuery();
	  
	  while(rs.next()) {
		  crudmodel model = new crudmodel();
		  
		  model.setNoticehead(rs.getString("header"));
		  model.setNoticecontent(rs.getString("content"));
		  data.add(model);
		  
	  }
	  
	  return data;
  }

public crudmodel updateNotice(crudmodel notice) {
	  String update = "update notice set header = ?,content = ? where id =?";
	  
	  try {
		  PreparedStatement ps = con.prepareStatement(update);
		  
		  ps.setString(1,notice.getNoticehead());
		  ps.setString(2,notice.getNoticecontent());
		  ps.setInt(3, notice.getId());
		  
		  ps.executeUpdate();
	  }catch(Exception e) {
		System.out.println(e +"data insert unsecess.");  
	  }
	  
	  return notice;
}


public int deleteNotice(int id) {
	  String delete = "delete from notice where id = ?";
	  
	  try {
		  PreparedStatement ps = con.prepareStatement(delete);
		  ps.setInt(1,id);
		
		  ps.executeUpdate();
	  }catch(Exception e) {
		System.out.println(e +"data delete unsecess.");  
	  }
	  
	  return id;
}
}



