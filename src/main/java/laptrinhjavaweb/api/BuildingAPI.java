package laptrinhjavaweb.api;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import org.codehaus.jackson.map.ObjectMapper;

import laptrinhjavaweb.dto.BuildingDTO;
import laptrinhjavaweb.service.IBuildingService;
import laptrinhjavaweb.service.impl.BuildingService;

import java.io.IOException;
@WebServlet(urlPatterns = { "/api-admin-user" })
//@WebService(urlPatterns = { "/api-admin-user" })
public class BuildingAPI extends HttpServlet {
	private IBuildingService buildingService;

	public BuildingAPI () {
		buildingService=new BuildingService();
		
	}

	protected void doPost (HttpServlet request,HttpServletResponse response) throws ServletException, IOException
	{
	
		ObjectMapper mapper =new ObjectMapper();
		setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		BuildingDTO buildingDTO= HttpUtil.of(request.getReader()).toModel(buildingDTO.class);
		
		mapper.writerValue(response.getOutputStream(), buildingDTO);
		
	}
}
