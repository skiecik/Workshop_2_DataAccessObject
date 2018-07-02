package web.skietapp.controller.panel.group;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.skietapp.connection.DbUtil;
import web.skietapp.dao.GroupDao;
import web.skietapp.model.Group;

@WebServlet("/panel/groups/add")
public class AddGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		getServletContext().getRequestDispatcher("/views/panelAddGroupView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("groupName");
		
		try (Connection conn = DbUtil.getConn()) {
			Group group = new Group(name);
			GroupDao.saveGroup(conn, group);
			response.sendRedirect(request.getContextPath() + "/panel/groups");
		} catch (SQLException e) {
			
		}
	}

}
