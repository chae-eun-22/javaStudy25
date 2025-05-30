package test.DTO;

public class GradeDTO {
	// 개인적인 필드
	private int kor; // 국어 점수
	private int eng; // 영어 점수
	private int math; // 수학 점수
	private int score = kor + eng + math ; // 총점
	private double avg = (double)score / 3; // 평균

	
	// 생성자
	public GradeDTO(int kor, int eng, int math, int score, double avg) {
		super();
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.score = score;
		this.avg = avg;
	}

	// 기본 생성자
	public GradeDTO() {
		super();
	}


	// 메서드(게터 세터)
	public int getKor() {
		return kor;
	}

	public int getEng() {
		return eng;
	}

	public int getMath() {
		return math;
	}

	public int getScore() {
		return score;
	}

	public double getAvg() {
		return avg;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}
	
}
