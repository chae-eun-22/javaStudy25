package ch05.Getter_Setter;

public class Car {
	// 개인적인 필드 선언
	private int speed;
	private boolean stop;
	
	// 공용 메서드
	public int  getSpeed() { // 게터 설정
		return speed;
	}
	
	public void setSpeed (int speed) { // 세터 설정
		if(speed < 0) {
			this.speed = 0;
			return;
		} else {
			this.speed = speed;
		} // speed 입력값이 음수이면 0으로 입력
	}
	
	// Getter
	public boolean isStop() {
		return stop;
	}
	
	// Setter
	public void setStop(boolean stop) {
		this.stop = stop;
		this.speed = 0;
	} // stop값이 true이면 스톱을 진행하고 스피드 0으로 조절
}
