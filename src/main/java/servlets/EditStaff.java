package servlets;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.staffFile.Read;
import com.project.staffFile.Write;
import com.project.staff.Staff;

/**
 * Servlet implementation class EditStaff
 */
@WebServlet("/EditStaff")
public class EditStaff extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		//System.out.println(id);
		String name = request.getParameter("name");
		double yoe = Double.parseDouble(request.getParameter("yoe"));
		String qualification=request.getParameter("qualification"); 
		String address = request.getParameter("address");
		long phone = Long.parseLong(request.getParameter("phone"));
		double salary = Double.parseDouble(request.getParameter("salary"));
		String isPaid = request.getParameter("isPaid");
		
		Staff Staff =new Staff(id,name, qualification,phone,yoe,address,salary,isPaid);
		System.out.println(Staff.toString());
		TreeMap<String, Staff> map;
		try {
			map = Read.readAll("E:/DSA project/ProjectDS/Staff.txt");
			
			map.put(Staff.getId(), Staff);
			Write.write(map, "E:/DSA project/ProjectDS/Staff.txt");
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
