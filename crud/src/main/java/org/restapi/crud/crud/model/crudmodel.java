package org.restapi.crud.crud.model;

public class crudmodel {
	
	private String noticehead;
	private String noticecontent;
	
	public crudmodel() {
		
	}
	
	public crudmodel(String noticehead,String noticecontent ) {
		super();
		this.noticehead = noticehead;
		this.noticecontent = noticecontent;
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
