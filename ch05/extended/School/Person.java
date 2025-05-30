package ch05.extended.School;

public class Person { // 부모 클래스
	private String name; // 이름
	private int height; // 키
	private int weight; // 몸무게
	private int age; // 나이 개인적 필드 생성
	
	
	public Person(String name, int height, int weight, int age) {
		super(); // 부모 생성자의 객체 생성용
		this.name = name;
		this.height = height;
		this.weight = weight;
		this.age = age;
	}

	// 게터 세터 생성(입출력을 보호하기 위함)
	public String getName() {
		return name;
	}


	public int getHeight() {
		return height;
	}


	public int getWeightl() {
		return weight;
	}


	public int getAge() {
		return age;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setHeight(int height) {
		this.height = height;
	}


	public void setWeightl(int weight) {
		this.weight = weight;
	}


	public void setAge(int age) {
		this.age = age;
	}

}
