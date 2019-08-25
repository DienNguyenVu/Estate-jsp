package laptrinhjavaweb.enums;

public enum DistrictEnum {
	DISTRIC_1("Quân 1"),
	DISTRIC_2("Quân 2"),
	DISTRIC_3("Quân 3"),
	DISTRIC_4("Quân 4"),
	DISTRIC_5("Quân 5"),
	DISTRIC_6("Quân 6"),
	DISTRIC_7("Quân 7"),
	DISTRIC_8("Quân 8"),
	DISTRIC_9("Quân 9"),
	DISTRIC_10("Quân 10"),
	DISTRIC_11("Quân 11"),
	DISTRIC_12("Quân 12"),
	DISTRIC_BINHTAN("Bình Tân"),
	DISTRIC_TANBINH("Tân Bình"),
	DISTRIC_TANPHU("Tân Phú"),
	DISTRIC_PHUNHUAN("Phú Nhuận"),
	DISTRIC_BINHTHANH("Bình Thạnh"),
	DISTRIC_THUDUC("Thủ Đức");
	
	private String value;
	DistrictEnum(String value) {
		this.value=value;
	}
	public String getValue()
	{
		return value;
	}
	
}
