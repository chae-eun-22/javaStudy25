package ch01;

public class Printf {

	public static void main(String[] args) {
		int i = 97;
		String s = "Java";
		double f = 3.14f;
		System.out.printf("%d\n", i); // 10진수
		System.out.printf("%o\n", i); // 8진수
		System.out.printf("%x\n", i); // 16진수
		System.out.printf("%c\n", i); // char
		System.out.printf("%5d\n", i); // 5칸 중 오른쪽에 적고 앞에는 비워둠
		System.out.printf("%05d\n", i); // 5칸 중 오른쪽에 적고 앞에는 0으로 채움
		System.out.printf("%s\n", s); // 문자열 출력
		System.out.printf("%5s\n", s); // 5칸 중 오른쪽에 적고 앞에 비워둠
		System.out.printf("%-5s\n", s);	// 5칸 중 앞에서부터 적지만 뒤에는 비워둠
		System.out.printf("%f\n", f);
		System.out.printf("%e\n", f);
		System.out.printf("%4.1f\n", f); // 4칸 중 오른쪽에 적으며 소수점 첫번째 자리까지만 적음 앞에는 비워둠
		System.out.printf("%04.1f\n", f); // 4칸 중 소수점 첫번째 자리까지만 적고 앞에는 0으로 채움
		System.out.printf("%-4.1f\n", f); // 4칸 중 앞에서부터 적지만 소수점 첫번째 자리까지만 적고 뒤에는 비워둠

	}

}
