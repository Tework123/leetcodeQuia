import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class GoalParserInterpretation_1678 {

    public static void main(String[] args) {
        String command = "(al)G(al)()()G";
        var result = interpret(command);
        System.out.println(result);
    }


    public static String interpret(String command) {
        List<String> result = new ArrayList<>();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < command.length(); i++) {
            char ch = command.charAt(i);
            if (ch == '(') {
                list.add(ch);
            } else if (ch == ')') {
                int size = list.size();
                if (list.getLast() == '(') {
                    result.add("o");
                    list.removeLast();
                } else if (size >= 3 && list.get(size - 1) == 'l' && list.get(size - 2) == 'a' && list.get(size - 3) == '(') {
                    result.add("al");
                    list.remove(size - 1);
                    list.remove(size - 2);
                    list.remove(size - 3);


                }
            } else if (ch == 'a' || ch == 'l') {
                list.add(ch);
            } else if (ch == 'G') {
                result.add("G");
            }
        }
        return String.join("", result);
    }
}
