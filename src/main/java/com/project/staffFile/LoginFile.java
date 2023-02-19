package com.project.staffFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import com.project.student.Student;

public class LoginFile {
	public static boolean read(String name,String pass) throws IOException, ClassNotFoundException {
		BufferedReader br=new BufferedReader(new FileReader("login.txt"));
		if(br.read()==-1)
			return false;
		ObjectInputStream oos=new ObjectInputStream(new FileInputStream("login.txt"));
		HashMap<String, String> map=(HashMap<String, String>) oos.readObject();
		oos.close();
		br.close();
		
		if(map.containsKey(name) && map.get(name).equals(pass)) {
			return true;
		}
		return false;
		
	}
	
	public static void add(String name,String pass) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream oos=new ObjectInputStream(new FileInputStream("login.txt"));
		HashMap<String, String> map=(HashMap<String, String>) oos.readObject();
		if(map.containsKey(name)) {
			System.out.println("<<<---------Uesr name already Exists---------->>>");
		}
		else {
			map.put(name, pass);
			write(map);
			System.out.println("\n<<<----------New Admin Added Successfully----------->>>\n");
		}
	}

	public static void write(HashMap<String, String> map) throws FileNotFoundException, IOException {
		ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream ("login.txt"));
		oos.writeObject(map);
		oos.close();
		
	}
}
