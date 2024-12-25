package midtermfinalexam;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class finalexam4 extends JFrame {
    JTextField t1;
    finalexam4() {
        setTitle("설문조사");
        setLayout(new BorderLayout(10, 10));
        makeMenu();
        showNorth();
        showCenter();
        showSouth();

        getContentPane().setBackground(Color.WHITE);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setVisible(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                handleKeyPress(e);
            }
        });
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
                writer.write(t1.getText());
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
        JTextField nameField = new JTextField(10);
        p1.add(nameField);

        p1.add(new JLabel("성별: "));
        JTextField genderField = new JTextField(10);
        p1.add(genderField);

        p1.add(new JLabel("청주대에 다니면서 시설 관련된 불편했던 점 (사람 특정은 제외 부탁드립니다, 요약을 먼저 쓰신후 설명 부탁드립니다): "));
        JTextField issueSummaryField = new JTextField( 10);
        p1.add(issueSummaryField);

        p1.add(new JLabel("어떤 점이 불편했는지 상세히 설명 부탁드립니다,(요약을 먼저 쓰신후 설명 부탁드립니다): "));
        JTextField issueDetailField = new JTextField( 10);
        p1.add(issueDetailField);

        p1.add(new JLabel("불편했던 사항을 해결 방안에 대해 의견을 적어주십시오 예) 길가에 음성표지판을 두어 이곳에 블랙아이스가 있으니 사람이 오면 들을 수 있게 한다.(요약을 먼저 쓰신후 설명 부탁드립니다): "));
        JTextField solutionField = new JTextField( 10);
        p1.add(solutionField);

        this.add(p1, BorderLayout.NORTH);
    }

    void showCenter() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new FlowLayout());

        Dimension buttonSize = new Dimension(50, 30);

        JButton clearButton = new JButton("C");
        clearButton.setPreferredSize(buttonSize);
        clearButton.setBackground(Color.GRAY);
        clearButton.addActionListener(e -> t1.setText(""));
        panel.add(clearButton);

        this.add(panel, BorderLayout.CENTER);
    }

    void showSouth() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);

        JPanel buttonPanel = new JPanel(new GridLayout(5, 5, 10, 10));
        buttonPanel.setBackground(Color.WHITE);

        String[] buttonLabels = {
                "ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ",
                "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ",
                "ㅋ", "ㅌ", "ㅍ", "ㅎ"
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

    void handleKeyPress(KeyEvent e) {
        char keyChar = e.getKeyChar();
        switch (keyChar) {
            case 'ㄱ': case 'ㄴ': case 'ㄷ': case 'ㄹ':
            case 'ㅁ': case 'ㅂ': case 'ㅅ': case 'ㅇ':
            case 'ㅈ': case 'ㅊ': case 'ㅋ': case 'ㅌ':
            case 'ㅍ': case 'ㅎ':
                t1.setText(t1.getText() + keyChar);
                break;
            case KeyEvent.VK_BACK_SPACE:
                String text = t1.getText();
                if (!text.isEmpty()) {
                    t1.setText(text.substring(0, text.length() - 1));
                }
                break;
        }
    }

    class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            String text = source.getText();
            t1.setText(t1.getText() + text);
        }
    }

    public static void main(String[] args) {
        new finalexam4();
    }
}

