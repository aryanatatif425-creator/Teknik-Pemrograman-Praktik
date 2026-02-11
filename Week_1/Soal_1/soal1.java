import java.nio.ByteOrder;
import java.util.Scanner;

public class soal1 {

    public static void main(String[] args) {
        
         Scanner input = new Scanner(System.in);

    int Testcase = input.nextInt();

    for (int i = 0; i < Testcase; i++  ) {

      try {

        long n = input.nextLong();

        System.out.println(n + " can be fitted in : ");

        if (n >= Byte.MIN_VALUE && n <= Byte.MAX_VALUE) {
            System.out.println("*byte");
        }

        if (n >= Short.MIN_VALUE && n <= Short.MAX_VALUE ){
            System.out.println("*Short");
        }

           if (n >= Integer.MIN_VALUE && n <= Integer.MAX_VALUE ){
            System.out.println("*int");
        }

        System.out.println("*long");

      } catch (Exception e) {

        System.out.println(input.next() + "can't be fitted anywhere ");

      }

    }

    }
    
   

}
