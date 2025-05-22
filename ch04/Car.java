package ch04;

import java.util.Scanner;

public class Car {
	// 필드: 객체가 가지고 있어야 하는 값(글로벌 변수(GV))
	// 고유 데이터
	public String company; // 제작회사(현대, 기아, KGM, 쉐보레, 아우디)
	public String model; // 아반테, 그렌져, 쏘나타
	public String color; // 빨간색, 은색, 검정색, 흰색
	public int maxSpeed = 300; // 최고속도
	public int minSpeed = 0; // 최저속도
	public String oilType; // 경유, 휘발유
	public int maxOil = 100;
	public int minOil = 0;

	// 상태값(변동가능)
	public int speed;
	public int rpm;
	public int oil;

	// 부품 -> 다른 클래스를 생성하여 연결한다.
	/*
	 * public Body body; public Engine engine; public Tire tire
	 */

	// 부품에 필드 사용법
	// Car myCar = new Car(); -> 객체 생성(인스턴스)
	// myCar.maxSpeed = 300; -> 객체 있는 maxSpeed에 300 정수를 넣는다.

	// 기본생성자: 생략 가능 | 객체가 생성할 때 사용되는 메서드(클래스명과 같은 이름)
	public Car() {
		speed = 0;
		rpm = 50;
		oil = 100;
	} // 객체가 생성되면서 변수에 값이 저장됨

	// 사용자지정 생성자: 개발자가 응용하는 기법
	// 사용자지정 생성자가 만들었지만 기본 생성자는 자동으로 생성되지 않는다.
	public Car(String company, String model, String color) {
		this.company = company;
		this.model = model;
		this.color = color;
	} // Car myCar = new Car("벤츠", "이클레스", "빨강");

	// 메서드: 객체가 수행해야 되는 동작
	// C(시동시작) R(차량상태, 주행상태) U(가속, 감속, 주차) D(시동종료)
	public void start() {

		System.out.println(this.model + "가(이) 주행을 시작합니다.");
		System.out.println("현재 속도: " + this.speed);
		System.out.println("현재 rmp: " + this.rpm);
		System.out.println("현재 주유량: " + this.oil);
	}

	public void goas(Scanner input, boolean run) {

		while (run) {
			System.out.println("1. 엑셀");
			System.out.println("2. 브레이크");
			System.out.println("3. 주유하기");
			System.out.println("4. 차량 메뉴로 돌아가기");
			System.out.print(">>>");
			int cho = input.nextInt();

			switch (cho) {
			case 1:
				System.out.println("속도를 올립니다.");
				
				speed += 20;
				if (speed >= maxSpeed) { // 현재속도가 최고속도보다 크거나 같으면
					speed = maxSpeed;
				} // 300초과 출력 안됨
				
				oil -= 5;
				if (oil >= maxOil) { // 100초과 출력 안됨
					oil = maxOil;
				} else if(oil <= minOil) { // 0미만 출력 안됨
					oil = minOil;
				}

				System.out.println("현재 속도: " + speed + "km/h");
				System.out.println("현재 주유량: " + oil);
				
				if(oil <= 30) {
					System.out.println("주유가 필요합니다.");
				} if(oil <= minOil) {
					System.out.println("시동이 꺼집니다.");
					System.out.println("===============");
					run = false;
				}
				break;

			case 2:
				System.out.println("속도를 줄입니다.");
				
				speed -= 10;
				if (speed <= minSpeed) { // 0미만 출력 안됨
					speed = minSpeed;
				} 
				
				oil -= 5;
				if(oil <= minOil) { // 0미만 출력 안됨
					oil = minOil;
				}
				

				System.out.println("현재 속도: " + speed + "km/h");
				System.out.println("현재 주유량: " + oil + "L");
				
				if(oil <= 30) {
					System.out.println("주유가 필요합니다.");
				} if(oil <= minOil) {
					System.out.println("시동이 꺼집니다.");
					System.out.println("===============");
					run = false;
				}
				
				break;

			case 3:
				System.out.println("얼마나 주유하시겠습니까?");
				System.out.println("1. 20L");
				System.out.println("2. 40L");
				System.out.println("3. 60L");
				System.out.println("4. 80L");
				System.out.println("5. 시동 메뉴로 돌아가기");
				System.out.print(">>>");
				int oilch = input.nextInt();
				
				switch(oilch) {
				case 1:
					System.out.println("20L를 주유합니다.");
					
					oil += 20;
					if (oil >= maxOil) { // 100초과 출력 안됨
						oil = maxOil;
					}
					
					System.out.println("주유가 완료되었습니다.");
					System.out.println("현재 주유량: " + oil + "L");
					break;
					
				case 2:
					System.out.println("40L를 주유합니다.");
					
					oil += 40;
					if (oil >= maxOil) { // 100초과 출력 안됨
						oil = maxOil;
					}
					
					System.out.println("주유가 완료되었습니다.");
					System.out.println("현재 주유량: " + oil + "L");
					break;
				
				case 3:
					System.out.println("60L를 주유합니다.");
					
					oil += 60;
					if (oil >= maxOil) { // 100초과 출력 안됨
						oil = maxOil;
					}
					
					System.out.println("주유가 완료되었습니다.");
					System.out.println("현재 주유량: " + oil + "L");
					break;
					
				case 4:
					System.out.println("80L를 주유합니다.");
					
					oil += 80;
					if (oil >= maxOil) { // 100초과 출력 안됨
						oil = maxOil;
					}
					
					System.out.println("주유가 완료되었습니다.");
					System.out.println("현재 주유량: " + oil + "L");
					break;
					
				case 5:
					System.out.println("5. 시동 메뉴로 돌아가기");
					break;
					
				default:
					System.out.println("없는 번호입니다. 다시 입력하세요.");
				}
				
				break;

			case 4:
				System.out.println("차량 메뉴로 돌아갑니다.");
				 run = false;
				 break;
				 
			default:
				System.out.println("없는 번호입니다. 다시 입력하세요.");
				
			}
		}
	}

}
