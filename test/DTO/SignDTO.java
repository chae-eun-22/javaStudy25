package test.DTO;

public class SignDTO {
	// 개인적 필드
	private String name; // 이름
	private String Phone; // 전화번호
	private String ssn; // 주민번호
	
	
	// 생성자
	public SignDTO(String name, String phone, String ssn) {
		super();
		this.name = name;
		Phone = phone;
		this.ssn = ssn;
	}

	
	// 기본 생성자
	public SignDTO() {
		super();
	}


	// 메서드
	public String getName() {
		return name;
	}


	public String getPhone() {
		return Phone;
	}


	public String getSsn() {
		return ssn;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setPhone(String phone) {
		Phone = phone;
	}


	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	
}
