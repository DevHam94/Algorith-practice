package ColumbusStudy.Chap01;

import java.util.Scanner;

public class D01_BJ11720_240212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String num = sc.next();
        char[] numsum = num.toCharArray();
        int sum = 0;
        for (int i=0 ; i < numsum.length; i++) {
            sum += numsum[i] - '0';
        }

        System.out.println(sum);
    }
}
