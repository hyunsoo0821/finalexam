package finalexam;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class finalexam2 {
    public finalexam2() {
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder responseBuilder = new StringBuilder();
        System.out.println("이름: ");
        String name = scanner.nextLine();
        responseBuilder.append("이름: ").append(name).append("\n");
        System.out.println("성별: ");
        String gender = scanner.nextLine();
        responseBuilder.append("성별: ").append(gender).append("\n");
        System.out.println("청주대에 다니면서 시설 관련된 불편했던 점 (사람 특정은 제외 부탁드립니다,요약을 먼저 쓰신후 설명 부탁드립니다): ");
        String inconvenience = scanner.nextLine();
        responseBuilder.append("청주대에 다니면서 시설 관련된 불편했던 점 (사람 특정은 제외 부탁드립니다,요약을 먼저 쓰신후 설명 부탁드립니다): ").append(inconvenience).append("\n");
        System.out.println("어떤 점이 불편했는지 상세히 설명 부탁드립니다(요약을 먼저 쓰신후 설명 부탁드립니다) ");
        String details = scanner.nextLine();
        responseBuilder.append("어떤 점이 불편했는지 상세히 설명 부탁드립니다(요약을 먼저 쓰신후 설명 부탁드립니다)").append(details).append("\n");
        System.out.println("불편했던 사항을 해결 방안에 대해 의견을 적어주십시오 (요약을 먼저 쓰신후 설명 부탁드립니다) ");
        String solution = scanner.nextLine();
        responseBuilder.append("불편했던 사항을 해결 방안에 대해 의견을 적어주십시오 (요약을 먼저 쓰신후 설명 부탁드립니다)  ").append(solution).append("\n");
        saveResponse(responseBuilder.toString());
    }

    private static void saveResponse(String response) {
        String userHome = System.getProperty("user.home");
        String filePath = userHome + "\\Desktop\\survey_responses.txt";
        System.out.println("파일이 저장될 경로: " + filePath);

        try {
            OutputStream outputStream = new FileOutputStream(filePath, true);

            try {
                OutputStreamWriter writer = new OutputStreamWriter(outputStream, "UTF-8");

                try {
                    BufferedWriter bufferedWriter = new BufferedWriter(writer);

                    try {
                        bufferedWriter.write(response);
                        bufferedWriter.newLine();
                        System.out.println("응답이 성공적으로 저장되었습니다.");
                    } catch (Throwable var11) {
                        try {
                            bufferedWriter.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }

                        throw var11;
                    }

                    bufferedWriter.close();
                } catch (Throwable var12) {
                    try {
                        writer.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }

                    throw var12;
                }

                writer.close();
            } catch (Throwable var13) {
                try {
                    ((OutputStream)outputStream).close();
                } catch (Throwable var8) {
                    var13.addSuppressed(var8);
                }

                throw var13;
            }

            ((OutputStream)outputStream).close();
        } catch (IOException var14) {
            IOException e = var14;
            e.printStackTrace();
        }

    }
}
