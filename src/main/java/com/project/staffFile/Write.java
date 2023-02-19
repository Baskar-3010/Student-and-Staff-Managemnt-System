package com.project.staffFile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.TreeMap;

import com.project.staffFile.Read;
import com.project.staff.Staff;

public class Write {
	public static void write(Staff s, String file) throws FileNotFoundException, IOException, ClassNotFoundException {

		TreeMap<String, Staff> map1 = (TreeMap<String, Staff>) Read.readAll(file);
		if (map1 == null) {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			TreeMap<String, Staff> map = new TreeMap<String, Staff>();
			map.put(s.getId(), s);
			oos.writeObject(map);
			oos.close();
		} else {
			String str = s.getId();
			map1.put(str, s);
//			for(Map.Entry<String, Staff> e:map1.entrySet()) {
//				System.out.println((Staff)e.getValue());
//			}
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(map1);
			oos.close();
//			for(Map.Entry<String, Object> e:map1.entrySet()) {
//				StaffActivity.display((Staff)e.getValue());
//					
//			}
//			String name=file.equals("Staff.txt")?"Staff":"Staff ";
//			if(size==map1.size()) {
//				System.out.println("\n<<------"+name+ " is already Exits---->>\n");
//			}

		}
		//String name = file.equals("Staff.txt") ? "Staff" : "Staff ";
		System.out.println("\n<<<<<<<-----------  Staff added successfully------------>>>>>>>\n");

	}

	public static void write(TreeMap<String, Staff> map, String file) throws IOException {

		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
		oos.writeObject(map);
		oos.close();

	}
}
