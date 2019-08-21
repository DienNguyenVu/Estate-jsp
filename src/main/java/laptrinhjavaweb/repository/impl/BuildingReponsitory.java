package laptrinhjavaweb.repository.impl;

import laptrinhjavaweb.entity.BuildingEntity;
import laptrinhjavaweb.repository.IBuildingReponsitory;

public class BuildingReponsitory extends AbstractJDBC<BuildingEntity> implements IBuildingReponsitory{

	@Override
	public Long insert(BuildingEntity buildingEntity) {
		
		StringBuilder sql = new StringBuilder("INSERT INTO building(name,numberofbasement,buildingarea,district,war,street,structure,costren,costdescription,servicecost,carcost,motobike,overtimecost,electricitycost,deposit,payment,timerent,timedecoration,managername,managerphone,createddate,modifieddate,createdby,modifedby)\r\n" + 
				"		value(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
		return this.insert(sql.toString(),buildingEntity.getName(),buildingEntity.getBuildingArea(),buildingEntity.getBuildingArea(),buildingEntity.getWard(),buildingEntity.getDistrict());
		//còn thiếu
	}


}
   