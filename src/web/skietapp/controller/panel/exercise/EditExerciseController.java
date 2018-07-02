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
import web.skietapp.dao.ExerciseDao;
import web.skietapp.model.Exercise;

@WebServlet("/panel/exercises/edit")
public class EditExerciseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strId = request.getParameter("id");
		try (Connection conn = DbUtil.getConn()) {
			
			int id = Integer.parseInt(strId);
			Exercise exercise = ExerciseDao.readExerciseById(conn, id);
			request.setAttribute("exercise", exercise);
			getServletContext().getRequestDispatcher("/views/panelEditExerciseView.jsp").forward(request, response);
		} catch (SQLException e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String strId = request.getParameter("id");
		String title = request.getParameter("title");
		String description = request.getParameter("description");
		
		try (Connection conn = DbUtil.getConn()) {
			int id = Integer.parseInt(strId);
			Exercise exercise = ExerciseDao.readExerciseById(conn, id);
			exercise.setTitle(title);
			exercise.setDescription(description);
			ExerciseDao.updateExercise(conn, exercise);
			response.sendRedirect(request.getContextPath() + "/panel/exercises");
		} catch (SQLException e) {
			
		}
	}

}
