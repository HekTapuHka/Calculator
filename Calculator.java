import java.util.Arrays;
import java.util.Scanner;


public class Calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Type information: ");
        String example = scanner.nextLine();
        System.out.print(calculate(example));
    }

    public static Integer calculate(String example){
        example = example.replace(" ", "");

        if(!example.matches("(< -10, > 10, [-+*/])")){
            throw new RuntimeException("ERROR");
        }

        Integer[] ints = Arrays.stream(example.split("[-+*/]")).map(Integer::parseInt).toArray(Integer[]::new);

        int result = ints[0];
        int counter = 1;
        for (char ch : example.replaceAll("[0-9]","").toCharArray()) {
            if (ch == '-') result -= ints[counter];
            if (ch == '+') result += ints[counter];
            if (ch == '*') result *= ints[counter];
            if (ch == '/') result /= ints[counter];

            counter++;
        }

        return result;
    }
}