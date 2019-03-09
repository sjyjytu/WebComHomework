import java.io.*;
import calculator.caculate;

public class Main {

    public static void main(String[] args) throws IOException {
        // 使用 System.in 创建 BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter lines of formula, end with ';'");
        System.out.println("Enter 'quit' to quit.");
        caculate caculator = new caculate();
        str = br.readLine();
        while (!str.equals("quit")) {
            caculator.cal(str);
            str = br.readLine();
        }
        System.out.println("goodbye!");
    }
}
