package web.skietapp.controller.panel.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.skietapp.connection.DbUtil;
import web.skietapp.dao.UserDao;
import web.skietapp.model.User;

@WebServlet("/panel/users/delete")
public class DeleteUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strId = request.getParameter("id");
		try (Connection conn = DbUtil.getConn()){
			
			int id = Integer.parseInt(strId);
			User user= UserDao.readUserById(conn, id);
			UserDao.deleteUser(conn, user);
			response.sendRedirect(request.getContextPath() + "/panel/users");
			
		} catch (SQLException e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
