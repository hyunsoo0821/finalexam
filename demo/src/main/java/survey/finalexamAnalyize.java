package survey;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class finalexamAnalyize extends Application {

    @Override
    public void start(Stage primaryStage) {
        // PieChart 생성
        PieChart pieChart = new PieChart();
        pieChart.getData().add(new PieChart.Data("주차공간 부족 (2명)", 2));
        pieChart.getData().add(new PieChart.Data("교내셔틀 시간 문제 (1명)", 1));
        pieChart.getData().add(new PieChart.Data("도보 블랙아이스 문제 (2명)", 2));
        pieChart.getData().add(new PieChart.Data("수도에서 따뜻한 물 안 나옴 (2명)", 2));

        // VBox 레이아웃 설정
        VBox vbox = new VBox(pieChart);

        // Scene 생성 및 Stage에 추가
        Scene scene = new Scene(vbox, 600, 400);  // Scene을 선언하고 초기화합니다.
        primaryStage.setScene(scene);
        primaryStage.setTitle("청주대 불편사항 설문조사 결과");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
