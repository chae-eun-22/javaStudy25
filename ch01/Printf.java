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
		System.out.printf("%5d\n", i); // 5칸을 만들고 오른쪽에 적고 앞은 공백
		System.out.printf("%05d\n", i); // 5칸을 만들고 오른쪽에 적고 앞은 0으로 채운다.
		System.out.printf("%s\n", s); // 문자열을 그대로 출력
		System.out.printf("%5s\n", s); // 5칸을 만들고 오른쪽 정렬 후 앞은 공백
		System.out.printf("%-5s\n", s);	// 5칸을 만들고 왼쪽 정렬 후 뒤는 공백
		System.out.printf("%f\n", f);
		System.out.printf("%e\n", f);
		System.out.printf("%4.1f\n", f); // 4개의 칸에 소수점 첫 번째 자리까지만 적고 나머지는 공백
		System.out.printf("%04.1f\n", f); // 4개의 칸에 소수점 첫 번째 자리까지만 적고 앞에 0으로 채운다.
		System.out.printf("%-4.1f\n", f); // 4개의 칸에 왼쪽 정렬을 한 뒤 소수점 첫 번째 자리까지만 적고 나머지는 공백

	}

}
