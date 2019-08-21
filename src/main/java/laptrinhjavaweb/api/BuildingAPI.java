package laptrinhjavaweb.api;

import javax.jws.WebService;

import laptrinhjavaweb.dto.BuildingDTO;
import laptrinhjavaweb.service.IBuildingService;
import laptrinhjavaweb.service.impl.BuildingService;

import java.io.IOException;
@WebService(urlPatterns= {"/api-admin-user"})
public class BuildingAPI extends HttpServlet{
	private IBuildingService buildingService;
	public BuildingAPI () {
		buildingService=new BuildingService();
		
	}
	
	protected void doPost (HttpServlet request,HttpServletResponse response) 
		throw ServletException, IOException
	{
	
		ObjectMapper mapper =new ObjectMapper();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		BuildingDTO buildingDTO= HttpUtil.of(request.getReader()).toModel(buildingDTO.class);
		
		mapper.writerValue(response.getOutputStream(), buildingDTO);
		
	}
}
