package finalexam;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class finalexam1 {
    public finalexam1() {
    }

    private static void saveResponse(String name, String gender, String inconvenience, String details, String solution) {
        String filePath = "survey_responses.txt";

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));

            try {
                writer.write("이름: " + name);
                writer.newLine();
                writer.write("성별: " + gender);
                writer.newLine();
                writer.write("불편했던 점: " + inconvenience);
                writer.newLine();
                writer.write("상세 설명: " + details);
                writer.newLine();
                writer.write("해결 방안: " + solution);
                writer.newLine();
                writer.write("---------------------------------");
                writer.newLine();
                System.out.println("응답이 성공적으로 저장되었습니다.");
            } catch (Throwable var10) {
                try {
                    writer.close();
                } catch (Throwable var9) {
                    var10.addSuppressed(var9);
                }

                throw var10;
            }

            writer.close();
        } catch (IOException var11) {
            IOException e = var11;
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("이름: ");
        String name = scanner.nextLine();
        System.out.println("성별: ");
        String gender = scanner.nextLine();
        System.out.println("청주대에 다니면서 시설 관련된 불편했던 점 (사람 특정은 제외 부탁드립니다): ");
        String inconvenience = scanner.nextLine();
        System.out.println("어떤 점이 불편했는지 상세히 설명 부탁드립니다: ");
        String details = scanner.nextLine();
        System.out.println("불편했던 사항을 해결 방안에 대해 의견을 적어주십시오 예) 길가에 음성표지판을 두어 이곳에 블랙아이스가 있으니 사람이 오면 들을 수 있게 한다.: ");
        String solution = scanner.nextLine();
        saveResponse(name, gender, inconvenience, details, solution);
    }
}
