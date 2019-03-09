# Calculator

### Environment

* development
  * Java
* test
  * Junit4



### Function

###### 	support

- [x] double number 520.1314
- [x] negative double number  -520.1314
- [x] add operation  +
- [x] minus operation  -
- [x] multiply operation  *
- [x] devide operation  /
- [x] residual operation  %
- [x] parentheses operation  ()
- [ ] variable  x=520.1314
- [ ] advanced function:  sqrt(9)  3!
- [ ] solve equations



### Usages

run the main function

~~~java
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
~~~



and input your formula like:

~~~text
1 + 1
~~~

~~~text
(18.2 * 3.34) / (2.4 - 3) + 23.567 * 1.2
~~~

~~~text
32 * -13.6
~~~

~~~text
520.1314 % 2.1
~~~

and enter quit to quit:

~~~text
quit
~~~

