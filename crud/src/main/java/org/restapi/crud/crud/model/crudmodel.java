package org.restapi.crud.crud.model;

public class crudmodel {
	
	private int id;
	private String Username;
	private String Account_number;
	private String cvv;
	
	public crudmodel() {
		
	}

	public crudmodel(int id, String Username, String Account_number, String cvv ) {
		super();
		this.id = id;
		this.Username = Username;
		this.Account_number = Account_number;
		this.cvv = cvv;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return Username;
	}

	public void setNoticehead(String Username) {
		this.Username = Username;
	}

	public String getAccount_number() {
		return Account_number;
	}

	public void setNoticecontent(String Account_number) {
		this.Account_number = Account_number;
	}
	
	public String getcvv() {
		return cvv;
	}

	public void setcvv(String cvv) {
		this.cvv = cvv;
	}

	public void setUsername(String string) {
		// TODO Auto-generated method stub
		
	}

	public void setAccount_number(String string) {
		// TODO Auto-generated method stub
		
	}
	
}
