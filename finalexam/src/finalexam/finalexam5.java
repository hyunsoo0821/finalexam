package finalexam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    class FocusListener implements java.awt.event.FocusListener {
        @Override
        public void focusGained(FocusEvent e) {
            focusedField = (JTextArea) e.getSource();
        }

        @Override
        public void focusLost(FocusEvent e) {

        }
    }

    public static void main(String[] args) {
        new finalexam5();
    }
}



