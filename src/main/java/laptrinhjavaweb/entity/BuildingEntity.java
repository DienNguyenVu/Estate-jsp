package laptrinhjavaweb.entity;

import laptrinhjavaweb.annotation.Colum;
import laptrinhjavaweb.annotation.Entity;
import laptrinhjavaweb.annotation.Table;

@Entity
@Table(name="building")
public class BuildingEntity extends Base{

	@Colum(name="name")
	private  String name;
	@Colum(name="ward")
	private String ward;
	@Colum(name="street")
	private String street;
	@Colum(name="structure")
	private String structure;
	@Colum(name="numberofbasement")
	private Integer numberOfBasement;
	@Colum(name="buildingarea")
	private Integer buildingArea;
	@Colum(name="district")
	private String district;
	@Colum(name="war")
	private String war;
	@Colum(name="costren")
	private String costren;
	@Colum(name="costdescription")
	private String costdescription;
	@Colum(name="servicecost")
	private String servicecost;
	@Colum(name="carcost")
	private String carcost;
	@Colum(name="motobike")
	private String motobike;
	@Colum(name="overtimecost")
	private String overtimecost;
	@Colum(name="electricitycost")
	private String electricitycost;
	@Colum(name="deposit")
	private String deposit;
	@Colum(name="timerent")
	private String timerent;
	@Colum(name="timedecoration")
	private String timedecoration;
	@Colum(name="managername")
	private String managername;
	@Colum(name="managerphone")
	private String managerphone;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getWard() {
		return ward;
	}
	public void setWard(String ward) {
		this.ward = ward;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getStructure() {
		return structure;
	}
	public void setStructure(String structure) {
		this.structure = structure;
	}
	public Integer getNumberOfBasement() {
		return numberOfBasement;
	}
	public void setNumberOfBasement(Integer numberOfBasement) {
		this.numberOfBasement = numberOfBasement;
	}
	public Integer getBuildingArea() {
		return buildingArea;
	}
	public void setBuildingArea(Integer buildingArea) {
		this.buildingArea = buildingArea;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getWar() {
		return war;
	}
	public void setWar(String war) {
		this.war = war;
	}
	public String getCostren() {
		return costren;
	}
	public void setCostren(String costren) {
		this.costren = costren;
	}
	public String getCostdescription() {
		return costdescription;
	}
	public void setCostdescription(String costdescription) {
		this.costdescription = costdescription;
	}
	public String getServicecost() {
		return servicecost;
	}
	public void setServicecost(String servicecost) {
		this.servicecost = servicecost;
	}
	public String getCarcost() {
		return carcost;
	}
	public void setCarcost(String carcost) {
		this.carcost = carcost;
	}
	public String getMotobike() {
		return motobike;
	}
	public void setMotobike(String motobike) {
		this.motobike = motobike;
	}
	public String getOvertimecost() {
		return overtimecost;
	}
	public void setOvertimecost(String overtimecost) {
		this.overtimecost = overtimecost;
	}
	public String getElectricitycost() {
		return electricitycost;
	}
	public void setElectricitycost(String electricitycost) {
		this.electricitycost = electricitycost;
	}
	public String getDeposit() {
		return deposit;
	}
	public void setDeposit(String deposit) {
		this.deposit = deposit;
	}
	public String getTimerent() {
		return timerent;
	}
	public void setTimerent(String timerent) {
		this.timerent = timerent;
	}
	public String getTimedecoration() {
		return timedecoration;
	}
	public void setTimedecoration(String timedecoration) {
		this.timedecoration = timedecoration;
	}
	public String getManagername() {
		return managername;
	}
	public void setManagername(String managername) {
		this.managername = managername;
	}
	public String getManagerphone() {
		return managerphone;
	}
	public void setManagerphone(String managerphone) {
		this.managerphone = managerphone;
	}

	
	
	
}
