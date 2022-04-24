package org.restapi.crud.crud.resource;

import java.sql.SQLException;
import java.util.ArrayList;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;

import org.restapi.crud.crud.model.crudmodel;
import org.restapi.crud.crud.service.crudservice;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
@Path("/crud")
public class crudresource {

	
	crudservice service = new crudservice();
	
	//insert data to db
	
	@Path("/insert")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel addNotice(crudmodel notice) {
		return service.insertNotice(notice);
	}
	
	//All data retrieve from db
	
	@Path("/retrieve")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel> getNotice() throws SQLException{
      return service.getnotice();
	}
	
	
	//Specific data retrieve from db
	
	@Path("/reteiveById/{id}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<crudmodel> getNotice(@PathParam("id")int id) throws SQLException{
    return service.getnoticeById(id);
	}
	
	//Update data in db
	
	@Path("/update")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel updateNotice(crudmodel notice) {
	  return service.updateNotice(notice);
	}
	
	
	//delete specific  data in db 
	
	@Path("/deleteById/{id}")
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public int deleteNotice(@PathParam("id")int id) {
	 return service.deleteNotice(id);
	}
}
