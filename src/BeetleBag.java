import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BeetleBag {
    public static void main(String[] args) {
        int t = nextInt();
        int c, n;
        String[] line;
        int[] wt;
        int[] f;
        ArrayList<Integer> res = new ArrayList<>();
        for (int j = 0; j < t; j++) {
            c = nextInt();
            n = nextInt();
            wt = new int[n];
            f = new int[n];
            for (int i = 0; i < n; i++) {
                line = nextLine().split(" ");
                wt[i] = Integer.parseInt(line[0]);
                f[i] = Integer.parseInt(line[1]);
            }
            res.add(beetleBag(c, wt, f, n));
        }

        for (Integer re : res) System.out.println(re);
    }

    private static int beetleBag(int W, int[] wt, int[] val, int n) {
        int[][] K = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int w = 0; w < W + 1; w++) {
                if (i == 0 || w == 0)
                    K[i][w] = 0;
                else if (w >= wt[i - 1])
                    K[i][w] = Math.max(K[i - 1][w], val[i - 1] + K[i - 1][w - wt[i - 1]]);
                else
                    K[i][w] = K[i - 1][w];

            }
        }
        return K[n][W];
    }

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static String next() {
        while (st == null || !st.hasMoreElements()) {
            try {
                st = new StringTokenizer(br.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return st.nextToken();
    }

    private static String nextLine() {
        String str = "";
        try {
            str = br.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    private static int nextInt() {
        return Integer.parseInt(next());
    }
}