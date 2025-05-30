package ch04.staticblock2;

public class Television {
	static String company = "Samsung";
	static String model = "LED";
	static String info;
	
	static { // 정적블록
		info = company + "-" + model;
	}
}
