package laptrinhjavaweb.service.impl;

import java.util.List;
import java.util.Map;

import laptrinhjavaweb.converter.BuildingConvert;
import laptrinhjavaweb.dto.BuildingDTO;
import laptrinhjavaweb.entity.BuildingEntity;
import laptrinhjavaweb.paging.Pageble;
import laptrinhjavaweb.repository.IBuildingReponsitory;
import laptrinhjavaweb.repository.impl.BuildingReponsitory;
import laptrinhjavaweb.service.IBuildingService;

public class BuildingService implements IBuildingService {
	private IBuildingReponsitory buildingReponsitory;
	public BuildingService()
	{
		buildingReponsitory =new BuildingReponsitory();
	}
	@Override
	public BuildingDTO save(BuildingDTO buildingDTO) {
		BuildingConvert buildingConvert = new BuildingConvert();
		BuildingEntity buildingEntity = buildingConvert.convertToEntity(buildingDTO);
		Long id=buildingReponsitory.insert(buildingEntity);
		return null;
	}
	@Override
	public List<BuildingDTO> findAll(Map<String, Object> properties, Pageble pageble) {
		// TODO Auto-generated method stub
		return null;
	}

}
