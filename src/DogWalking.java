import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class DogWalking {
    public static void main(String[] args) {
        int t = nextInt();
        int N, K=0;
        List<Integer> sizes = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        List<Integer> differences = new ArrayList<>();
        for (int i = 0; i < t; i++) {
            N = nextInt();
            K = nextInt();
            for (int j = 0; j < N; j++) {
                sizes.add(nextInt());
            }

            Collections.sort(sizes);

            for (int k = 0; k < sizes.size() - 1; k++) {
                differences.add(sizes.get(k + 1) - sizes.get(k));
            }
            Collections.sort(differences);
            Collections.reverse(differences);

            int result = sizes.get(sizes.size() - 1) - sizes.get(0);
            if (K != 1) {
                for (int l = 0; l < K - 1; l++) {
                    result -= differences.get(l);
                }
            }
            res.add(result);
            sizes = new ArrayList<>();
            differences = new ArrayList<>();
        }

        for (Integer e : res)
            System.out.println(e);
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

    private static int nextInt() {
        return Integer.parseInt(next());
    }
}
