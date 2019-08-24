package laptrinhjavaweb.repository.impl;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes.Name;

import laptrinhjavaweb.annotation.Colum;
import laptrinhjavaweb.annotation.Table;
import laptrinhjavaweb.mapper.ResultSetMapper;
import laptrinhjavaweb.paging.Pageble;
import laptrinhjavaweb.paging.Sorter;
import laptrinhjavaweb.repository.GenericJDBC;

public class AbstractJDBC<T> implements GenericJDBC<T> {
	private Class<T> zClass;

	public AbstractJDBC() {

		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		zClass = (Class<T>) parameterizedType.getActualTypeArguments()[0];

	}

	private Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String databaseURL = "jdbc:mysql://localhost:3307/estate4month2019";
			String user = "root";
			String password = "123456";
			return DriverManager.getConnection(databaseURL, user, password);
		} catch (ClassNotFoundException | SQLException ex) {
			ex.printStackTrace();
		}
		return null;
	}

	@Override
	public List<T> query(String sql, Object... parameters) {
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper();
		List<T> results = new ArrayList<>();
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement(sql);
			ResultSet resultSet = statement.executeQuery();
			if (conn != null) {
				return resultSetMapper.mapRow(resultSet, this.zClass);
			}
			conn.close();
		} catch (SQLException ex) {
			System.out.println("Could not find database driver class");

		}
		return null;
	}

	@Override
	public void update(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql);
			if (conn != null) {

				for (int i = 0; i < parameters.length; i++) {
					int index = i + 1;
					statement.setObject(index, parameters[i]);
				}
				statement.executeUpdate();
				conn.commit();
			}
		} catch (Exception e) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException el) {
					el.printStackTrace();
				}
			}

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}
	}

	public Long insert(String sql, Object... parameters) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if (conn != null) {
				// set parameter to statement
				for (int i = 0; i < parameters.length; i++) {
					int index = i + 1;
					statement.setObject(index, parameters[i]);
				}
				int rowInserted = statement.executeUpdate();
				resultSet = statement.getGeneratedKeys();
				conn.commit();
				if (rowInserted > 0) {
					while (resultSet.next()) {
						Long id = resultSet.getLong(1);
						return id;
					}
				}
			}
		} catch (SQLException ex) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}

		return null;
	}

	@Override
	public Long insert(Object object) {

		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);
			String sql = createSQLInsert();
			statement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			if (conn != null) {
				Class<?> zClass = object.getClass();
				Field[] fields = zClass.getDeclaredFields();

				for (int i = 0; i < fields.length; i++) {
					int index = i + 1;
					Field field = fields[i];
					field.setAccessible(true);
					statement.setObject(index, field.get(object));
				}

				// check parent class
				Class<?> parentClass = zClass.getSuperclass();
				int indexPrarent = fields.length + 1;
				while (parentClass != null) {
					for (int i = 0; i < parentClass.getDeclaredFields().length; i++) {
						Field field = parentClass.getDeclaredFields()[i];
						field.setAccessible(true);
						statement.setObject(indexPrarent, field.get(object));
						indexPrarent = indexPrarent + 1;
					}
					parentClass = parentClass.getSuperclass();
				}
				int rowInserted = statement.executeUpdate();
				resultSet = statement.getGeneratedKeys();
				conn.commit();
				if (rowInserted > 0) {
					while (resultSet.next()) {
						Long id = resultSet.getLong(1);
						return id;
					}
				}
			}
		} catch (SQLException | IllegalAccessException ex) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}

		return null;
	}

	private String createSQLInsert() {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		StringBuilder fields = new StringBuilder("");
		StringBuilder params = new StringBuilder("");
		for (Field field : zClass.getDeclaredFields()) {
			if (fields.length() > 1) {
				fields.append(",");
				params.append(",");
			}
			if (field.isAnnotationPresent(Colum.class)) {
				Colum colum = field.getAnnotation(Colum.class);
				fields.append(colum.name());
				params.append("?");

			}
		}
		// check parent class
		Class<?> parentClass = zClass.getSuperclass();
		while (parentClass != null) {
			for (Field field : parentClass.getDeclaredFields()) {
				if (fields.length() > 1) {
					fields.append(",");
					params.append(",");
				}
				if (field.isAnnotationPresent(Colum.class)) {
					Colum colum = field.getAnnotation(Colum.class);
					fields.append(colum.name());
					params.append("?");

				}
			}

			parentClass = parentClass.getSuperclass();
		}
		String sql = "INSERT INTO" + tableName + "(" + fields.toString() + ") VALUES (" + params.toString() + ")";
		return sql;
	}

	@Override
	public Void update(Object object) {
		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);

			String sql = createSQLUpdate();
			statement = conn.prepareStatement(sql);
			if (conn != null) {
				Class<?> zClass = object.getClass();
				Field[] fields = zClass.getDeclaredFields();

				for (int i = 0; i < fields.length; i++) {
					int index = i + 1;
					Field field = fields[i];
					field.setAccessible(true);
					statement.setObject(index, field.get(object));
				}

				// check parent class
				Class<?> parentClass = zClass.getSuperclass();
				int indexPrarent = fields.length + 1;
				Object id = null;
				while (parentClass != null) {
					for (int i = 0; i < parentClass.getDeclaredFields().length; i++) {
						Field field = parentClass.getDeclaredFields()[i];
						field.setAccessible(true);
						String name = field.getName();

						if (!name.equals("id")) {
							statement.setObject(indexPrarent, field.get(object));
							indexPrarent = indexPrarent + 1;
						} else {
							id = field.get(object);
						}
					}

					parentClass = parentClass.getSuperclass();
				}
				statement.setObject(indexPrarent, id);
				statement.executeUpdate();
				conn.commit();
			}
		} catch (SQLException | IllegalAccessException ex) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}

		return null;
	}

	private String createSQLUpdate() {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}

		StringBuilder sets = new StringBuilder("");
		String where = null;
		for (Field field : zClass.getDeclaredFields()) {
			if (field.isAnnotationPresent(Colum.class)) {
				Colum colum = field.getAnnotation(Colum.class);
				String columnName = colum.name();
				String value = columnName + " =? ";
				if (!columnName.equals("id")) {
					if (sets.length() > 1) {
						sets.append(",");
					}
					sets.append(value);
				} else {
					where = "WHERE" + value;
				}
			}
		}
		// check parent class
		Class<?> parentClass = zClass.getSuperclass();
		while (parentClass != null) {
			for (Field field : parentClass.getDeclaredFields()) {
				if (field.isAnnotationPresent(Colum.class)) {
					Colum colum = field.getAnnotation(Colum.class);
					String columnName = colum.name();
					String value = columnName + " =? ";
					if (!columnName.equals("id")) {
						if (sets.length() > 1) {
							sets.append(",");
						}
						sets.append(value);
					} else {
						where = "WHERE" + value;
					}
				}
			}

			parentClass = parentClass.getSuperclass();
		}
		String sql = "UPDATE" + tableName + "SET" + sets.toString() + where;
		return sql;
	}

	@Override
	public Void delete(Long id) {

		Connection conn = null;
		PreparedStatement statement = null;
		try {
			conn = getConnection();
			conn.setAutoCommit(false);

			String tableName = "";
			if (zClass.isAnnotationPresent(Table.class)) {
				Table table = zClass.getAnnotation(Table.class);
				tableName = table.name();
			}

			String sql = "DELETE FROM" + tableName + "WHERE id= ?";
			statement = conn.prepareStatement(sql);
			if (conn != null) {
				statement.setObject(1, id);
				statement.executeUpdate();
				conn.commit();
			}
		} catch (SQLException ex) {
			if (conn != null) {
				try {
					conn.rollback();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException ex) {
					ex.printStackTrace();
				}
			}
		}

		return null;
	}

	@Override
	public <T> T findById(Long id) {
		Connection conn = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();

		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}
		String sql = "SELECT * FROM" + tableName + "WHERE id=?";
		try {
			conn = getConnection();
			statement = conn.prepareStatement(sql);
			resultSet = statement.executeQuery();
			if (conn != null) {
				return resultSetMapper.mapRow(resultSet, this.zClass).get(0);
			}
		} catch (SQLException ex) {
			System.out.println("Could not find database driver class");

		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return null;
	}

	@Override
	public List<T> findAll(Map<String, Object> properties, Pageble pageble, Object... where) {

		Connection conn = null;
		Statement statement = null;
		ResultSet resultSet = null;
		ResultSetMapper<T> resultSetMapper = new ResultSetMapper<>();

		StringBuilder sql = createSQLfindAll(properties);
		if (where != null && where.length > 0) {
			sql.append(where[0]);
		}
		if (pageble != null) {
			if (pageble.getOffset() != null && pageble.getLimit() != null) {
				sql.append("LIMIT " + pageble.getOffset() + "," + pageble.getLimit() + "");

			}
			if (pageble.getSorter() != null) {
				Sorter sorter = pageble.getSorter();
				sql.append("ORDER BY " + sorter.getSortName() + "" + sorter.getSortBy() + "");
			}
		}
		try {
			conn = getConnection();
			statement = conn.createStatement();
			resultSet = statement.executeQuery(sql.toString());
			if (conn != null) {
				return resultSetMapper.mapRow(resultSet, this.zClass);
			}
		} catch (SQLException ex) {
			System.out.println("Could not find database driver class");

		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (statement != null) {
					statement.close();
				}
				if (resultSet != null) {
					resultSet.close();
				}

			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

	private StringBuilder createSQLfindAll(Map<String, Object> properties) {
		String tableName = "";
		if (zClass.isAnnotationPresent(Table.class)) {
			Table table = zClass.getAnnotation(Table.class);
			tableName = table.name();
		}

		StringBuilder stringBuilder = new StringBuilder("SELECT * FROM" + tableName + "WHERE 1-1");
		if (properties != null && properties.size() > 0) {
			String[] params = new String[properties.size()];
			Object[] value = new Object[properties.size()];
			int i = 0;
			for (Map.Entry<?, ?> item : properties.entrySet()) {
				params[i] = (String) item.getKey();
				value[i] = item.getValue();
				i++;
			}
			for (int il = 0; il < params.length; il++) {
				if (value[il] instanceof String) {
					stringBuilder.append("and LOWER(" + params[il] + ") LIKE'%" + value[il] + "%'");
				} else if (value[il] instanceof Integer) {
					stringBuilder.append("and LOWER(" + params[il] + ") = " + value[il] + "");
				}

			}
		}
		return stringBuilder;
	}
}
