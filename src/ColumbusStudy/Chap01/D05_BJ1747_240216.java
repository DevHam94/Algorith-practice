package ColumbusStudy.Chap01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D05_BJ1747_240216 {
    /*
어떤 수와 그 수의 숫자 순서를 뒤집은 수가 일치하는 수를 팰린드롬이라 부른다.
예를 들어 79,197과 324,423 등이 팰린드롬 수이다.
어떤 수 N (1 ≤ N ≤ 1,000,000)이 주어졌을 때, N보다 크거나 같고,
소수이면서 팰린드롬인 수 중에서, 가장 작은 수를 구하는 프로그램을 작성하시오.
     */
    // 첫째 줄에 N이 주어진다.
    // 첫째 줄에 조건을 만족하는 수를 출력한다

    // 에라토스테네스의 체를 사용한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

    }
}
