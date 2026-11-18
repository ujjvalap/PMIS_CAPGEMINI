package CG_Java_Training.Day11;

import java.util.List;
import java.util.stream.Collectors;

public class lamda1 {
    public static void main(String[] args) {

        List<Integer> nums = List.of(2, 4, 3, 6, 2, 6, 56);

        List<Integer> res = nums.stream()
                .sorted()
                .collect(Collectors.toList());

        System.out.println(res);
    }
}
