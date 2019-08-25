package laptrinhjavaweb.enums;

public enum DistrictEnum {
	DISTRICT_1("Quân 1"),
	DISTRICT_2("Quân 2"),
	DISTRICT_3("Quân 3"),
	DISTRICT_4("Quân 4"),
	DISTRICT_5("Quân 5"),
	DISTRICT_6("Quân 6"),
	DISTRICT_7("Quân 7"),
	DISTRICT_8("Quân 8"),
	DISTRICT_9("Quân 9"),
	DISTRICT_10("Quân 10"),
	DISTRICT_11("Quân 11"),
	DISTRICT_12("Quân 12"),
	DISTRICT_BINHTAN("Bình Tân"),
	DISTRICT_TANBINH("Tân Bình"),
	DISTRICT_TANPHU("Tân Phú"),
	DISTRICT_PHUNHUAN("Phú Nhuận"),
	DISTRICT_BINHTHANH("Bình Thạnh"),
	DISTRICT_THUDUC("Thủ Đức");
	
	private String value;
	DistrictEnum(String value) {
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
	
}
