package laptrinhjavaweb.dto;

import java.sql.Timestamp;

public class AbstractDTO {

	private Long id;
	private String createddate;

	private String modifieddate;

	private Timestamp createdby;

	private Timestamp modifiedby;
	private int maxPageItem=10;
	private int Page=1;
	public int getPage() {
		return Page;
	}

	public void setPage(int page) {
		Page = page;
	}

	public int getMaxPageItem() {
		return maxPageItem;
	}

	public void setMaxPageItem(int maxPageItem) {
		this.maxPageItem = maxPageItem;
	}

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
