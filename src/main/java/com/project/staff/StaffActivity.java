package com.project.staff;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import com.project.staffFile.Read;
import com.project.staffFile.Write;
import com.project.staff.Staff;

public class StaffActivity {

	public static void add() throws FileNotFoundException, ClassNotFoundException, IOException {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter Staff id            :" );
		String id = sc.nextLine();
		System.out.print("Enter Staff Name          :");
		String name = sc.nextLine();
		System.out.print("Enter Staff Quaification  :");
		String qualification = sc.nextLine();
		System.out.print("Enter Staff phone number  :");
		long phone = sc.nextLong();
		
		System.out.print("Enter Staff of Experience :");
		double yof = sc.nextDouble();		sc.nextLine();
		System.out.print("Enter Staff address       :");
		String address = sc.nextLine();
//		System.out.print("Enter Phone number        :");
//		long phone = sc.nextLong();
		System.out.print("Enter total Salary        :");
		double salary = sc.nextDouble();
		//double fees_remaining = fees;
		String isPaid=sc.next();
		System.out.println("Enter yes or No for salary paid:");
		Staff staff = new Staff(id, name,qualification, phone, yof, address,salary,isPaid);
		//System.out.println(student.toString());
		Write.write(staff, "Staff.txt");
		
	}

	public static void search() throws ClassNotFoundException, IOException {
Scanner sc = new Scanner(System.in);
		
		TreeMap<String, Staff> map = Read.readAll("Staff.txt");
		if (map == null) {
			System.out.println("\n<<<---------Record is Empty-------->>>");
		} else {

			int i = 0;
			System.out.print("\nEnter Staff Id to Search:");
			String id = sc.nextLine();
			for (Entry<String, Staff> e : map.entrySet()) {
				if (id.equals(e.getKey())) {
					i = 1;
					System.out.println("\n<<<<<<-----------Result Found---------->>>>>>\n");
					// System.out.println();
					display((Staff) e.getValue());
					break;
				}
			}
			if (i == 0) {
				System.out.println("\n<<<<<-----------Record Not Found------------>>>>>");
			}
			System.out.println();
		}
		
	}

	public static void display(Staff s) {
		System.out.println();
		System.out.println("Id                   : " + s.getId());
		System.out.println("Name                 : " + s.getName());
		System.out.println("Qualification        : "  +s.getQualfication());
		System.out.println("Phone number         : " + s.getPhone());
		System.out.println("Address              : " + s.getAddress());
		System.out.println("Years of Experrience : " + s.getYearsOfExperience());
		System.out.println("Remaining Fees       : " + s.getSalary());
		System.out.println();
		
	}
	
	public static void displayAll() throws ClassNotFoundException, IOException {
		TreeMap<String, Staff> map = Read.readAll("Staff.txt");
		if (map == null || map.size()==0) {
			System.out.println("\n<<<---------Record is Empty-------->>>\n");
		} else {
			System.out.println("\n<<<<<<-----------All Staff records---------->>>>>>\n");
			for (Map.Entry<String, Staff> e : map.entrySet()) {
				display((Staff) e.getValue());
			}
			System.out.println();
		}
	}
	
	public static void modify() throws ClassNotFoundException, IOException {
		System.out.print("\nEnter Staff Id to Modify:");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		TreeMap<String, Staff> map = Read.readAll("Staff.txt");

		if (map == null) {
			System.out.println("<<<---------Record is Empty-------->>>");
		} 
		else if(!map.containsKey(id)) {
			System.out.println("<<<-----------Record not found------------>>>");
		}
		
		else {
			Staff s = map.get(id);
			
			System.out.println("1.Staff Name");
			System.out.println("2.Staff Phone");
			System.out.println("3.Staff Address");
			System.out.println("4.Staff Year Of Experience");
			System.out.println("5.Staff salary");
			System.out.print("\nEnter which data to modify :");
			int choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.print("Enter the modified name :");
				String name = sc.nextLine();
				s.setName(name);
				map.put(id, s);
				Write.write(map, "Staff.txt");
				System.out.println("\n<<<<<<--------Staff Name modified successfully-------->>>>>>\n");
				display(s);
				System.out.println();
				break;
			case 2:
				System.out.print("Enter the modified Phone number:");
				long phone = sc.nextLong();
				s.setPhone(phone);
				map.put(id, s);
				Write.write(map, "Staff.txt");
				System.out.println("\n<<<<<<--------Staff Standard modified successfully-------->>>>>>\n");
				display(s);
				break;
			case 3:
				System.out.print("Enter the modified Address:");
				String address = sc.nextLine();
				s.setAddress(address);
				map.put(id, s);
				Write.write(map, "Staff.txt");
				System.out.println("\n<<<<<<--------Staff Address modified successfully-------->>>>>>\n");
				display(s);
				break;
			case 4:
				System.out.print("Enter the modified Years of Experrienced:");
				long yof = sc.nextLong();
				s.setYearsOfExperience(yof);
				map.put(id, s);
				Write.write(map, "Staff.txt");
				System.out.println("\n<<<<<<--------Staff Phone number modified successfully-------->>>>>>\n");
				display(s);
				break;
			case 5:
				System.out.print("Enter the modified Salary:");
				double salary = sc.nextDouble();
				
				s.setSalary(salary);
//				if(s.getFees()<=s.getFeesRemaining())
//					s.setFeesRemaining(s.getFees());
				map.put(id, s);
				Write.write(map, "Staff.txt");
				System.out.println("\n<<<<<<--------Staff Salary modified successfully-------->>>>>>\n");
				display(s);
				break;
				default:System.out.println("<<<<<<---------Invalid Option-------->>>>>>");
			}
		}
	}
		
	public static void salary() throws ClassNotFoundException, IOException {
		
		TreeMap<String, Staff> map = Read.readAll("Staff.txt");
		if (map == null) {
			System.out.println("\n<<<---------Record is Empty-------->>>");
		} else {

			Scanner sc=new Scanner(System.in);
			System.out.print("\nEnter the Staff id to paid salary :");
			String id=sc.nextLine();
			//map.get(id).setSalaryPaid(true);
			Write.write(map,"Staff.txt");
			System.out.println("<<<-----salary paid successfully------->>>\n");
			
		}
			
			
	}

	public static void delete() throws IOException, ClassNotFoundException {
		System.out.print("\nEnter Staff Id to Delete:");
		Scanner sc = new Scanner(System.in);
		String id = sc.nextLine();
		TreeMap<String, Staff> map = Read.readAll("Student.txt");
		if (map == null) {
			System.out.println("<<<---------Record is Empty-------->>>");
		} else {

			int i = 0;
			Staff s = map.remove(id);
			if (s == null) {
				System.out.println("\n<<<<<<----------Record Not Found----------->>>>>>\n");
			} else {
				Write.write(map, "Staff.txt");
				;
				System.out.println("\n<<<<<<----------Record Deleted----------->>>>>>n");
			}
		}
		
	}
	
	
}
