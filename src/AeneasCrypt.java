import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AeneasCrypt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int R = scanner.nextInt();
        String line_;
        String[] line;
        Map<String, Double> alphabet = new HashMap<>();
        scanner.nextLine();
        for (int i = 0; i < 26; i++) {
            line_ = scanner.nextLine();
            line = line_.split(" ");
            alphabet.put(line[0], Double.parseDouble(line[1]));
        }
        String text = scanner.nextLine();
        text = text.replaceAll("[^A-Za-z]+", "").toUpperCase();

        double len = R;
        double theta;
        double x;
        for (int i = 0; i < text.length() - 1; i++) {
            theta = Math.abs(alphabet.get(String.valueOf(text.charAt(i))) - alphabet.get(String.valueOf(text.charAt(i + 1))));
            x = R * Math.sin(theta * Math.PI / 180.0) / Math.sin((180 - theta) * Math.PI / 360.0);
            len += x;
        }

        System.out.println((int) Math.ceil(len));
    }
}
