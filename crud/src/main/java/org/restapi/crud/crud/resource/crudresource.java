package org.restapi.crud.crud.resource;

import jakarta.ws.rs.Path;

import org.restapi.crud.crud.model.crudmodel;
import org.restapi.crud.crud.service.crudservice;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.core.MediaType;

@Path("/crud")
public class crudresource {

	
	crudservice service = new crudservice();
	
	@Path("/insertion")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public crudmodel addNotice(crudmodel notice) {
		return service.insertNotice(notice);
	}
}
