package laptrinhjavaweb.repository;

import laptrinhjavaweb.entity.BuildingEntity;

public interface IBuildingReponsitory extends GenericJDBC<BuildingEntity>{
	Long insert(BuildingEntity buildingEntity);

}
