package com.project.staffFile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.TreeMap;

import com.project.staff.Staff;

public class Read {
	public static TreeMap<String,Staff>  readAll(String file) throws ClassNotFoundException, IOException {
		@SuppressWarnings("resource")
		BufferedReader br=new BufferedReader(new FileReader(file));
		if(br.read()==-1)
			return null;
		@SuppressWarnings("resource")
		ObjectInputStream oos=new ObjectInputStream(new FileInputStream(file));
		return (TreeMap<String, Staff>) oos.readObject();
		
	}
}
