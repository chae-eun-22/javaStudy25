package ch04.Singleton;

public class SingletonExam {

	public static void main(String[] args) {
		//Singleton obj1 = new Singleton();
		//Singleton obj2 = new Singleton(); 사용자의 private이 적용되어 안된다.
		
		Singleton obj3 = Singleton.getInstance();
		Singleton obj4 = Singleton.getInstance();
		
		if(obj3 == obj4) {
			System.out.println("같은 싱글톤 객체입니다.");
		} else {
			System.out.println("다른 싱글톤 객체입니다.");
		}
	}

}
