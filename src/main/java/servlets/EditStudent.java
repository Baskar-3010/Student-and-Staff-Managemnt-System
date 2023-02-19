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

import com.project.file.Read;
import com.project.file.Write;
import com.project.student.Student;

/**
 * Servlet implementation class EditStudent
 */
@WebServlet("/EditStudent")
public class EditStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		//System.out.println(id);
		String name = request.getParameter("name");
		String standard = request.getParameter("standard");
		String address = request.getParameter("address");
		long phone = Long.parseLong(request.getParameter("phone"));
		double fees = Double.parseDouble(request.getParameter("fees"));
		double feesRemaining = Double.parseDouble(request.getParameter("feesRemaining"));
		Student student =new Student(id,name,standard,address,phone,fees,feesRemaining);
		System.out.println(student.toString());
		TreeMap<String, Student> map;
		try {
			map = Read.readAll("E:/DSA project/ProjectDS/Student.txt");
			if(map.containsKey(student.getId())) {
				map.remove(student.getId());
				System.out.println("Contains");
			}
			System.out.println(student.toString());
			map.put(student.getId(), student);
			Write.write(map, "E:/DSA project/ProjectDS/Student.txt");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect("AllStudent.jsp"); 
		
	}


}
