package finalexam;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Survey_responses {


        static class SurveyResponse {
                String name;
                String gender;
                String inconvenience;
                String details;
                String solution;


                public SurveyResponse(String name, String gender, String inconvenience, String details, String solution) {
                        this.name = name;
                        this.gender = gender;
                        this.inconvenience = inconvenience;
                        this.details = details;
                        this.solution = solution;
                }

                @Override
                public String toString() {
                        return "이름: " + name + "\n" +
                                "성별: " + gender + "\n" +
                                "불편했던 점: " + inconvenience + "\n" +
                                "상세 설명: " + details + "\n" +
                                "해결 방안: " + solution + "\n" +
                                "--------------------------";
                }
        }


        private static List<SurveyResponse> responses = new ArrayList<>();


        private static void saveResponse(String name, String gender, String inconvenience, String details, String solution) {
                SurveyResponse response = new SurveyResponse(name, gender, inconvenience, details, solution);
                responses.add(response);
                System.out.println("응답이 성공적으로 저장되었습니다.");
        }

        public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);


                System.out.println("이름: ");
                String name = scanner.nextLine();

                System.out.println("성별: ");
                String gender = scanner.nextLine();

                System.out.println("청주대에 다니면서 시설 관련된 불편했던 점 (사람 특정은 제외 부탁드립니다, 요약을 먼저 쓰신후 설명 부탁드립니다): ");
                String inconvenience = scanner.nextLine();

                System.out.println("어떤 점이 불편했는지 상세히 설명 부탁드립니다,(요약을 먼저 쓰신후 설명 부탁드립니다) ");
                String details = scanner.nextLine();

                System.out.println("불편했던 사항을 해결 방안에 대해 의견을 적어주십시오 예) 길가에 음성표지판을 두어 이곳에 블랙아이스가 있으니 사람이 오면 들을 수 있게 한다.(요약을 먼저 쓰신후 설명 부탁드립니다)");
                String solution = scanner.nextLine();


                saveResponse(name, gender, inconvenience, details, solution);


                System.out.println("\n저장된 응답:");
                for (SurveyResponse response : responses) {
                        System.out.println(response);
                }
        }
}
