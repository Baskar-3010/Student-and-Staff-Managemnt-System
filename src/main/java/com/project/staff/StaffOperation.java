package com.project.staff;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import com.project.student.StudentActivity;

public class StaffOperation {
	public static void operations() throws FileNotFoundException, ClassNotFoundException, IOException {
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("\n<<<<<--------------------------->>>>>");
			System.out.println(  "       Operations with Staff");
			System.out.println(  "<<<<<--------------------------->>>>>\n");
			System.out.println("1.Add Staff");
			System.out.println("2.Search Staff");
			System.out.println("3.Delete Staff");
			System.out.println("4.Modify Staff");
			System.out.println("5.Display All Staff");
			System.out.println("6.Salary Activity");
			System.out.println("7.Exit from Staff work");
			System.out.print("\nEnter your Option:");
			int choice=sc.nextInt();
			if(choice==7) {
				System.out.println();
				System.out.println("\n<<<<<<----------Exiting Staff Opeartions----------->>>>>>\n");
				System.out.println();
				break;
			}
			switch(choice) {
				case 1:StaffActivity.add();
				break; 
				case 2:StaffActivity.search();
				break; 
				case 3:StaffActivity.delete();
				break; 
				case 4:StaffActivity.modify();
				break; 
				case 5:StaffActivity.displayAll();
				break; 
				case 6:StaffActivity.salary();
				break;
				default:
				System.out.println();
				System.out.println("<<<<<-------Invalid opeartions------->>>>>");
				System.out.println(" <<<<<----------Try Again---------->>>>>>");
				System.out.println();
			}
		}
	}
}
