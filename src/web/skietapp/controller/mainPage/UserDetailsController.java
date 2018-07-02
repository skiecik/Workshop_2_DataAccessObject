package web.skietapp.controller.mainPage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.skietapp.connection.DbUtil;
import web.skietapp.dao.ExerciseDao;
import web.skietapp.dao.SolutionDao;
import web.skietapp.dao.UserDao;
import web.skietapp.model.Exercise;
import web.skietapp.model.Solution;
import web.skietapp.model.User;

@WebServlet("/users/show")
public class UserDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strId = request.getParameter("id");
		
		try (Connection conn = DbUtil.getConn()) {
			int id = Integer.parseInt(strId);
			User user = UserDao.readUserById(conn, id);
			List<Solution> solutions = SolutionDao.readAllByUserId(conn, user.getId());
			List<String> exercises = new ArrayList<>();
			
			for (Solution solution : solutions) {
				Exercise exercise = ExerciseDao.readExerciseById(conn, solution.getExerciseId());
				exercises.add(exercise.getTitle());
			}
			
			request.setAttribute("user", user);
			request.setAttribute("solutions", solutions);
			request.setAttribute("exercises", exercises);
			getServletContext().getRequestDispatcher("/views/userDetailsView.jsp").forward(request, response);
		} catch (SQLException e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
