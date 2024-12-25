package finalexam;

import java.io.*;
import java.util.*;
/**
 * @see  Scanner 문
 * @see Map, HashMap 키와 값을 저장하는 자료구조
 *  *파일 입출력및 컬렉션 프레임워크 클래스입니다.
 *
 * @author cho hyun soo(hyunsoo821cho@gmail.com)
 *  @version 24.2.3
 *  @since 24.10.8
 *
 * @created 2024-12-20
 * @lastModified 2024-12-25
 *
 * @changelog
 * <ul>
 *   <li>2024-12-20: 최초 생성 (cho hyun soo)</li>
 *   <li>2024-12-22: 설문조사 내용 작성(cho hyun soo)</li>
 *   <li>2023-12-23: 파일 입출력 처리 기늩추가 및 설문조사 내용 요약 기능추가(cho hyun soo)</li>
 *   <li>2024-12-24: 자동로그인 기능추가 (cho hyun soo)</li>
 *    <li>2024-12-25: 컬렉션 프레임워크 및 파일입출력 최종 요약후 정리 작성 (cho hyun soo)</li>
 * </ul>
 */


public class finalexam7 {

    private static final String USER_CREDENTIALS_FILE = "user_credentials.properties";

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
        /**
         * @see  tryAutoLogin(scanner): 이 메서드는 자동 로그인 시도 클래스
         * @see credentials.properties 파일에서 저장된 아이디와 비밀번호를 읽는 클래스
         * @see saveCredentials(아이디, 비번) 메서드를 통해 입력된 로그인 정보는 credentials.properties 파일에 저장 클래스
         *  *자동 로그인, properties파일에 설문조사 응답내용 저장 클래스입니다.
         *
         * @author cho hyun soo(hyunsoo821cho@gmail.com)
         *  @version 24.2.3
         *  @since 24.10.8
         *
         * @created 2024-12-20
         * @lastModified 2024-12-25
         *
         * @changelog
         * <ul>
         *   <li>2024-12-20: 최초 생성 (cho hyun soo)</li>
         *   <li>2024-12-22: 설문조사 내용 작성(cho hyun soo)</li>
         *   <li>2023-12-23: 파일 입출력 처리 기늩추가 및 설문조사 내용 요약 기능추가(cho hyun soo)</li>
         *   <li>2024-12-24: 자동로그인 기능추가 (cho hyun soo)</li>
         *    <li>2024-12-25: 컬렉션 프레임워크 및 파일입출력 최종 요약후 정리 작성 (cho hyun soo)</li>
         * </ul>
         */


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
    /**
     * *@see (solution,details,inconvenience,gender,name)->map의 객체
     * * @see ResponseMap 에 저장된 설문 응답을 saveResponse() 메서드를 통해 저장
     *  * 이름, 성별, 불편했던 점, 상세 설명, 해결 방안 등을 입력하고, 그 응답은 LinkedHashMap에 순서대로 저장
     *
     * @author cho hyun soo(hyunsoo821cho@gmail.com)
     *  @version 24.2.3
     *  @since 24.10.8
     *
     * @created 2024-12-20
     * @lastModified 2024-12-25
     *
     * @changelog
     * <ul>
     *   <li>2024-12-20: 최초 생성 (cho hyun soo)</li>
     *   <li>2024-12-22: 설문조사 내용 작성(cho hyun soo)</li>
     *   <li>2023-12-23: 파일 입출력 처리 기늩추가 및 설문조사 내용 요약 기능추가(cho hyun soo)</li>
     *   <li>2024-12-24: 자동로그인 기능추가 (cho hyun soo)</li>
     *    <li>2024-12-25: 컬렉션 프레임워크 및 파일입출력 최종 요약후 정리 작성 (cho hyun soo)</li>
     * </ul>
     */
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
    /**
     * @see * properties 파일에 저장하는 클래스
     * @see * setProperty() 메서드를 사용하여 username과 password
     * @see *CREDENTIALS_FILE은 로그인 정보를 저장할 파일의 경로
     * @see *BufferedWriter는 출력 스트림을 버퍼링하여 성능을 향상시키는 역할
     * @see *FileWriter는 파일에 데이터를 쓰는 역할
     *
     * @author cho hyun soo(hyunsoo821cho@gmail.com)
     *  @version 24.2.3
     *  @since 24.10.8
     *
     * @created 2024-12-20
     * @lastModified 2024-12-25
     *
     * @changelog
     * <ul>
     *   <li>2024-12-20: 최초 생성 (cho hyun soo)</li>
     *   <li>2024-12-22: 설문조사 내용 작성(cho hyun soo)</li>
     *   <li>2023-12-23: 파일 입출력 처리 기늩추가 및 설문조사 내용 요약 기능추가(cho hyun soo)</li>
     *   <li>2024-12-24: 자동로그인 기능추가 (cho hyun soo)</li>
     *    <li>2024-12-25: 컬렉션 프레임워크 및 파일입출력 최종 요약후 정리 작성 (cho hyun soo)</li>
     * </ul>
     */


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
    /**
     * @see  *credentials.properties 파일에 저장된 아이디와 비밀번호 저장
     * @see  *일치하면 로그인 성공, 일치하지 않으면 로그인 실패로 처리
     *
     *
     * @author cho hyun soo(hyunsoo821cho@gmail.com)
     *  @version 24.2.3
     *  @since 24.10.8
     *
     * @created 2024-12-20
     * @lastModified 2024-12-25
     *
     * @changelog
     * <ul>
     *   <li>2024-12-20: 최초 생성 (cho hyun soo)</li>
     *   <li>2024-12-22: 설문조사 내용 작성(cho hyun soo)</li>
     *   <li>2023-12-23: 파일 입출력 처리 기늩추가 및 설문조사 내용 요약 기능추가(cho hyun soo)</li>
     *   <li>2024-12-24: 자동로그인 기능추가 (cho hyun soo)</li>
     *    <li>2024-12-25: 컬렉션 프레임워크 및 파일입출력 최종 요약후 정리 작성 (cho hyun soo)</li>
     * </ul>
     */


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
    /**
     * @see  *설문 응답을 Map에 저장한 후, 이를 텍스트 파일 내보내기 저장,"key: value"
     * @see * 파일 입출력 처리 코드
     *
     * @author cho hyun soo(hyunsoo821cho@gmail.com)
     *  @version 24.2.3
     *  @since 24.10.8
     *
     * @created 2024-12-20
     * @lastModified 2024-12-25
     *
     * @changelog
     * <ul>
     *   <li>2024-12-20: 최초 생성 (cho hyun soo)</li>
     *   <li>2024-12-22: 설문조사 내용 작성(cho hyun soo)</li>
     *   <li>2023-12-23: 파일 입출력 처리 기늩추가 및 설문조사 내용 요약 기능추가(cho hyun soo)</li>
     *   <li>2024-12-24: 자동로그인 기능추가 (cho hyun soo)</li>
     *    <li>2024-12-25: 컬렉션 프레임워크 및 파일입출력 최종 요약후 정리 작성 (cho hyun soo)</li>
     * </ul>
     */


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
    /**
     * 설문 응답 요약을 파일에 저장하는 메서드, 각 응답을 요약한 후 택스트파일 내보내기
     * @see  *BufferedReader는 입력 스트림을 버퍼링하여 성능을 향상, FileInputStream은 파일을 읽는 스트림
     * @see *InputStreamReader는 바이트 스트림을 문자 스트림으로 변환, "UTF-8" 인코딩을 사용
     * @sww *BufferedWriter는 출력 스트림을 버퍼링, FileOutputStream은 출력 파일에 데이터 작성
     * @author cho hyun soo(hyunsoo821cho@gmail.com)
     *  @version 24.2.3
     *  @since 24.10.8
     *
     * @created 2024-12-20
     * @lastModified 2024-12-25
     *
     * @changelog
     * <ul>
     *   <li>2024-12-20: 최초 생성 (cho hyun soo)</li>
     *   <li>2024-12-22: 설문조사 내용 작성(cho hyun soo)</li>
     *   <li>2023-12-23: 파일 입출력 처리 기늩추가 및 설문조사 내용 요약 기능추가(cho hyun soo)</li>
     *   <li>2024-12-24: 자동로그인 기능추가 (cho hyun soo)</li>
     *    <li>2024-12-25: 컬렉션 프레임워크 및 파일입출력 최종 요약후 정리 작성 (cho hyun soo)</li>
     * </ul>
     */


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
/**
 * response.split(" ")는 공백을 기준으로 응답을 단어별로 나누어 배열에 저장
 * summary.toString()은 StringBuilder에 추가된 모든 내용을 문자열로 변환
 * 주어진 긴 응답을 요약하여, 첫 10단어만 포함하고 그 뒤는 "..."으로 표시하는 방식으로 동작합니다
 *
 * @author cho hyun soo(hyunsoo821cho@gmail.com)
 *  @version 24.2.3
 *  @since 24.10.8
 *
 * @created 2024-12-20
 * @lastModified 2024-12-25
 *
 * @changelog
 * <ul>
 *   <li>2024-12-20: 최초 생성 (cho hyun soo)</li>
 *   <li>2024-12-22: 설문조사 내용 작성(cho hyun soo)</li>
 *   <li>2023-12-23: 파일 입출력 처리 기늩추가 및 설문조사 내용 요약 기능추가(cho hyun soo)</li>
 *   <li>2024-12-24: 자동로그인 기능추가 (cho hyun soo)</li>
 *    <li>2024-12-25: 컬렉션 프레임워크 및 파일입출력 최종 요약후 정리 작성 (cho hyun soo)</li>
 * </ul>
 */
