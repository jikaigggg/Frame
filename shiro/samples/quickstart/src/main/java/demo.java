import java.util.Arrays;
import java.util.List;

public class demo {
    public static void main(String[] args) {
        List<Integer> l = Arrays.asList(406,384,377,86,1171,15,14,114,787,3,12,16,234,88,546,1390);
        Integer sum = 0;
        for (int i = 0; i < l.size(); i++) {
            sum+=l.get(i);

        }
        System.out.println(sum*0.5/24);
    }
}
