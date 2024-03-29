package ColumbusStudy.Chap02;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다. 어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
예를 들어, 245의 분해합은 256(=245+2+4+5)이 된다. 따라서 245는 256의 생성자가 된다. 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다. 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
 */
//첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
//첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.
public class D02_BJ2231_240319 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 자릿수의 길이를 알기위해 일단 문자열로 입력받는다.
        String str_N = br.readLine();

        // 해당 문자열의 길이 변수
        int N_len = str_N.length();

        // 문자열을 정수(int)로 변환
        int N = Integer.parseInt(str_N);
        int result = 0;

        // i는 가능한 최솟값인 N - 9 * N의 각 자릿수부터 시작
        for (int i = (N - (N_len * 9)); i < N; i++) {
            int number = i;
            int sum = 0; // 각 자릿수 합 변수

            while(number != 0) {
                sum += number % 10; // 각 자릿수 더하기
                number /= 10;
            }

            // i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우)
            if (sum + i == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
