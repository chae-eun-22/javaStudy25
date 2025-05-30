package ch05.package_exam.importmycompany;

import ch05.package_exam.hankook.SnowTire;
import ch05.package_exam.kia.Engine;
import ch05.package_exam.kumho.*;

public class Car {
	// 필드
	public String company;
	public String model;
	
	// 한국 타이어를 객체로 만듦
	ch05.package_exam.hankook.Tire tire1 = new ch05.package_exam.hankook.Tire();
	
	// 금호 타이어를 객체로 만듦
	Tire tire2 = new Tire();
	
	// 엔진은 기아 부품으로 사용함(import 확인)
	Engine kiaengine1 = new Engine();
	
	SnowTire snowTire = new SnowTire();
	
	BigWidthTire bigWidthTire = new BigWidthTire();
	
	SportTire sportTire = new SportTire();
}
