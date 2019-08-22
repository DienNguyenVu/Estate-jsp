package laptrinhjavaweb.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class HttpUtil {
	private String value;

	public HttpUtil(String value) {
		this.value = value;
	}

	public <T> T toModel(Class<T> class1) {
		try {
			return new ObjectMapper().readValue(value, class1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static HttpUtil of(BufferedReader reader) {
		StringBuffer sb = new StringBuffer();
		try {
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return new HttpUtil(sb.toString());
	}
}
