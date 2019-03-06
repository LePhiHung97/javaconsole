package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import model.Student;
import services.DiemComparator;
import services.StudentService;
import util.ScreenUtil;

public class MainClass {

	static List<Student> listStudent = new ArrayList<Student>();
	static Scanner input = new Scanner(System.in);

	public static void xoaSinhVien() {
		System.out.println("Nhap ma sv muon xoa : ");
		int masv = input.nextInt();
		Student student = StudentService.findStudent(masv, listStudent);
		if (student == null) {
			System.out.println("Khong tim thay sv nay !");
		} else {
			listStudent.remove(student);
			System.out.println("Xoa thanh cong !");
		}
	}

	public static void suaSinhVien() {

		System.out.println("Nhap ma sv muon sua : ");
		int masv = input.nextInt();
		Student sv = StudentService.findStudent(masv, listStudent);
		if (sv == null) {
			System.out.println("Khong tim thay sv nay");

		} else
			sv = StudentService.inputInformation();
	}

	public static void themSinhVien() {
		boolean checkDuplicateStudentId = false;
		Student student = StudentService.inputInformation();

		for (Student s : listStudent)
			if (s.getMasv() == student.getMasv()) {
				checkDuplicateStudentId = true;
				System.out.println("Ma SV da ton tai !");
				break;
			}

		if (checkDuplicateStudentId == false)
			listStudent.add(student);
	}

	public static void xemDanhSach() {
		if (listStudent.size() == 0)
			System.out.println("Khong co sv nao trong danh sach");
		for (Student student : listStudent)
			System.out.println(student);
	}

	public static void sapXepDiem() {

		Collections.sort(listStudent, new DiemComparator());
		for (Student student : listStudent)
			System.out.println(student);
	}

	public static void main(String[] args) {

		int num = 0;
		do {
			ScreenUtil.printMenu();
			//Scanner input = new Scanner(System.in);
			num = input.nextInt();

			switch (num) {
			case 1: {
				themSinhVien();
				break;
			}
			case 2: {
				xemDanhSach();
				break;
			}
			case 3: {
				suaSinhVien();
				break;
			}
			case 4: {
				xoaSinhVien();
				break;

			}
			case 5: {
				sapXepDiem();
				break;
			}
			case 6:
				System.exit(0);
				break;
			}

		} while (num != 6);

	}

}
