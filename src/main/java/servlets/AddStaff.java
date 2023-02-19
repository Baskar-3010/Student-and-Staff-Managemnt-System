package servlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.SessionCookieConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.staffFile.Read;
import com.project.staffFile.Write;
import com.project.staff.Staff;

/**
 * Servlet implementation class AddStaff
 */
@WebServlet("/AddStaff")
public class AddStaff extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String qualification = request.getParameter("qualification");
		Double yoe = Double.parseDouble(request.getParameter("yoe"));
		String address = request.getParameter("address");
		long phone = Long.parseLong(request.getParameter("phone"));
		double salary = Double.parseDouble(request.getParameter("salary"));
		String isPaid = request.getParameter("isPaid");
		Staff Staff =new Staff(id,name,qualification,phone,yoe,address,salary,isPaid);
		
		try {
			Write.write(Staff, "E:/DSA project/ProjectDS/Staff.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		HttpSession session=request.getSession();
		TreeMap<String, Staff> map1;
		try {
			map1 = (TreeMap<String, Staff>) Read.readAll("E:/DSA project/ProjectDS/Staff.txt");
			session.setAttribute("map1",map1);
			

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("AllStaff.jsp");  
		
	}
}
