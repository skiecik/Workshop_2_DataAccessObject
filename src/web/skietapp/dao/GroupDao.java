package web.skietapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.skietapp.model.Group;

public class GroupDao {

	public static void saveGroup(Connection conn, Group group) throws SQLException {

		String query = "INSERT INTO user_group (name)" + "VALUES (?)";

		PreparedStatement prep = conn.prepareStatement(query);
		prep.setString(1, group.getName());
		prep.executeUpdate();
	}

	public static void updateGroup(Connection conn, Group group) throws SQLException {
		
		String query = "UPDATE user_group SET name=? WHERE id=?";
		
		PreparedStatement prep = conn.prepareStatement(query);
		prep.setString(1, group.getName());
		prep.setInt(2, group.getId());
		prep.executeUpdate();
	}

	public static Group readGroupById(Connection conn, int id) throws SQLException {
		
		String query = "SELECT * FROM user_group WHERE id = ?";
		
		PreparedStatement prep = conn.prepareStatement(query);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		if (rs.next()) {
			Group loadedGroup = new Group();
			loadedGroup.setId(rs.getInt("id"));
			loadedGroup.setName(rs.getString("name"));
			return loadedGroup;
		}
		return null;
	}

	public static List<Group> readAllGroups(Connection conn) throws SQLException {
		
		String query = "SELECT * FROM user_group";
		
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		List<Group> groups = new ArrayList<>();
		
		while (rs.next()) {
			Group group = new Group();
			group.setId(rs.getInt("id"));
			group.setName(rs.getString("name"));
			groups.add(group);
		}
		return groups;
	}

	public static void deleteGroup(Connection conn, Group group) throws SQLException {
		if (group.getId() != 0) {
			String query = "DELETE FROM user_group WHERE id = ?";
			PreparedStatement prep = conn.prepareStatement(query);
			prep.setInt(1, group.getId());
			prep.executeUpdate();
			group.setId(0);
		}
	}

}
