package ch05.extended.package2;

import ch05.extended.package1.A;

public class D extends A {
	
	public D() {
		super(); // 부모 객체 소환
		this.field = "자바"; // 가능
		this.method();	// 가능
	}
}
