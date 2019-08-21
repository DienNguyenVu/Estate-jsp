package laptrinhjavaweb.mapper;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import laptrinhjavaweb.annotation.Colum;
import laptrinhjavaweb.annotation.Entity;


public class ResultSetMapper<T> {
	public List<T> mapRow(ResultSet rs,Class zClass) {
		List<T>  results = new ArrayList() ;
		try {
			if(zClass.isAnnotationPresent(Entity.class))
			{
				ResultSetMetaData resultSetMetaData=rs.getMetaData();
				Field[] fields=zClass.getDeclaredFields();
				while(rs.next()) {
					T object =(T)zClass.newInstance();
					for(int i=0;i< resultSetMetaData.getColumnCount();i++)
					{
						String columString =resultSetMetaData.getColumnName(i+1);
						Object columValue =rs.getObject(i+1);
						convertResultSetToEntity(fields,columString,columValue,object);
						//parent class
						  Class<?> parentClass=zClass.getSuperclass();
						  while(parentClass !=null)
						  {
							 Field[] fieldparent =parentClass.getDeclaredFields();
							 convertResultSetToEntity(fieldparent,columString,columValue,object);
							 parentClass=parentClass.getSuperclass();
						  }
					}
					results.add(object);
				}
			}
			//while hang dau tien get dc gia tri set vao entity
			// for tung cot
		} catch (Exception e) {
			// TODO: handle exception
		}
		return results;
	}
	private void convertResultSetToEntity(Field[] fields, String columString, Object columValue, T object) throws IllegalAccessException,InstantiationException, InvocationTargetException 
	{
		for(Field field: fields)
		{
			if(field.isAnnotationPresent(Colum.class))
			{
				Colum column=field.getAnnotation(Colum.class);
				if(column.name().equals(columString) && columValue !=null)
				{
					BeanUtils.setProperty(object, field.getName(), columValue);
					break;
				}
			}
		}
	}
}
