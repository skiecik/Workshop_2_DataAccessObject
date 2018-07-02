package web.skietapp.controller.panel.user;

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

@WebServlet("/panel/users/edit")
public class EditUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String strId = request.getParameter("id");
		
		try (Connection conn = DbUtil.getConn()) {
			int id = Integer.parseInt(strId);
			User user = User.loadUserById(conn, id);
			List<Group> groups = Group.loadAllGroups(conn);
			Group group = Group.loadGroupById(conn, user.getUserGroup());
			request.setAttribute("user", user);
			request.setAttribute("groups", groups);
			request.setAttribute("group", group);
			getServletContext().getRequestDispatcher("/views/panelEditUserView.jsp").forward(request, response);
		} catch (SQLException e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String strUserGroup = request.getParameter("groupId");
		String strId = request.getParameter("id");
		
		try (Connection conn = DbUtil.getConn()){
			int userGroup = Integer.parseInt(strUserGroup);
			int id = Integer.parseInt(strId);
			User user = User.loadUserById(conn, id);
			user.setUserName(name);
			user.setEmail(email);
			user.setUserGroup(userGroup);
			if (!password.isEmpty() && !password.equals(null)) {
				user.setPassword(password);
			}
			user.saveToDB(conn);
			response.sendRedirect(request.getContextPath() + "/panel/users");
		} catch (SQLException e) {
			
		}
	}

}
