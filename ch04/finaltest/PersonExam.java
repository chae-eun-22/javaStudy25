package ch04.finaltest;

public class PersonExam {

	public static void main(String[] args) {
		Person p1 = new Person("123456-1234567", "박채은");
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		
		// p1.nation = "USA"; final 필드로 수정할 수 없음
		// p1.ssn = "987654-9876543"; final 초기값이 이미 선언됨
		p1.name = "엠아이티";
		
		System.out.println(p1.nation);
		System.out.println(p1.ssn);
		System.out.println(p1.name);
		

	}

}
