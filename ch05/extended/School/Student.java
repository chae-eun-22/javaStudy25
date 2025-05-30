package ch05.extended.School;

public class Student extends Person{
	
	private String sudentID;
	private int grade;
	private int gpa;
	
	
	public Student(String name, int height, int weight, int age, String sudentID, int grade, int gpa) {
		super(name, height, weight, age);
		this.sudentID = sudentID;
		this.grade = grade;
		this.gpa = gpa;
	}


	public String getSudentID() {
		return sudentID;
	}


	public int getGrade() {
		return grade;
	}


	public int getGpa() {
		return gpa;
	}


	public void setSudentID(String sudentID) {
		this.sudentID = sudentID;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public void setGpa(int gpa) {
		this.gpa = gpa;
	}
	
	
	public void show() {
		System.out.println("---------------------");
		System.out.println("학생 이름: " + getName());
		System.out.println("학생 나이: " + getAge());
		System.out.println("학생 키: " + getHeight());
		System.out.println("학생 몸무게: " + getWeightl());
		System.out.println("---------------------"); // 부모 클래스로 생성
		System.out.println("학생 학번: " + getSudentID()); // 자식 클래스
		System.out.println("학생 학년: " + getGrade());
		System.out.println("학생 학점: " + getGpa());
		System.out.println("----------------------");
		
	}
	
	
}
