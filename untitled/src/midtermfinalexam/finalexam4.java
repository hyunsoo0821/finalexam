package midtermfinalexam;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class finalexam4 extends JFrame {
    JTextField t1;

    finalexam4() {
        this.setTitle("설문조사");
        this.setLayout(new BorderLayout(10, 10));
        this.makeMenu();
        this.showNorth();
        this.showCenter();
        this.showSouth();
        this.getContentPane().setBackground(Color.WHITE);
        this.setDefaultCloseOperation(3);
        this.setSize(400, 500);
        this.setVisible(true);
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                finalexam4.this.handleKeyPress(e);
            }
        });
    }

    void makeMenu() {
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.WHITE);
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(70);
        fileMenu.setBackground(Color.WHITE);
        JMenuItem newFileItem = new JMenuItem("새파일", 78);
        newFileItem.addActionListener((e) -> {
            System.out.println("새파일");
        });
        newFileItem.setBackground(Color.WHITE);
        JMenuItem saveFileItem = new JMenuItem("파일 저장하기");
        saveFileItem.addActionListener((e) -> {
            this.saveToFile();
        });
        saveFileItem.setBackground(Color.WHITE);
        JMenuItem exitItem = new JMenuItem("종료");
        exitItem.addActionListener((e) -> {
            int confirmed = JOptionPane.showConfirmDialog(this, "정말 종료하시겠습니까?", "종료 확인", 0);
            if (confirmed == 0) {
                System.exit(0);
            }

        });
        exitItem.setBackground(Color.WHITE);
        fileMenu.add(newFileItem);
        fileMenu.add(saveFileItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);
        this.setJMenuBar(menuBar);
    }

    void saveToFile() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("파일 저장");
        int userSelection = fileChooser.showSaveDialog(this);
        if (userSelection == 0) {
            File fileToSave = fileChooser.getSelectedFile();

            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(fileToSave));

                try {
                    writer.write(this.t1.getText());
                    JOptionPane.showMessageDialog(this, "파일이 저장되었습니다: " + fileToSave.getAbsolutePath());
                } catch (Throwable var8) {
                    try {
                        writer.close();
                    } catch (Throwable var7) {
                        var8.addSuppressed(var7);
                    }

                    throw var8;
                }

                writer.close();
            } catch (IOException var9) {
                IOException ex = var9;
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
        JTextField issueSummaryField = new JTextField(10);
        p1.add(issueSummaryField);
        p1.add(new JLabel("어떤 점이 불편했는지 상세히 설명 부탁드립니다,(요약을 먼저 쓰신후 설명 부탁드립니다): "));
        JTextField issueDetailField = new JTextField(10);
        p1.add(issueDetailField);
        p1.add(new JLabel("불편했던 사항을 해결 방안에 대해 의견을 적어주십시오 예) 길가에 음성표지판을 두어 이곳에 블랙아이스가 있으니 사람이 오면 들을 수 있게 한다.(요약을 먼저 쓰신후 설명 부탁드립니다): "));
        JTextField solutionField = new JTextField(10);
        p1.add(solutionField);
        this.add(p1, "North");
    }

    void showCenter() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(new FlowLayout());
        Dimension buttonSize = new Dimension(50, 30);
        JButton clearButton = new JButton("C");
        clearButton.setPreferredSize(buttonSize);
        clearButton.setBackground(Color.GRAY);
        clearButton.addActionListener((e) -> {
            this.t1.setText("");
        });
        panel.add(clearButton);
        this.add(panel, "Center");
    }

    void showSouth() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        JPanel buttonPanel = new JPanel(new GridLayout(5, 5, 10, 10));
        buttonPanel.setBackground(Color.WHITE);
        String[] buttonLabels = new String[]{"ㄱ", "ㄴ", "ㄷ", "ㄹ", "ㅁ", "ㅂ", "ㅅ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"};
        String[] var4 = buttonLabels;
        int var5 = buttonLabels.length;

        for(int var6 = 0; var6 < var5; ++var6) {
            String label = var4[var6];
            JButton button = new JButton(label);
            button.setBackground(Color.GRAY);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }

        panel.add(buttonPanel);
        this.add(panel, "South");
    }

    void handleKeyPress(KeyEvent e) {
        char keyChar = e.getKeyChar();
        switch (keyChar) {
            case '\b':
                String text = this.t1.getText();
                if (!text.isEmpty()) {
                    this.t1.setText(text.substring(0, text.length() - 1));
                }
                break;
            case 'ㄱ':
            case 'ㄴ':
            case 'ㄷ':
            case 'ㄹ':
            case 'ㅁ':
            case 'ㅂ':
            case 'ㅅ':
            case 'ㅇ':
            case 'ㅈ':
            case 'ㅊ':
            case 'ㅋ':
            case 'ㅌ':
            case 'ㅍ':
            case 'ㅎ':
                JTextField var10000 = this.t1;
                String var10001 = this.t1.getText();
                var10000.setText(var10001 + keyChar);
        }

    }

    public static void main(String[] args) {
        new finalexam4();
    }

    class ButtonClickListener implements ActionListener {
        ButtonClickListener() {
        }

        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton)e.getSource();
            String text = source.getText();
            JTextField var10000 = finalexam4.this.t1;
            String var10001 = finalexam4.this.t1.getText();
            var10000.setText(var10001 + text);
        }
    }
}
