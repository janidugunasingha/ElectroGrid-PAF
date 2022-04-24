package org.restapi.crud.crud.model;

public class crudmodel {
	
	private int id;
	private String noticehead;
	private String noticecontent;
	
	public crudmodel() {
		
	}

	public crudmodel(int id, String noticehead, String noticecontent) {
		super();
		this.id = id;
		this.noticehead = noticehead;
		this.noticecontent = noticecontent;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNoticehead() {
		return noticehead;
	}

	public void setNoticehead(String noticehead) {
		this.noticehead = noticehead;
	}

	public String getNoticecontent() {
		return noticecontent;
	}

	public void setNoticecontent(String noticecontent) {
		this.noticecontent = noticecontent;
	}
	
	
}
