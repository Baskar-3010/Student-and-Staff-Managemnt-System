package com.project.file;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import com.project.student.Student;
import com.project.student.StudentActivity;

public class Write {
	public static void write(Student s,String file) throws FileNotFoundException, IOException, ClassNotFoundException {
		
		TreeMap<String,Student> map1=(TreeMap<String, Student>) Read.readAll(file);
		if(map1==null) {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream (file));
			TreeMap<String,Student> map=new TreeMap<String,Student>();
			map.put(s.getId(), s);
			oos.writeObject(map);
			oos.close();
		}
		else {
			String str=s.getId();
			map1.put(str,s);
//			for(Map.Entry<String, Student> e:map1.entrySet()) {
//				System.out.println((Student)e.getValue());
//			}
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream (file));
			oos.writeObject(map1);
			oos.close();
//			for(Map.Entry<String, Object> e:map1.entrySet()) {
//				StudentActivity.display((Student)e.getValue());
//					
//			}
//			String name=file.equals("Student.txt")?"Student":"Staff ";
//			if(size==map1.size()) {
//				System.out.println("\n<<------"+name+ " is already Exits---->>\n");
//			}
			
		}
		//String name=file.equals("Student.txt")?"Student":"Staff ";
		System.out.println("\n<<<<<<<-----------  Student added successfully------------>>>>>>>\n");
		
		
	}

	public static void write(TreeMap<String, Student> map, String file) throws IOException {
		
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream (file));
			oos.writeObject(map);
			oos.close();
		
	}
}
