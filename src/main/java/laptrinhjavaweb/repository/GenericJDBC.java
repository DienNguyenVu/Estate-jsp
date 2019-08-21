package laptrinhjavaweb.repository;


import java.util.List;
import java.util.Map;

import laptrinhjavaweb.paging.Pageble;


public interface GenericJDBC<T> {
	List<T> query(String sql,Object... parameters);
	void update (String sql,Object... parameters);
	Long insert(String sql,Object... parameters);
	Long insert(Object object);
	Void update(Object object);
	Void delete(Long id);
	@SuppressWarnings("hiding")
	<T> T findById(Long id);
	List<T> findAll(Map<String,Object> properties,Pageble pageble,Object...where);
}
