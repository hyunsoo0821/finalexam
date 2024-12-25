package midtermfinalexam;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
/**
 * @see  * menu BAr 기능
 * @see * 파일 입출력 클래스
 *  *버튼클릭리스너 기능추가
 *  Action Evant 클래스
 *  BufferedWriter를 사용하여 데이터를 파일에 저장
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
 *   <li>2024-12-22: 2번,3번 버튼 추가(cho hyun soo)</li>
 *   <li>2023-12-23: TextArea 기능 추가(cho hyun soo)</li>
 *   <li>2024-12-24: Focusfield 기능추가 (cho hyun soo)</li>
 * </ul>
 */
public class finalexam5 extends JFrame {
    JTextArea genderField, issueSummaryField, issueDetailField, solutionField;
    JTextArea focusedField, nameField;;
    finalexam5() {
        setTitle("설문조사");
        setLayout(new BorderLayout(10, 10));
        makeMenu();
        showNorth();
        showSouth();
        getContentPane().setBackground(Color.WHITE);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setVisible(true);
    }
    /**
     * setLayout(new BorderLayout(10, 10)); 10은 간격 레이아웃을 의미합니다.
     * makeMenu(): 메뉴 바를 만드는 클래스
     * showNorth(): 설문조사를 위한 텍스트 필드들을 상단에 배치하는 클래스
     * showSouth(): 버튼들을 하단에 배치하는 클래스
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
     *   <li>2024-12-22: 2번,3번 버튼 추가(cho hyun soo)</li>
     *   <li>2023-12-23: TextArea 기능 추가(cho hyun soo)</li>
     *   <li>2024-12-24: Focusfield 기능추가 (cho hyun soo)</li>
     * </ul>
     */
    void makeMenu() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        fileMenu.setBackground(Color.WHITE);
        JMenuItem newFileItem = new JMenuItem("새파일", KeyEvent.VK_N);
        newFileItem.addActionListener(e -> System.out.println("새파일"));
        newFileItem.setBackground(Color.WHITE);
        JMenuItem saveFileItem = new JMenuItem("파일 저장하기");
        saveFileItem.addActionListener(e -> saveToFile());
        saveFileItem.setBackground(Color.WHITE);
        JMenuItem exitItem = new JMenuItem("종료");
        exitItem.addActionListener(e -> {
            int confirmed = JOptionPane.showConfirmDialog(
                    this,
                    "정말 종료하시겠습니까?",
                    "종료 확인",
                    JOptionPane.YES_NO_OPTION
            );
            if (confirmed == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
        exitItem.setBackground(Color.WHITE);
        fileMenu.add(newFileItem);
        fileMenu.add(saveFileItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);
    }
    /**
     * MenBar 클래스
     * MenuBar 파일 저장->Action Listener사용
     * MenuBar 새파일 생성기
     * MenuBar exit 종료
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
     *   <li>2024-12-22: 2번,3번 버튼 추가(cho hyun soo)</li>
     *   <li>2023-12-23: TextArea 기능 추가(cho hyun soo)</li>
     *   <li>2024-12-24: Focusfield 기능추가 (cho hyun soo)</li>
     * </ul>
     */
    void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("파일 저장");
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave))) {
                writer.write("이름: " + nameField.getText() + "\n");
                writer.write("성별: " + genderField.getText() + "\n");
                writer.write("불편 사항(요약): " + issueSummaryField.getText() + "\n");
                writer.write("불편 사항(상세): " + issueDetailField.getText() + "\n");
                writer.write("해결 방안: " + solutionField.getText() + "\n");
                JOptionPane.showMessageDialog(this, "파일이 저장되었습니다: " + fileToSave.getAbsolutePath());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "파일 저장 중 오류가 발생했습니다: " + ex.getMessage());
            }
        }
    }
    /**
     * saveToFile() 메서드는 사용자가 입력한 데이터를 파일에 저장하는 기능
     * JFileChooser를 사용해 파일 경로를 선택
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
     *   <li>2024-12-22: 2번,3번 버튼 추가(cho hyun soo)</li>
     *   <li>2023-12-23: TextArea 기능 추가(cho hyun soo)</li>
     *   <li>2024-12-24: Focusfield 기능추가 (cho hyun soo)</li>
     * </ul>
     */
    void showNorth() {
        JPanel p1 = new JPanel();
        p1.setBackground(Color.WHITE);
        p1.setLayout(new GridLayout(5, 1, 10, 10));
        p1.add(new JLabel("이름: "));
        nameField = new JTextArea(2,10);
        p1.add(nameField);
        p1.add(new JLabel("성별: "));
        genderField = new JTextArea(2, 10);
        genderField.setWrapStyleWord(true);
        genderField.setLineWrap(true);
        genderField.addFocusListener(new FocusListener());
        JScrollPane genderScroll = new JScrollPane(genderField);
        p1.add(genderScroll);
        p1.add(new JLabel("청주대에 다니면서 시설 관련된 불편했던 점 (사람 특정은 제외 부탁드립니다, 요약을 먼저 쓰신후 설명 부탁드립니다): "));
        issueSummaryField = new JTextArea(2, 10);
        issueSummaryField.setWrapStyleWord(true);
        issueSummaryField.setLineWrap(true);
        issueSummaryField.addFocusListener(new FocusListener());
        JScrollPane issueSummaryScroll = new JScrollPane(issueSummaryField);
        p1.add(issueSummaryScroll);
        p1.add(new JLabel("어떤 점이 불편했는지 상세히 설명 부탁드립니다,(요약을 먼저 쓰신후 설명 부탁드립니다): "));
        issueDetailField = new JTextArea(2, 10);
        issueDetailField.setWrapStyleWord(true);
        issueDetailField.setLineWrap(true);
        issueDetailField.addFocusListener(new FocusListener());
        JScrollPane issueDetailScroll = new JScrollPane(issueDetailField);
        p1.add(issueDetailScroll);
        p1.add(new JLabel("불편했던 사항을 해결 방안에 대해 의견을 적어주십시오 예) 길가에 음성표지판을 두어 이곳에 블랙아이스가 있으니 사람이 오면 들을 수 있게 한다.(요약을 먼저 쓰신후 설명 부탁드립니다): "));
        solutionField = new JTextArea(2, 10);
        solutionField.setWrapStyleWord(true);
        solutionField.setLineWrap(true);
        solutionField.addFocusListener(new FocusListener());
        JScrollPane solutionScroll = new JScrollPane(solutionField);
        p1.add(solutionScroll);
        this.add(p1, BorderLayout.NORTH);
    }
    /**
     * JtextArea:버튼, 키보드 입력 추가
     * solutionField: 해결 방안을 입력하는 JTextArea입니다
     * issueDetailField: 불편 사항의 상세 설명을 입력하는 JTextArea
     * issueSummaryField: 불편 사항을 요약하여 입력하는 JTextArea입니다
     * genderField: 사용자가 성별을 입력할 수 있는 JTextArea입니다.
     * nameField: 사용자가 이름을 입력할 수 있는 JTextArea입니다
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
     *   <li>2024-12-22: 2번,3번 버튼 추가(cho hyun soo)</li>
     *   <li>2023-12-23: TextArea 기능 추가(cho hyun soo)</li>
     *   <li>2024-12-24: Focusfield 기능추가 (cho hyun soo)</li>
     * </ul>
     */
    void showSouth() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 10, 10));
        buttonPanel.setBackground(Color.WHITE);
        String[] buttonLabels = {
                "남자", "여자",
                "주차장 자리 문제", "길가 문제", "뜨거운물 사용", "교내 셔틀 전광판 문제"
        };
        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.setBackground(Color.GRAY);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }
        panel.add(buttonPanel);
        this.add(panel, BorderLayout.SOUTH);
    }
    /**
     * GridLayout을 사용하여 5개의 행과 4개의 열로 구성된 격자 형식의 레이아웃
     * JButton -> Buttonclick Listener 6개 버튼 추가
     * 버튼들 배경 회색
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
     *   <li>2024-12-22: 2번,3번 버튼 추가(cho hyun soo)</li>
     *   <li>2023-12-23: TextArea 기능 추가(cho hyun soo)</li>
     *   <li>2024-12-24: Focusfield 기능추가 (cho hyun soo)</li>
     * </ul>
     */
    class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String text = source.getText();
            if (focusedField != null) {
                focusedField.append(text);
            }
        }
    }
    /**
     * 버튼이 클릭되면 actionPerformed() 메서드가 호출되고, 클릭된 버튼의 텍스트가 현재 포커스된 텍스트 필드에 추가
     * JfocusedField가 null인 경우에는 아무 동작도 수행되지 않으므로, 텍스트가 추가되지 않습니다.
     * Button clickListener 클래스
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
     *   <li>2024-12-22: 2번,3번 버튼 추가(cho hyun soo)</li>
     *   <li>2023-12-23: TextArea 기능 추가(cho hyun soo)</li>
     *   <li>2024-12-24: Focusfield 기능추가 (cho hyun soo)</li>
     * </ul>
     */
    class FocusListener implements java.awt.event.FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            focusedField = (JTextArea) e.getSource();
        }
        @Override
        public void focusLost(FocusEvent e) {
        }
    }
    /**
     * FocusListener 클래스는 포커스가 변화하는 이벤트를 처리->현재 포커스된 텍스트 필드를 추적하는 역할
     * focusGained: 컴포넌트가 포커스를 받으면  focusedField 변수에 저장
     * focusLost: 포커스를 잃으면 삭제
     * focus=사용자가 입력하거나 행동하는거
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
     *   <li>2024-12-22: 2번,3번 버튼 추가(cho hyun soo)</li>
     *   <li>2023-12-23: TextArea 기능 추가(cho hyun soo)</li>
     *   <li>2024-12-24: Focusfield 기능추가 (cho hyun soo)</li>
     * </ul>
     */
    public static void main(String[] args) {
        new finalexam5();
    }
}