import java.util.List;

public class FP01 {
    public static void main(String args[]) {
        List<Integer> numbers = List.of(12,4,5,67,45,24,90,20);
        printNumbers(numbers);
        printEvenNumbers(numbers);
        printEvenNumbersLambdaFunction(numbers);
    }



    private static boolean isEven(int number){
        return number%2 == 0;
    }
    private static void printEvenNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(FP01::isEven) //Specifying condition
                .forEach(System.out::println); //Method Reference
    }

    private static void printEvenNumbersLambdaFunction(List<Integer> numbers) {
        numbers.stream()
                .filter( number -> number %2==0) //Lambda Expression
                .forEach(System.out::println);
    }

    private static void printNumbers(List<Integer> numbers) {
        numbers.stream()
                .forEach(System.out::println);
    }

}
