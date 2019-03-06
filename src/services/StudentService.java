package services;

import java.util.List;
import java.util.Scanner;

import model.Student;

public class StudentService {

	public static Student inputInformation() {
		Student student = new Student();

		int masv = 0;
		String hoten = "";
		int namsinh = 0;
		String lop = "";
		Double diem = 0.0;
		
		Scanner input = new Scanner(System.in);

		do {
			System.out.println("Nhap vao ma sv : ");
			try {
				masv = input.nextInt();
				if (masv < 0)
					System.out.println("Ma sv phai lon hon 0");
			} catch (Exception e) {
				System.out.println("Dinh dang ko chinh xac !");

			}
		} while (masv < 0);

		input.nextLine();
		System.out.println("Nhap vao ho ten : ");
		hoten = input.nextLine();

		do {
			System.out.println("Nhap vao nam sinh : ");
			try {
				namsinh = input.nextInt();
				if (namsinh < 0)
					System.out.println("Nam sinh phai lon hon 0");
			} catch (Exception e) {
				System.out.println("Dinh dang ko chinh xac !");

			}
		} while (namsinh < 0);

		input.nextLine();
		System.out.println("Nhap vao lop : ");
		lop = input.nextLine();
		input = new Scanner(System.in);

		do {
			System.out.println("Nhap vao diem ");
			try {
				diem = input.nextDouble();
			} catch (Exception e) {
				System.out.println("Dinh dang ko chinh xac !");
			}
		} while (diem < 0 || diem > 10);

		student.setMasv(masv);
		student.setHoten(hoten);
		student.setNamsinh(namsinh);
		student.setLop(lop);
		student.setDiem(diem);

		return student;
	}

	public static Student findStudent(int masv, List<Student> list) {
		for (Student student : list) {
			if (student.getMasv() == masv)
				return student;
		}
		return null;
	}

	public static void display(Student s) {
		System.out.println(
				s.getMasv() + " - " + s.getHoten() + " - " + s.getNamsinh() + " - " + s.getLop() + " - " + s.getDiem());
	}

}
