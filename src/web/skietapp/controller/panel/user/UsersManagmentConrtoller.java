package web.skietapp.controller.panel.user;

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
import web.skietapp.model.Group;
import web.skietapp.model.User;

@WebServlet("/panel/users")
public class UsersManagmentConrtoller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try (Connection conn = DbUtil.getConn()) {
			List<User> users = User.loadAllUsers(conn);
			List<String> groups = new ArrayList<>();
			for (User u : users) {
				Group gr = Group.loadGroupById(conn, u.getUserGroup());
				groups.add(gr.getName());
			}
			request.setAttribute("users", users);
			request.setAttribute("groups", groups);
			getServletContext().getRequestDispatcher("/views/panelUsersView.jsp").forward(request, response);
		} catch (SQLException e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
