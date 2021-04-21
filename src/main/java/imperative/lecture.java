import java.util.*;
import java.util.function.Consumer;

public class Main
{
    public static void main(String[] args) {
        // immutable list: 
        List<Integer> numbers = List.of(1, 2, 3, 4);
        
        // throws an error 
        // numbers.set(0, 5);
        
        // mutable list:
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4);
        
        // this is fine 
        numbers2.set(0, 5);
        
        // numbers2.stream()
        //     .map(String::valueOf) // equals to (num) -> String.valueOf(num)
        //     .forEach(System.out::println);
        
        // numbers2.stream()
        //     // .map(num -> String.valueOf(num))
        //     .map(num -> String.valueOf(num))
        //     .forEach(System.out::println);
        
        int result = numbers2.stream()
            // .reduce(0, (total, e) -> Integer.sum(total, e));
            .reduce(0, Integer::sum);
            
        // System.out.println(result);
        
        List<String> letters = Arrays.asList("a", "b", "c", "d", "e");
        
        String result2 = letters.stream()
            .reduce("", (word, str) -> word + str.toUpperCase());
            
        System.out.println(result2);
        
        String result3 = numbers2.stream()
            // .map(e -> String.valueOf(e))
            .map(String::valueOf)
            // .reduce("", (carry, str) -> carry.concat(str));
            .reduce("", String::concat);
            
        System.out.println(result3);
    }
}
