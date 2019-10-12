import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

public class BlackgatePenitentiary {
    public static void main(String[] args) {
        int n = nextInt();
        String[] line;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            line = nextLine().split(" ");
            map.put(line[0], Integer.parseInt(line[1]));
        }

        ArrayList[] n_h = sortMap(map, 1);
        ArrayList<String> names = n_h[0];
        ArrayList<Integer> heights = n_h[1];

        int min_h;
        String min_n;
        List<String> min_names = new ArrayList<>();
        int min, cnt;
        int j;

        for (int i = 0; i < heights.size(); ) {
            min_h = heights.get(i);
            min_n = names.get(i);
            min_names.add(min_n);
            min = i + 1;
            cnt = 0;
            for (j = i + 1; j < heights.size(); j++) {
                if (heights.get(j) == min_h) {
                    min_names.add(names.get((j)));
                    cnt++;
                } else break;
            }
            i = j;
            Collections.sort(min_names);
            for (String name : min_names)
                System.out.print(name + " ");
            int max = min + cnt;
            System.out.print(min + " " + max);
            System.out.println();
            min_names = new ArrayList<>();
        }
    }

    // if kv = 0 sort by keys
    // if kv = 1 sort by values
    private static <K, V> ArrayList[] sortMap(Map<K, V> map, int kv) {
        Map<K, V> copy = new HashMap<>(map);
        ArrayList<K> keys = new ArrayList<>();
        ArrayList<V> values = new ArrayList<>();
        while (copy.size() != 0) {
            Map.Entry<K, V> minEntry = null;
            for (Map.Entry<K, V> entry : copy.entrySet()) {
                if (kv == 0) {
                    if (minEntry == null || entry.getKey().toString().compareTo(minEntry.getKey().toString()) < 0)
                        minEntry = entry;
                } else if (kv == 1) {
                    if (minEntry == null || entry.getValue().toString().compareTo(minEntry.getValue().toString()) < 0)
                        minEntry = entry;
                }
            }
            keys.add(minEntry.getKey());
            values.add(minEntry.getValue());
            copy.remove(minEntry.getKey());
        }
        ArrayList[] result = new ArrayList[2];
        result[0] = keys;
        result[1] = values;
        return result;
    }

    // -------------------------------------------------- Fast Reader --------------------------------------------------
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

    private static long nextLong() {
        return Long.parseLong(next());
    }

    private static double nextDouble() {
        return Double.parseDouble(next());
    }

    private static float nextFloat() {
        return Float.parseFloat(next());
    }

    private static BigInteger nextBigInteger() {
        return new BigInteger(next());
    }

    private static BigDecimal nextBigDecimal() {
        return new BigDecimal(next());
    }
}
