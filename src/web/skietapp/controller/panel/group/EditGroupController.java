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

@WebServlet("/panel/groups/edit")
public class EditGroupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strId = request.getParameter("id");
		
		try (Connection conn = DbUtil.getConn()){
			int id = Integer.parseInt(strId);
			Group group = GroupDao.readGroupById(conn, id);
			request.setAttribute("group", group);
			getServletContext().getRequestDispatcher("/views/panelEditGroup.jsp").forward(request, response);
		} catch (SQLException e) {
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String strId = request.getParameter("id");
		String name = request.getParameter("groupName");
		
		try (Connection conn = DbUtil.getConn()){
			int id = Integer.parseInt(strId);
			Group group = GroupDao.readGroupById(conn, id);
			group.setName(name);
			GroupDao.updateGroup(conn, group);
			response.sendRedirect(request.getContextPath() + "/panel/groups");
		} catch (SQLException e) {
			
		}
	}

}
