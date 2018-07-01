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
import web.skietapp.model.Group;
import web.skietapp.model.User;

@WebServlet("/panel/users/add")
public class AddUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try (Connection conn = DbUtil.getConn()){
			List<Group> groups = Group.loadAllGroups(conn);
			request.setAttribute("groups", groups);
			getServletContext().getRequestDispatcher("/views/panelAddUserView.jsp").forward(request, response);
		} catch (SQLException e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String strUserGroup = request.getParameter("groupId");
		
		try (Connection conn = DbUtil.getConn()){
			int userGroup = Integer.parseInt(strUserGroup);
			User user = new User(name, email, password, userGroup);
			user.saveToDB(conn);
			response.sendRedirect(request.getContextPath() + "/panel/users");
		} catch (SQLException e) {
			
		}
	}

}
