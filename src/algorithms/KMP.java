package algorithms;

public class KMP {

    static int[] makeTable(String pattern) {
        int n = pattern.length();
        int[] table = new int[n];

        int idx = 0;
        for (int i=1; i<n; i++) {
            // 일치하는 문자가 발생했을때 (idx>0), 연속적으로 더 일치하지 않으면 idx = table[idx-1]로 돌려준다.
            while (idx>0 && pattern.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }

            if (pattern.charAt(i) == pattern.charAt(idx)) {
                idx += 1;
                table[i] = idx;
            }
        }
        return table;
    }

    // 전통적인 구현 방식
    static void KMP1(String parent, String pattern) {
        int[] table = makeTable(pattern);

        int n1 = parent.length(), n2 = pattern.length();
        int begin = 0, matched = 0; // begin = matched = 0
        while (begin <= n1-n2) {
            // 만약 짚더미의 해당 글자가 바늘의 해당 글자와 같다면
            if (matched < n2 && parent.charAt(begin+matched) == pattern.charAt(matched)) {
                ++matched;
                // 결과적으로 m글자가 모두 일치했다면 답에 추가한다.
                if (matched == n2) {
                    //System.out.println(i-idx+1 + "번째에서 찾았습니다. ~" + (begin+1));
                }
            } else {
                // 예외 : matched가 0인 경우에는 다음 칸에서부터 계속
                if (matched == 0) {
                    ++begin;
                } else {
                    begin += matched - table[matched-1];
                    // begin을 옮겼다고 처음부터 다시 비교할 필요가 없다.
                    // 옮긴 후에도 table[matched-1]만큼은 항상 일치하기 때문이다.
                    matched = table[matched-1];
                }
            }
        }
    }

    // 다른구현 방식
    static void KMP2(String parent, String pattern) {
        int[] table = makeTable(pattern);

        int n1 = parent.length();
        int n2 = pattern.length();

        int idx = 0; // 현재 대응되는 글자 수
        for (int i=0; i<n1; i++) {
            // idx번 글자와 짚더미의 해당 글자가 불일치할 경우
            // 현재 대응된 글자의 수를 table[idx-1]번으로 줄인다.
            while (idx>0 && parent.charAt(i) != pattern.charAt(idx)) {
                idx = table[idx-1];
            }
            // 글자가 대응될 경우
            if (parent.charAt(i) == pattern.charAt(idx)) {
                if (idx == n2-1) {
                    System.out.println(i-idx+1 + "번째에서 찾았습니다. ~" + (i+1));
                    idx = table[idx];
                } else {
                    idx += 1;
                }
            }
        }
    }
}
