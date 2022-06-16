import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// @lc code=start
class Solution {
    public String frequencySort(String s) {
        // use stream to get the freq map
        Map<Character, Long> map = s.codePoints().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(),
                        Collectors.counting()));
        // 用 Map.Entry 代替自定义 class
        List<Map.Entry<Character, Long>> list = new ArrayList<>();
        for (Map.Entry<Character, Long> i : map.entrySet()) {
            list.add(i);
        }
        list.sort((a, b) -> (int) (b.getValue() - a.getValue()));

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Long> entry : list) {
            for (int i = 0; i < entry.getValue(); i++) {
                sb.append(entry.getKey());
            }
        }

        return sb.toString();
    }
}

// @lc code=end
