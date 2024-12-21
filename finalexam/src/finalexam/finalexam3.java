package finalexam;

import java.io.*;
import java.util.*;

public class finalexam3 {
    public static void main(String[] args) {
        String input = "C:\\Users\\ASUS\\OneDrive - 청주대학교\\바탕 화면\\survey_responses.txt";
        String output = "C:\\Users\\ASUS\\OneDrive - 청주대학교\\바탕 화면\\survey_responses_summary.txt";

        List<String> responses = new ArrayList<>();

        try (FileInputStream fi = new FileInputStream(input);
             InputStreamReader in = new InputStreamReader(fi, "UTF-8");
             BufferedReader reader = new BufferedReader(in);
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                responses.add(line);
            }

            // Summarize responses
            for (String response : responses) {
                String summary = summarizeResponse(response);
                writer.write(summary);
                writer.newLine();
            }

            System.out.println("응답 요약이 성공적으로 저장되었습니다.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String summarizeResponse(String response) {

        String[] words = response.split(" ");
        if (words.length <= 30) {
            return response;
        }
        StringBuilder summary = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            summary.append(words[i]).append(" ");
        }
        summary.append("...");
        return summary.toString().trim();
    }
}