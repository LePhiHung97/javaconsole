package services;

import java.util.Comparator;

import model.Student;

public class DiemComparator implements Comparator<Student> {

	@Override
	public int compare(Student s1, Student s2) {
		if(s1.getDiem()==s2.getDiem())  
			return 0;  
		else if(s1.getDiem()<s2.getDiem())  
		return 1;  
	else  
		return -1;  
	}  
	

}

