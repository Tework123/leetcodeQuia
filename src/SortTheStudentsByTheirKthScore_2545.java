import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortTheStudentsByTheirKthScore_2545 {
    public static void main(String[] args) {
        int[][] score = {
                {10, 6, 9, 1},
                {7, 5, 11, 2},
                {4, 8, 3, 15}
        };

        int k = 2;

        int[][] result = sortTheStudents(score, k);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.println(result[i][j]);
            }

        }

    }

    public static int[][] sortTheStudents(int[][] score, int k) {
        int[][] result = new int[score.length][score[0].length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < score.length; i++) {
            map.put(i, score[i][k]);
        }

        LinkedHashMap<Integer, Integer> sortedMap = map.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));


        int count = 0;
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            result[count] = score[entry.getKey()];
            count += 1;
        }
        return result;
    }
}
