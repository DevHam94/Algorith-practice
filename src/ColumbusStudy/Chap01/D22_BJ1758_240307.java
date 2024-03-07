package ColumbusStudy.Chap01;

import java.io.*;
import java.util.Arrays;

public class D22_BJ1758_240307 {
    /*
스타박스는 손님을 입장시킬 때 독특한 방법으로 입장시킨다.
스타박스에서는 손님을 8시가 될 때 까지, 문앞에 줄 세워 놓는다. 그리고 8시가 되는 순간 손님들은 모두 입구에서 커피를 하나씩 받고, 자리로 간다. 강호는 입구에서 커피를 하나씩 주는 역할을 한다.
손님들은 입구에 들어갈 때, 강호에게 팁을 준다. 손님들은 자기가 커피를 몇 번째 받는지에 따라 팁을 다른 액수로 강호에게 준다. 각 손님은 강호에게 원래 주려고 생각했던 돈 - (받은 등수 - 1) 만큼의 팁을 강호에게 준다.
만약, 위의 식으로 나온 값이 음수라면, 강호는 팁을 받을 수 없다.
예를 들어, 민호는 팁을 3원 주려고 했고, 재필이는 팁을 2원, 주현이가 팁을 1원 주려고 한 경우를 생각해보자.
민호, 재필, 주현이 순서대로 줄을 서있다면, 민호는 강호에게 3-(1-1) = 3원, 재필이는 2-(2-1) = 1원, 주현이는 1-(3-1) = -1원을 팁으로 주게 된다. 주현이는 음수이기 때문에, 강호에게 팁을 주지 않는다. 따라서, 강호는 팁을 3+1+0=4원을 받게 된다.
스타박스 앞에 있는 사람의 수 N과, 각 사람이 주려고 생각하는 팁이 주어질 때, 손님의 순서를 적절히 바꿨을 때, 강호가 받을 수 잇는 팁의 최댓값을 구하는 프로그램을 작성하시오.
     */
    //첫째 줄에 스타박스 앞에 서 있는 사람의 수 N이 주어진다. N은 100,000보다 작거나 같은 자연수이다. 둘째 줄부터 총 N개의 줄에 각 사람이 주려고 하는 팁이 주어진다. 팁은 100,000보다 작거나 같은 자연수이다.
    // 강호가 받을 수 있는 팁의 최댓값을 출력한다.
    /*public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        int result = 0;
        for (int i=arr.length; i > 0; i--) {
           result += getTip(arr.length - i + 1, arr[i - 1]);
        }

        System.out.println(result);
    }

    static int getTip(int n, int tip) {
        int result = tip - (n - 1);
        return (result < 0) ? 0 : result;
    }*/

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        long answer = 0;
        int[] tips = new int[n];

        for (int i=0; i<n; i++) {
            tips[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(tips);

        for (int i=n-1; i>=0; i--) {
            int tip = tips[i] - (n - i - 1);
            if (tip > 0) answer+= tip;
        }
        bw.write(answer + "");
        bw.flush();;
        bw.close();
        br.close();
    }
}
