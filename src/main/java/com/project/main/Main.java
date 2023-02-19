package com.project.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import com.project.staffFile.LoginFile;
import com.project.staff.StaffOperation;
import com.project.student.StudentOperation;

public class Main {
	
	
	public static void operations() throws FileNotFoundException, ClassNotFoundException, IOException {
		while (true) {
			Scanner sc = new Scanner(System.in);
			System.out.println("\nYour Options");
			System.out.println("1.Work with students");
			System.out.println("2.Work with staffs");
			System.out.println("3.Add admin");
			System	.out.println("4.Exit the application");
			
			System.out.print("\nEnter Your Option:");
			int option=sc.nextInt();
			if(option==1) {
				StudentOperation.operation();
			}
			else if(option==2) {
				StaffOperation.operations();
			}
			else if(option==3) {
				System.out.println("Enter the new UserName:");
				String name=sc.nextLine();
				System.out.println("Enter password        :");
				String password=sc.nextLine();
				LoginFile.add(name, password);
			}
			else if(option==4) {
				System.out.println("-----------------------------------------");
				System.out.println("Exiting the application");
				System.out.println("-----------------------------------------");
			}
			
			else {
				System.out.println("Invalid Option  ");
			}
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException, ClassNotFoundException, IOException {
		System.out.println("<<---------------Welcome to the Student ad Staff Details Project---------------->>");
		Scanner sc = new Scanner(System.in);
		
	System.out.println();
	System.out.println();
	System.out.println("     *---------------------------------------------------*");
	System.out.println("     |                                                   |");
	System.out.println("     |                Sign in As Admin                   |");
	System.out.println("     |                                                   |");
	System.out.println("     *---------------------------------------------------*");
		System.out.print("\nEnter User Name : ");
		String userName=sc.nextLine();
		System.out.print("Enter Password  :");
		String password=sc.nextLine();
//		HashMap<String ,String > hs=new HashMap<>();
//		hs.put("admin", "admin123");
//		LoginFile.write(hs);
		boolean credential=LoginFile.read(userName,password);
		if(credential) {
			System.out.println("\n<<<----------Admin Login Successfully------->>>\n");
			operations();
		}
		else {
			System.out.println("<<<--------------Invalid Credentials--------------->>>");
		}
	
	}
}
