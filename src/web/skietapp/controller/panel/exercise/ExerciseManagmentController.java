package web.skietapp.controller.panel.exercise;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.skietapp.connection.DbUtil;
import web.skietapp.model.Exercise;

@WebServlet("/panel/exercises")
public class ExerciseManagmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try (Connection conn = DbUtil.getConn()) {
			List<Exercise> exercises = Exercise.loadAllExercises(conn);
			for (Exercise e : exercises) {
				String desc = e.getDescription().replaceAll("\n", "<br>");
				e.setDescription(desc);
			}
			request.setAttribute("exercises", exercises);
			getServletContext().getRequestDispatcher("/views/panelExercisesView.jsp").forward(request, response);
		} catch (SQLException e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
