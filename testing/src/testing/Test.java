package testing;

import java.util.ArrayList;
import java.util.List;

public class Test{

 public static void main(String[] args) {

    List<Integer> numbers = new ArrayList<>();
    numbers.add(10);
    int first = numbers.get(1);

    System.out.println(first);
 }
}