package finalexam;

import java.io.*;
import java.util.*;

public class finalexam6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        Map<String, String> responseMap = new LinkedHashMap<>();


        System.out.println("이름: ");
        String name = scanner.nextLine();
        responseMap.put("이름", name);

        System.out.println("성별: ");
        String gender = scanner.nextLine();
        responseMap.put("성별", gender);

        System.out.println("청주대에 다니면서 시설 관련된 불편했던 점 (사람 특정은 제외 부탁드립니다, 요약을 먼저 쓰신 후 설명 부탁드립니다): ");
        String inconvenience = scanner.nextLine();
        responseMap.put("불편한 점", inconvenience);

        System.out.println("어떤 점이 불편했는지 상세히 설명 부탁드립니다(요약을 먼저 쓰신 후 설명 부탁드립니다): ");
        String details = scanner.nextLine();
        responseMap.put("상세 설명", details);

        System.out.println("불편했던 사항을 해결 방안에 대해 의견을 적어주십시오 (요약을 먼저 쓰신 후 설명 부탁드립니다): ");
        String solution = scanner.nextLine();
        responseMap.put("해결 방안", solution);


        saveResponse(responseMap);


        summarizeResponses();
    }


    private static void saveResponse(Map<String, String> responseMap) {
        String userHome = System.getProperty("user.home");
        String filePath = userHome + "\\Desktop\\survey_responses.txt";

        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath, true), "UTF-8"))) {

            for (Map.Entry<String, String> entry : responseMap.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
            writer.newLine();
            System.out.println("응답이 성공적으로 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void summarizeResponses() {
        String inputFilePath = System.getProperty("user.home") + "\\Desktop\\survey_responses.txt";
        String outputFilePath = System.getProperty("user.home") + "\\Desktop\\survey_responses_summary.txt";

        List<String> responses = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(inputFilePath), "UTF-8"));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFilePath), "UTF-8"))) {

            String line;
            while ((line = reader.readLine()) != null) {
                responses.add(line);
            }


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
        if (words.length <= 10) {
            return response;
        }
        StringBuilder summary = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            summary.append(words[i]).append(" ");
        }
        summary.append("...");
        return summary.toString().trim();
    }
}



