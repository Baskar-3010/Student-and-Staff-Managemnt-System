package com.project.student;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class StudentOperation {
	public static void operation() throws FileNotFoundException, ClassNotFoundException, IOException {
		@SuppressWarnings("resource")
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("\n<<<<<--------------------------->>>>>");
			System.out.println(  "       Operations with Students");
			System.out.println(  "<<<<<--------------------------->>>>>\n");
			System.out.println("1.Add Student");
			System.out.println("2.Search Student");
			System.out.println("3.Delete Student");
			System.out.println("4.Modify Student");
			System.out.println("5.Display All students");
			System.out.println("6.Fees Activity");
			System.out.println("7.Exit from student work");
			System.out.print("\nEnter your Option:");
			int choice=sc.nextInt();
			if(choice==7) {
				System.out.println();
				System.out.println("\n<<<<<<----------Exiting Student Opeartions----------->>>>>>\n");
				System.out.println();
				break;
			}
			switch(choice) {
				case 1:StudentActivity.add();
				break;
				case 2:StudentActivity.search();
				break;
				case 3:StudentActivity.delete();
				break;
				case 4:StudentActivity.modify();
				break;
				case 5:StudentActivity.displayAll();
				break;
				case 6:StudentActivity.fees();
				break;
				default:
				System.out.println();System.out.println("<<<<<-------Invalid opeartions------->>>>>>");
				System.out.println("<<<<<----------Try Again---------->>>>>>");
				System.out.println();
			}
		}
	}
}
