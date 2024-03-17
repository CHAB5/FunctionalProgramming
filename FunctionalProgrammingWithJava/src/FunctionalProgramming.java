import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FunctionalProgramming {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        List<String> courses = List.of("Spring", "Spring Boot", "API", "Microservices", "AWS",
                "PCF", "Azure", "Docker", "Kubernetes");

        printOddNumbers(numbers);

        printCoursesIndividually(courses);

        coursesContainingWordSpring(courses);

        printCoursesWithAtleast4Letters(courses);

        CubesOfOddNumbers(numbers);

        printNumberOfCharactersOfCourses(courses);

        squareNumbersAndSum(numbers);

        cubeNumbersAndSum(numbers);

        sumOfOddNumbers(numbers);

        listOfOddNumberinNewList(numbers);

        coursesLengthInList(courses);

        findFunctionalInterface(numbers);

        //behaviour parameterization
        Function<Integer, Integer> squareNumbersFunction = (x) -> x * x;
        System.out.println("Square of Numbers in a List: "
                        + squaredNumbers(numbers, squareNumbersFunction));

    }

    /**
     * Exercise 1
     * Print odd numbers
     *
     * @param numbers
     */
    private static void printOddNumbers(List<Integer> numbers) {
        numbers.stream().filter(number -> number % 2 != 0).forEach(System.out::println);
    }

    /**
     * Exercise 2
     * Print all courses individually
     *
     * @param courses
     */
    private static void printCoursesIndividually(List<String> courses) {
        courses.stream().forEach(System.out::println);
    }

    /**
     * Exercise 3
     * Print courses containing the word spring
     *
     * @param courses
     */
    private static void coursesContainingWordSpring(List<String> courses) {
        courses.stream().filter(course -> course.contains("Spring")).forEach(System.out::println);
    }

    /**
     * Exercise 4
     * Print courses with atleast 4 letters
     *
     * @param courses
     */
    private static void printCoursesWithAtleast4Letters(List<String> courses) {
        courses.stream()
                .filter(course -> course.length() >= 4)
                .forEach(System.out::println);
    }

    /**
     * Exercise 5
     * Print cubes of odd numbers
     *
     * @param numbers
     */
    private static void CubesOfOddNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number % 2 != 0)
                .map(number -> (int) Math.pow(number, 3))
                .forEach(System.out::println);
    }

    /**
     * Excercise 6
     * Characters in each course
     *
     * @param courses
     */
    private static void printNumberOfCharactersOfCourses(List<String> courses) {
        courses.stream()
                .map(String::length)
                .forEach(System.out::println);
    }


    /**
     * Exercise 7
     * Square of numbers in a list and their sum
     *
     * @param numbers
     */
    private static void squareNumbersAndSum(List<Integer> numbers) {
        System.out.println(numbers.stream()
                .map(number -> number * number)
                .reduce(0, (x, y) -> x + y));
    }

    /**
     * Exercise 8
     * Cube of numbers and their sum
     *
     * @param numbers
     */
    private static void cubeNumbersAndSum(List<Integer> numbers) {
        System.out.println(numbers.stream()
                .map(number -> number * number * number)
                .reduce(0, Integer::sum));
    }

    /**
     * Exercise 9
     * Sum of odd numbers in a List
     *
     * @param numbers
     */
    private static void sumOfOddNumbers(List<Integer> numbers) {
        System.out.println(numbers.stream()
                .filter(number -> number%2 != 0)
                .reduce(0, Integer::sum));
    }

    /**
     * Exercise 10
     * Create a List with Even Numbers Filtered from the Numbers List
     *
     * @param numbers
     */
    private static void listOfOddNumberinNewList(List<Integer> numbers) {
        System.out.println(
                numbers.stream()
                        .filter(number -> number%2 != 0)
                        .collect(Collectors.toList())
        );
    }

    /**
     * Exercise 11
     * Create a List with lengths of all course titles.
     *
     * @param courses
     */
    private static void coursesLengthInList(List<String> courses) {
        System.out.println(courses.stream()
                .map(String::length)
                .collect(Collectors.toList()));
    }

    /**
     * Exercise 12
     * Find Functional Interface behind the second argument of reduce method.
     * Create an implementation for the Functional Interface.
     *
     * @param numbers
     */
    private static void findFunctionalInterface(List<Integer> numbers) {
        BinaryOperator<Integer> sumOfIntegersFunction = Integer::sum;
        int sum = numbers.stream()
                .reduce(0,sumOfIntegersFunction);
        System.out.println(sum);
    }

    /**
     * Exercise 13
     * Do Behavior Parameterization for the mapping logic.
     * List squaredNumbers = numbers.stream() .map(x -> x*x) .collect(Collectors.toList());
     *
     * @param numbers
     * @param squareNumbersFunction
     * @return
     */
    private static List<Integer> squaredNumbers(List<Integer> numbers, Function<Integer, Integer> squareNumbersFunction) {
        return numbers.stream()
                .map(squareNumbersFunction)
                .collect(Collectors.toList());
    }

}
