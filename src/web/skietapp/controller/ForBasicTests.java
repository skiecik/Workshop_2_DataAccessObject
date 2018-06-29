package web.skietapp.controller;

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
import web.skietapp.model.Solution;

/**
 * Servlet implementation class ForBasicTests
 */
@WebServlet("/ForBasicTests")
public class ForBasicTests extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Connection conn = DbUtil.getConn();
			List<Solution> solutions = Solution.loadAllSolutions(conn, 5);
			for (Solution sol : solutions) {
				System.out.println(sol.getId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
