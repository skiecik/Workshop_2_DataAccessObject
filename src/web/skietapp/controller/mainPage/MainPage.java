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
import web.skietapp.dao.UserDao;
import web.skietapp.model.Exercise;
import web.skietapp.model.Solution;
import web.skietapp.model.User;

@WebServlet("/")
public class MainPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try (Connection conn = DbUtil.getConn()) {
			List<Solution> solutions = Solution.loadAllSolutions(conn, 5);
			List<String> users = new ArrayList<>();
			List<String> exercises = new ArrayList<>();
			for (Solution s : solutions) {
				User u = UserDao.readUserById(conn, s.getUserId());
				Exercise e = Exercise.loadExerciseById(conn, s.getExerciseId());
				users.add(u.getUserName());
				exercises.add(e.getTitle());
			}
			request.setAttribute("solutions", solutions);
			request.setAttribute("exercises", exercises);
			request.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/views/mainPage.jsp").forward(request, response);
		} catch (SQLException e) {
			response.getWriter().append("Something went wrong");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
