package web.skietapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.skietapp.model.Solution;

public class SolutionDao {

	public static void saveSolution(Connection conn, Solution solution) throws SQLException {
		String query = "INSERT INTO solutions (description, exercise_id, user_id)" + "VALUES (?, ?, ?)";
		String[] generatedColumns = { "id" };

		PreparedStatement prep = conn.prepareStatement(query, generatedColumns);
		prep.setString(1, solution.getDescription());
		prep.setInt(2, solution.getExerciseId());
		prep.setInt(3, solution.getUserId());
		prep.executeUpdate();
		ResultSet rs = prep.getGeneratedKeys();
		if (rs.next()) {
			solution.setId(rs.getInt(1));
		}
	}

	public static void updateSolution(Connection conn, Solution solution) throws SQLException {
		String query = "UPDATE solutions SET description=? WHERE id=?";
		PreparedStatement prep = conn.prepareStatement(query);
		prep.setString(1, solution.getDescription());
		prep.setInt(2, solution.getId());
		prep.executeUpdate();
	}

	public static Solution readSolutionById(Connection conn, int id) throws SQLException {
		String query = "SELECT * FROM solutions WHERE id = ?";
		PreparedStatement prep = conn.prepareStatement(query);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		if (rs.next()) {
			Solution loadedSolution = new Solution();
			loadedSolution.setId(rs.getInt("id"));
			loadedSolution.setDescription(rs.getString("description"));
			loadedSolution.setCreated(rs.getTimestamp("created"));
			loadedSolution.setUpdated(rs.getTimestamp("updated"));
			loadedSolution.setExerciseId(rs.getInt("exercise_id"));
			loadedSolution.setUserId(rs.getInt("user_id"));
			return loadedSolution;
		}
		return null;
	}

	public static List<Solution> readAllSolutions(Connection conn) throws SQLException {
		String query = "SELECT * FROM solutions";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		List<Solution> solutions = new ArrayList<>();
		while (rs.next()) {
			Solution solution = new Solution();
			solution.setId(rs.getInt("id"));
			solution.setDescription(rs.getString("description"));
			solution.setCreated(rs.getTimestamp("created"));
			solution.setUpdated(rs.getTimestamp("updated"));
			solution.setExerciseId(rs.getInt("exercise_id"));
			solution.setUserId(rs.getInt("user_id"));
			solutions.add(solution);
		}
		return solutions;
	}

	public static List<Solution> readAllSolutions(Connection conn, int limit) throws SQLException {
		String query = "SELECT * FROM solutions ORDER BY updated DESC LIMIT ?";
		PreparedStatement pr = conn.prepareStatement(query);
		pr.setInt(1, limit);
		ResultSet rs = pr.executeQuery();
		List<Solution> solutions = new ArrayList<>();
		while (rs.next()) {
			Solution solution = new Solution();
			solution.setId(rs.getInt("id"));
			solution.setDescription(rs.getString("description"));
			solution.setCreated(rs.getTimestamp("created"));
			solution.setUpdated(rs.getTimestamp("updated"));
			solution.setExerciseId(rs.getInt("exercise_id"));
			solution.setUserId(rs.getInt("user_id"));
			solutions.add(solution);
		}
		return solutions;
	}

	public static void deleteSolution(Connection conn, Solution solution) throws SQLException {
		if (solution.getId() != 0) {
			String query = "DELETE FROM solutions WHERE id = ?";
			PreparedStatement prep = conn.prepareStatement(query);
			prep.setInt(1, solution.getId());
			prep.executeUpdate();
			solution.setId(0);
		}
	}

	public static List<Solution> readAllByUserId(Connection conn, int id) throws SQLException {
		String query = "SELECT * FROM solutions WHERE user_id = ?";
		List<Solution> solutions = new ArrayList<>();
		PreparedStatement prep = conn.prepareStatement(query);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			Solution solution = new Solution();
			solution.setId(rs.getInt("id"));
			solution.setDescription(rs.getString("description"));
			solution.setCreated(rs.getTimestamp("created"));
			solution.setUpdated(rs.getTimestamp("updated"));
			solution.setExerciseId(rs.getInt("exercise_id"));
			solution.setUserId(rs.getInt("user_id"));
			solutions.add(solution);
		}
		return solutions;
	}

	public static List<Solution> readAllByExerciseId(Connection conn, int id) throws SQLException {
		String query = "SELECT * FROM solutions WHERE exercise_id = ? ORDER BY created DESC";
		List<Solution> solutions = new ArrayList<>();
		PreparedStatement prep = conn.prepareStatement(query);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		while (rs.next()) {
			Solution solution = new Solution();
			solution.setId(rs.getInt("id"));
			solution.setDescription(rs.getString("description"));
			solution.setCreated(rs.getTimestamp("created"));
			solution.setUpdated(rs.getTimestamp("updated"));
			solution.setExerciseId(rs.getInt("exercise_id"));
			solution.setUserId(rs.getInt("user_id"));
			solutions.add(solution);
		}
		return solutions;
	}

}
