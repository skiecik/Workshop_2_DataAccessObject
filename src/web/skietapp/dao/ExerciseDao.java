package web.skietapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import web.skietapp.model.Exercise;

public class ExerciseDao {

	public static void saveExercise(Connection conn, Exercise exercise) throws SQLException {

		String query = "INSERT INTO exercises (title, description)" + "VALUES (?, ?)";
		String[] generatedColumns = { "id" };
		
		PreparedStatement prep = conn.prepareStatement(query, generatedColumns);
		prep.setString(1, exercise.getTitle());
		prep.setString(2, exercise.getDescription());
		prep.executeUpdate();
		ResultSet rs = prep.getGeneratedKeys();
		if (rs.next()) {
			exercise.setId(rs.getInt(1));
		}
	}

	public static void updateExercise(Connection conn, Exercise exercise) throws SQLException {
		
		String query = "UPDATE exercises SET title=?, description=? WHERE id=?";
		
		PreparedStatement prep = conn.prepareStatement(query);
		prep.setString(1, exercise.getTitle());
		prep.setString(2, exercise.getDescription());
		prep.setInt(3, exercise.getId());
		prep.executeUpdate();
	}

	public static Exercise readExerciseById(Connection conn, int id) throws SQLException {
		String query = "SELECT * FROM exercises WHERE id = ?";
		PreparedStatement prep = conn.prepareStatement(query);
		prep.setInt(1, id);
		ResultSet rs = prep.executeQuery();
		if (rs.next()) {
			Exercise loadedExercise = new Exercise();
			loadedExercise.setId(rs.getInt("id"));
			loadedExercise.setTitle(rs.getString("title"));
			loadedExercise.setDescription(rs.getString("description"));
			return loadedExercise;
		}
		return null;
	}

	public static List<Exercise> readAllExercises(Connection conn) throws SQLException {
		String query = "SELECT * FROM exercises";
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		List<Exercise> exercises = new ArrayList<>();
		while (rs.next()) {
			Exercise exercise = new Exercise();
			exercise.setId(rs.getInt("id"));
			exercise.setTitle(rs.getString("title"));
			exercise.setDescription(rs.getString("description"));
			exercises.add(exercise);
		}
		return exercises;
	}

	public static void deleteExercise(Connection conn, Exercise exercise) throws SQLException {
		if (exercise.getId() != 0) {
			String query = "DELETE FROM exercises WHERE id = ?";
			PreparedStatement prep = conn.prepareStatement(query);
			prep.setInt(1, exercise.getId());
			prep.executeUpdate();
			exercise.setId(0);
		}
	}

}
