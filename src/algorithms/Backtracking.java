package algorithms;

//https://hongjw1938.tistory.com/88
/*
재귀적으로 문제를 하나씩 풀어나가되 현재 재귀를 통해 확인 중인 상태(노드)가 제한
조건에 위배되는지(유망하지 않은지) 판단하고 그러한 경우 해당 상태(노드)를 제외하고
다음 단계로 나아가는 방식
 */
public class Backtracking {
    static int N = 4;
    static int[][] board = new int[4][4];

    public static void main(String[] args) {
        if (put_queen(0) == false) {
            System.out.println("Solution does not exist!");
        } else {
            for (int i=0; i < N; i++) {
                for (int j=0; j<N; j++) {
                    System.out.print(board[i][j] + ", ");
                }
                System.out.println();
            }
        }
    }

    // 재귀와 반복을 통해 문제를 해결하는 메소드(각 컬럼에 대해 체크)
    private static boolean put_queen(int col) {
        // N보다 열의 숫자가 높거나 같다면 모든 열에 퀸이 배치된 상태를 의미
        if (col >= N) return true;

        // 현재 열(Column)에서 각 행을 하나씩 체크한다.
        for (int i=0; i<N; i++) {
            // 현재 열의 i번째 행에 퀸을 위치시킬 수 있는지 파악
            if (check(i, col) == true) {
                board[i][col] = 1;

                // 위치 시켰으면, 이후 열에 대해서도 연속적으로 가능한지 확인
                if (put_queen(col+1) == true) {
                    return true;
                }

                // 만약 이후 열에 대해서 true 반환이 안되었다면 다시 0으로 수행하고
                // 백트래킹을 통해 다음 row로 넘어가서 수행
                board[i][col] = 0;
            }
        }
        // true를 이전에 반환 못했다면 답이 없는것이므로 false 반환
        return false;
    }

    // 현재 행/열에 퀸이 배치된 상태인지 확인하는 메소드
    private static boolean check(int row, int col) {
        int i, j;

        // 현재 행의 모든 열에 퀸이 있는지 테스트
        for (i=0; i<col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // 현재 위치의 좌상단 대각선으로 퀸이 있는지 테스트
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // 현재 위치의 우하단 대각선으로 퀸이 있는지 테스트
        for (i = row, j = col; i < N && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        return true;
    }

}
