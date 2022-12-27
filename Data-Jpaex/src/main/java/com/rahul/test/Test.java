package com.rahul.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.rahul.entity.Student;
import com.rahul.repo.StudentRepository;

@Component
public class Test implements CommandLineRunner {
	@Autowired
	StudentRepository srepo;
	Scanner scanner = new Scanner(System.in);

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println(
					"Press 1: Add Student\nPress 2: Add Mltiple Students\nPress 3: Show Student Data\nPress 4: Show All Students Data");
			System.out.println(
					"Press 5: Update Student Data\nPress 6: Delete Student Data\nPress 7: Delete All Student Data\nPress 8: Exit");
			int choice = scanner.nextInt();
			switch (choice) {
			case 1:
				if (insertStudent())
					System.out.println("Data Saved Successfully.....");
				else
					System.out.println("Something went  wrong!!!");
				break;
			case 2:
				if (insertMultipleStudents())
					System.out.println("All Data Saved Successfully.....");
				else
					System.out.println("Something went  wrong!!!");
				break;
			case 3:
				showStudent();
				break;
			case 4:
				showAllStudents();
				break;
			case 5:
				updateStudent();
				break;
			case 6:
				deleteStudent();
				break;
			case 7:
				deleteAllStudents();
				break;
			case 8:
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice!!!!! plz try again..");
				break;
			}
		}
	}

	private void deleteAllStudents() {
		// TODO Auto-generated method stub
		srepo.deleteAll();
	}

	private void deleteStudent() {
		// TODO Auto-generated method stub
		System.out.println("Enter Student Id");
		int id = scanner.nextInt();
		srepo.deleteById(id);
		System.out.println("Data deleted successfully.....");
	}

	private void updateStudent() {
		// TODO Auto-generated method stub
		System.out.println("Enter Student Id");
		int id = scanner.nextInt();
		Student student = inputData();
		srepo.save(new Student(id, student.getStdName(), student.getStdFee()));
		System.out.println("Data Updated....");
	}

	private void showAllStudents() {
		// TODO Auto-generated method stub
		List<Student> list = srepo.findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}

	private void showStudent() {
		// TODO Auto-generated method stub
		System.out.println("Enter Student Id");
		int id = scanner.nextInt();
		Optional<Student> optional = srepo.findById(id);
		Student student = optional.get();
		System.out.println(student);

	}

	private boolean insertMultipleStudents() {
		// TODO Auto-generated method stub
		List<Student> list = new ArrayList<Student>();
		System.out.println("Enter Number to Insert Students Data");
		int num = scanner.nextInt();
		for (int i = 1; i <= num; i++) {
			System.out.println(i + ": Student Data");
			list.add(inputData());
		}
		if (srepo.saveAll(list) != null) {
			return true;
		}
		return false;
	}

	private boolean insertStudent() {
		if (srepo.save(inputData()) != null)
			return true;
		return false;
	}

	public Student inputData() {
		System.out.println("Enter Student Name:- ");
		scanner.nextLine();
		String name = scanner.nextLine();
		System.out.println("Enter Student Fee :-");
		double fee = scanner.nextDouble();
		return new Student(name, fee);
	}
}
