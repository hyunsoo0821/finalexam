package finalexam;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class finalexam3 {
    public finalexam3() {
    }

    public static void main(String[] args) {
        String input = "C:\\Users\\ASUS\\OneDrive - 청주대학교\\바탕 화면\\survey_responses.txt";
        String output = "C:\\Users\\ASUS\\OneDrive - 청주대학교\\바탕 화면\\survey_responses_summary.txt";
        List<String> responses = new ArrayList();

        try {
            FileInputStream fi = new FileInputStream(input);

            try {
                InputStreamReader in = new InputStreamReader(fi, "UTF-8");

                try {
                    BufferedReader reader = new BufferedReader(in);

                    try {
                        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(output), "UTF-8"));

                        try {
                            String line;
                            while((line = reader.readLine()) != null) {
                                responses.add(line);
                            }

                            Iterator var9 = responses.iterator();

                            while(var9.hasNext()) {
                                String response = (String)var9.next();
                                String summary = summarizeResponse(response);
                                writer.write(summary);
                                writer.newLine();
                            }

                            System.out.println("응답 요약이 성공적으로 저장되었습니다.");
                        } catch (Throwable var16) {
                            try {
                                writer.close();
                            } catch (Throwable var15) {
                                var16.addSuppressed(var15);
                            }

                            throw var16;
                        }

                        writer.close();
                    } catch (Throwable var17) {
                        try {
                            reader.close();
                        } catch (Throwable var14) {
                            var17.addSuppressed(var14);
                        }

                        throw var17;
                    }

                    reader.close();
                } catch (Throwable var18) {
                    try {
                        in.close();
                    } catch (Throwable var13) {
                        var18.addSuppressed(var13);
                    }

                    throw var18;
                }

                in.close();
            } catch (Throwable var19) {
                try {
                    fi.close();
                } catch (Throwable var12) {
                    var19.addSuppressed(var12);
                }

                throw var19;
            }

            fi.close();
        } catch (IOException var20) {
            IOException e = var20;
            e.printStackTrace();
        }

    }

    private static String summarizeResponse(String response) {
        String[] words = response.split(" ");
        if (words.length <= 30) {
            return response;
        } else {
            StringBuilder summary = new StringBuilder();

            for(int i = 0; i < 30; ++i) {
                summary.append(words[i]).append(" ");
            }

            summary.append("...");
            return summary.toString().trim();
        }
    }
}
