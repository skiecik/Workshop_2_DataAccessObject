package web.skietapp.controller.mainPage;

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
import web.skietapp.dao.UserDao;
import web.skietapp.model.User;

@WebServlet("/groups/show")
public class UsersFromGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strId = request.getParameter("id");
		
		try (Connection conn = DbUtil.getConn()){
			int id = Integer.parseInt(strId);
			List<User> users = UserDao.readAllUsersByGroupId(conn, id);
			request.setAttribute("users", users);
			getServletContext().getRequestDispatcher("/views/usersGroupView.jsp").forward(request, response);
		} catch (SQLException e) {
			response.getWriter().append("Something goes wrong");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
