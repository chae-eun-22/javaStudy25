package test.DTO;

public class LoginDTO {
	// 개인적 필드
	private String id; // 아이디
	private String pw; // 비밀번호
	private String email; // 이메일

	
	// 생성자
	public LoginDTO(String id, String pw,  String email) {
		// LoginDTO loginDTO = new LoginDTO(아이디, 비밀번호, 닉네임, 이메일)
		super();
		this.id = id;
		this.pw = pw;
		this.email = email;
	}

	// 기본 생성자
	public LoginDTO() {
		super();
	}


	// 메서드 (게터 세터)
	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getEmail() {
		return email;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
