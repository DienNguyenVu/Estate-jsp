   package laptrinhjavaweb.entity;

import java.sql.Timestamp;

import laptrinhjavaweb.annotation.Colum;



public class Base {
	@Colum(name="id")
	private  Long id;
	@Colum(name="createddate")
	private  String createddate;
	@Colum(name="modifieddate")
	private  String modifieddate;
	@Colum(name="createdby")
	private  Timestamp createdby;
	@Colum(name="modifiedby")
	private  Timestamp modifiedby;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}

	public Timestamp getCreatedby() {
		return createdby;
	}

	public void setCreatedby(Timestamp createdby) {
		this.createdby = createdby;
	}

	public Timestamp getModifiedby() {
		return modifiedby;
	}

	public void setModifiedby(Timestamp modifiedby) {
		this.modifiedby = modifiedby;
	}

	
}
