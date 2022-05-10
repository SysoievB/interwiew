package interview;

/**
 * Print integers 1 to N, but print “Fizz” if an integer is divisible by 3,
 * “Buzz” if an integer is divisible by 5, and “FizzBuzz” if an integer is
 * divisible by both 3 and 5.
 */
public class TaskOneClass {

    public static void main(String[] args) {
        TaskOneClass.printFizz(15);
    }

    public static void printFizz(int number) {
        for (int i = 1; i <= number; i++) {

            if (i % 15 == 0) {
                System.out.println("FizzBass");
            } else if (i % 3 == 0) {
                System.out.println("Fizz");
            } else if (i % 5 == 0) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

}
