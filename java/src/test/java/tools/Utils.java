package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Utils {

    private Utils() {
    }

    public static String readFromFile(String file) {
        InputStream inputStream = Utils.class.getClassLoader().getResourceAsStream(file);
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public static int[] readIntArrayFromFile(String file) {
        String input = Utils.readFromFile(file);
        String[] nums = input.split(",");
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = Integer.parseInt(nums[i].trim());
        }
        return res;
    }

}
