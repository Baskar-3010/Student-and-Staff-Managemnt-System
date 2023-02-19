package com.project.student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import com.project.file.Read;
import com.project.file.Write;

public class StudentActivity {

	public static void add() throws FileNotFoundException, ClassNotFoundException, IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter student id      :");
		String id = sc.nextLine();
		System.out.print("Enter student Name    :");
		String name = sc.nextLine();
		System.out.print("Enter student standard:");
		String standard = sc.nextLine();
		System.out.print("Enter student address :");
		String address = sc.nextLine();
		System.out.print("Enter Phone number    :");
		long phone = sc.nextLong();
		System.out.print("Enter total fees      :");
		double fees = sc.nextDouble();
		double fees_remaining = fees;
		Student student = new Student(id, name, standard, address, phone, fees, fees_remaining);
		//System.out.println(student.toString());
		Write.write(student, "Student.txt");

	}

	public static void display(Student s) {
		System.out.println();
		System.out.println("Id                 : " + s.getId());
		System.out.println("Name               : " + s.getName());
		System.out.println("Standard           : " + s.getStandard());
		System.out.println("Address            : " + s.getAddress());
		System.out.println("Phone number       : " + s.getPhone());
		System.out.println("Total Fees         : " + s.getFees());
		System.out.println("Remaining Fees     : " + s.getFeesRemaining());
		System.out.println();
	}

	public static void search() throws ClassNotFoundException, IOException {
		
		Scanner sc = new Scanner(System.in);
		
		TreeMap<String, Student> map = Read.readAll("Student.txt");
		if (map == null) {
			System.out.println("\n<<<---------Record is Empty-------->>>");
		} else {

			int i = 0;
			System.out.print("\nEnter Student Id to Search:");
			String id = sc.nextLine();
			for (Map.Entry<String, Student> e : map.entrySet()) {
				if (id.equals(e.getKey())) {
					i = 1;
					System.out.println("\n<<<<<<-----------Result Found---------->>>>>>\n");
					// System.out.println();
					display((Student) e.getValue());
					break;
				}
			}
			if (i == 0) {
				System.out.println("\n<<<<<-----------Record Not Found------------>>>>>");
			}
			System.out.println();
		}

	}

	public static void displayAll() throws ClassNotFoundException, IOException {
		TreeMap<String, Student> map = Read.readAll("Student.txt");
		if (map == null) {
			System.out.println("\n<<<---------Record is Empty-------->>>\n");
		} else {
			System.out.println("\n<<<<<<-----------All Student records---------->>>>>>\n");
			for (Map.Entry<String, Student> e : map.entrySet()) {
				display((Student) e.getValue());
			}
			System.out.println();
		}
	}

	public static void delete() throws ClassNotFoundException, IOException {
		System.out.print("\nEnter Student Id to Delete:");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		TreeMap<String, Student> map = Read.readAll("Student.txt");
		if (map == null) {
			System.out.println("<<<---------Record is Empty-------->>>");
		} else {

			int i = 0;
			Student s = map.remove(id);
			if (s == null) {
				System.out.println("\n<<<<<<----------Record Not Found----------->>>>>>\n");
			} else {
				Write.write(map, "Student.txt");
				;
				System.out.println("\n<<<<<<----------Record Deleted----------->>>>>>n");
			}
		}

	}

	public static void modify() throws ClassNotFoundException, IOException {
		System.out.print("\nEnter Student Id to Modify:");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		TreeMap<String, Student> map = Read.readAll("Student.txt");

		if (map == null) {
			System.out.println("<<<---------Record is Empty-------->>>");
		} 
		else if(!map.containsKey(id)) {
			System.out.println("<<<-----------Record not found------------>>>");
		}
		
		else {
			Student s = map.get(id);
			
			System.out.println("1.Student Name");
			System.out.println("2.Student Standard");
			System.out.println("3.Student Address");
			System.out.println("4.Student Phone number");
			System.out.println("5.Student Total fees");
			System.out.print("\nEnter which data to modify :");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.print("Enter the modified name :");
				String name = sc.nextLine();
				s.setName(name);
				map.put(id, s);
				Write.write(map, "Student.txt");
				System.out.println("\n<<<<<<--------Student Name modified successfully-------->>>>>>\n");
				display(s);
				System.out.println();
				break;
			case 2:
				System.out.print("Enter the modified Standard:");
				String std = sc.nextLine();
				s.setStandard(std);
				map.put(id, s);
				Write.write(map, "Student.txt");
				System.out.println("\n<<<<<<--------Student Standard modified successfully-------->>>>>>\n");
				display(s);
				break;
			case 3:
				System.out.print("Enter the modified Address:");
				String address = sc.nextLine();
				s.setAddress(address);
				map.put(id, s);
				Write.write(map, "Student.txt");
				System.out.println("\n<<<<<<--------Student Address modified successfully-------->>>>>>\n");
				display(s);
				break;
			case 4:
				System.out.print("Enter the modified Phone number:");
				long phone = sc.nextLong();
				s.setPhone(phone);
				map.put(id, s);
				Write.write(map, "Student.txt");
				System.out.println("\n<<<<<<--------Student Phone number modified successfully-------->>>>>>\n");
				display(s);
				break;
			case 5:
				System.out.print("Enter the modified Total fees:");
				double fees = sc.nextDouble();
				
				s.setFees(fees);
				if(s.getFees()<=s.getFeesRemaining())
					s.setFeesRemaining(s.getFees());
				map.put(id, s);
				Write.write(map, "Student.txt");
				System.out.println("\n<<<<<<--------Student Total fees modified successfully-------->>>>>>\n");
				display(s);
				break;
				default:System.out.println("<<<<<<---------Invalid Option-------->>>>>>");
			}
		}

	}

	public static void fees() throws ClassNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("\nEnter Student id for further activity: ");
		String id = sc.nextLine();
		TreeMap<String, Student> map = Read.readAll("Student.txt");
		Student s=map.get(id);
		if (map == null) {
			System.out.println("<<<---------Record is Empty-------->>>");
		} 
		else if(!map.containsKey(id)) {
			System.out.println("<<<-----------Record not found------------>>>");
		}
		System.out.println("<<<----------Your choices-------->>>");
		System.out.println("1.To check the Balance fees");
		System.out.println("2.Fees Payment");
//		System.out.println("3.Fees Payment");
		System.out.print("\nEnter Your choice:");
		int ch=sc.nextInt();
		if(ch==1) {
			System.out.println("<<<-----------Student Fess Details----------->>>");
	
			
			System.out.println("1.Student Name           :"+s.getName());
			System.out.println("2.Student Standard       :"+s.getStandard());
			System.out.println("3.Student Total fees     :"+s.getFees());
			System.out.println("3.Student Remaining fees :"+s.getFeesRemaining());
			
		}
	
		else if(ch==2)	{
		//System.out.print("\nEnter Student Id to Modify the fees of the student :");
		
			System.out.println("<<<<<-----Student Deatil is Below--->>>>>");
			display(s);
			System.out.print("Enter the amount will paid:");
			double amt=sc.nextDouble();
			if(s.getFeesRemaining()-amt<0) {
				System.out.println("<<<<--------Paying amount is greater than the remaining fees------->>>>");
			}else {

				s.setFeesRemaining(s.getFeesRemaining()-amt);
				System.out.println("Amount Paid :"+amt);
				System.out.println("\n<<<<--------------Fees Paid is Updated------------->>>>\n");
				System.out.println("Remaining fees: "+s.getFeesRemaining()+"\n");
				map.put(id, s);
			}
			
		}
	else {
		System.out.println("<<<------Invalid Choice--->>>");
	}
		
	}
}

