package laptrinhjavaweb.service;

import java.util.List;
import java.util.Map;

import laptrinhjavaweb.dto.BuildingDTO;
import laptrinhjavaweb.paging.Pageble;

public interface IBuildingService {
	BuildingDTO save(BuildingDTO newBuilding);
	List<BuildingDTO> findAll(Map<String,Object> properties, Pageble pageble);
}
 