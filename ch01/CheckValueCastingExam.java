package ch01;

public class CheckValueCastingExam {

	public static void main(String[] args) {
		int i = 128 ;
		
		if( (i<Byte.MIN_VALUE)||(i>Byte.MAX_VALUE)) {
			// i의 값이 Byte의 최소값보다 작거나 최대값보다 크면
			System.out.println("byte타입으로 변환할 수 없습니다.");
			System.out.println(Byte.MIN_VALUE + "값보다 작거나");
			System.out.println(Byte.MAX_VALUE + "값보다 큽니다.");
		} else {
			byte b = (byte) i ; // int를 byte로 강제타입변환
			System.out.println(b);
		}

	}

}
