package web.skietapp.controller.panel.exercise;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.skietapp.connection.DbUtil;
import web.skietapp.model.Exercise;

@WebServlet("/panel/exercises/add")
public class AddExerciseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		getServletContext().getRequestDispatcher("/views/panelAddExerciseView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		String desc = description.replaceAll("\n", "<br>");
		
		Exercise exercise = new Exercise(title, desc);
		try (Connection conn = DbUtil.getConn()) {
			exercise.saveToDB(conn);
			response.sendRedirect(request.getContextPath() + "/panel/exercises");
		} catch (SQLException e) {
			
		}
	}

}
