package web.skietapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.skietapp.model.User;

public class UserDao {

	public static void saveUser(Connection conn, User user) throws SQLException {

		String query = "INSERT INTO users (user_name, email, password, user_group_id) " + "VALUES (?, ?, ?, ?)";

		PreparedStatement prep = conn.prepareStatement(query);
		prep.setString(1, user.getUserName());
		prep.setString(2, user.getEmail());
		prep.setString(3, user.getPassword());
		prep.setInt(4, user.getUserGroup());
		prep.executeUpdate();
	}

	public static void updateUser(Connection conn, User user) throws SQLException{

		String query = "UPDATE users SET user_name=?, email=?, password=?, user_group_id=? WHERE id=?";

		PreparedStatement prep = conn.prepareStatement(query);
		prep.setString(1, user.getUserName());
		prep.setString(2, user.getEmail());
		prep.setString(3, user.getPassword());
		prep.setInt(4, user.getUserGroup());
		prep.setInt(5, user.getId());
		prep.executeUpdate();
	}
	
	public static User readUserById(Connection conn, int id) throws SQLException {
		String query = "SELECT * FROM users WHERE id = ?";
		
		PreparedStatement prep = conn.prepareStatement(query);
		prep.setInt(1, id);
		
		ResultSet rs = prep.executeQuery();
		if (rs.next()) {
			User loadedUser = new User();
			loadedUser.setId(rs.getInt("id"));
			loadedUser.setUserName(rs.getString("user_name"));
			loadedUser.setEmail(rs.getString("email"));
			loadedUser.setReadedPassword(rs.getString("password"));
			loadedUser.setUserGroup(rs.getInt("user_group_id"));
			return loadedUser;
		}
		return null;
	}
	
	public static List<User> readAllUsers(Connection conn) throws SQLException {
		String query = "SELECT * FROM users";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		List<User> users = new ArrayList<>();
		
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("user_name"));
			user.setEmail(rs.getString("email"));
			user.setReadedPassword(rs.getString("password"));
			user.setUserGroup(rs.getInt("user_group_id"));
			users.add(user);
		}
		return users;
	}
	
	public static void deleteUser(Connection conn, User user) throws SQLException {
		if (user.getId() != 0) {
			String query = "DELETE FROM users WHERE id = ?";
			PreparedStatement prep = conn.prepareStatement(query);
			prep.setInt(1, user.getId());
			prep.executeUpdate();
			user.setId(0);
		}
	}
	
	public static List<User> readAllUsersByGroupId(Connection conn, int id) throws SQLException {
		List<User> users = new ArrayList<>();
		String query = "SELECT * FROM users WHERE user_group_id = ?";
		
		PreparedStatement prep = conn.prepareStatement(query);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		
		while (rs.next()) {
			User user = new User();
			user.setId(rs.getInt("id"));
			user.setUserName(rs.getString("user_name"));
			user.setEmail(rs.getString("email"));
			user.setReadedPassword(rs.getString("password"));
			user.setUserGroup(rs.getInt("user_group_id"));
			users.add(user);
		}
		return users;
	}
	
	public static User readUserByEmail(Connection conn, String email) throws SQLException {
		String query = "SELECT * FROM users WHERE email = ?";
		
		PreparedStatement prep = conn.prepareStatement(query);
		prep.setString(1, email);
		ResultSet rs = prep.executeQuery();
		
		if (rs.next()) {
			User loadedUser = new User();
			loadedUser.setId(rs.getInt("id"));
			loadedUser.setUserName(rs.getString("user_name"));
			loadedUser.setEmail(rs.getString("email"));
			loadedUser.setReadedPassword(rs.getString("password"));
			loadedUser.setUserGroup(rs.getInt("user_group_id"));
			return loadedUser;
		}
		return null;
	}
}
