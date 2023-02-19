package com.project.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.TreeMap;

import com.project.student.Student;

public class Read {
	@SuppressWarnings("unchecked")
	public static TreeMap<String,Student>  readAll(String file) throws ClassNotFoundException, IOException {
		@SuppressWarnings("resource")
		BufferedReader br=new BufferedReader(new FileReader(file));
		if(br.read()==-1)
		{
			System.out.println("No records");
			return null;
		}
		@SuppressWarnings("resource")
		ObjectInputStream oos=new ObjectInputStream(new FileInputStream(file));
		return (TreeMap<String, Student>) oos.readObject();
		
	}
}
