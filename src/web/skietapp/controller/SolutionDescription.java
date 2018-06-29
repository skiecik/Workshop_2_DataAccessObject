package web.skietapp.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.skietapp.connection.DbUtil;
import web.skietapp.model.Solution;

@WebServlet("/solution-description")
public class SolutionDescription extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strId = request.getParameter("id");
		try (Connection conn = DbUtil.getConn()){
			
			int id = Integer.parseInt(strId);
			Solution solution = Solution.loadSolutionById(conn, id);
			request.setAttribute("solution", solution);
			getServletContext().getRequestDispatcher("/views/solutionDescriptionView.jsp").forward(request, response);
		} catch (SQLException e) {
			response.getWriter().append("Sorry, something goes wrong");
		} catch (NumberFormatException e) {
			response.getWriter().append("Sorry, wrong parameter.");
		} catch (NullPointerException e) {
			response.getWriter().append("Sorry, there is no parameter");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
