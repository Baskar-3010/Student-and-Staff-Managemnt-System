package servlets;

import java.io.IOException;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.project.file.Read;
import com.project.file.Write;
import com.project.student.Student;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteStudent")
public class DeleteStudent extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {
			String id=request.getParameter("id");
			TreeMap<String, Student> map;
			map = Read.readAll("E:/DSA project/ProjectDS/Student.txt");
//			if (map == null) {
//				System.out.println("<<<---------Record is Empty-------->>>");
//			} else {

				int i = 0;
				Student s = map.remove(id);
				if (s == null) {
					System.out.println("\n<<<<<<----------Record Not Found----------->>>>>>\n");
				} else {
					Write.write(map, "E:/DSA project/ProjectDS/Student.txt");
					;
					System.out.println("\n<<<<<<----------Record Deleted----------->>>>>>n");
				}
			//}
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
