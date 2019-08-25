package laptrinhjavaweb.enums;

public enum BuildingTypeEnum {
	TANG_TRET("tầng trệt"),
	NGUYEN_CAN("Nguyên căn"),
	NOI_THAT("Nội Thất");
	private String value;
	BuildingTypeEnum(String value) {
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
}	
