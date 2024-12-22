package finalexam;

import java.io.*;
import java.util.*;

public class finalexam7 {

    private static final String USER_CREDENTIALS_FILE = "user_credentials.properties";  // 아이디와 비밀번호를 저장할 파일

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        if (tryAutoLogin(scanner)) {
            System.out.println("자동 로그인에 성공했습니다.");
        } else {
            System.out.println("자동 로그인 실패. 새로 로그인 정보를 입력합니다.");

            System.out.print("아이디를 입력하세요: ");
            String username = scanner.nextLine();
            System.out.print("비밀번호를 입력하세요: ");
            String password = scanner.nextLine();

            saveCredentials(username, password);
        }


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


    private static void saveCredentials(String username, String password) {
        Properties properties = new Properties();
        properties.setProperty("username", username);
        properties.setProperty("password", password);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(USER_CREDENTIALS_FILE))) {
            properties.store(writer, null);
            System.out.println("로그인 정보가 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static boolean tryAutoLogin(Scanner scanner) {
        File credentialsFile = new File(USER_CREDENTIALS_FILE);
        if (!credentialsFile.exists()) {
            return false;
        }

        Properties properties = new Properties();
        try (BufferedReader reader = new BufferedReader(new FileReader(credentialsFile))) {
            properties.load(reader);
            String username = properties.getProperty("username");
            String password = properties.getProperty("password");


            System.out.print("아이디를 입력하세요: ");
            String inputUsername = scanner.nextLine();
            System.out.print("비밀번호를 입력하세요: ");
            String inputPassword = scanner.nextLine();

            if (username.equals(inputUsername) && password.equals(inputPassword)) {
                return true;
            } else {
                System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
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
