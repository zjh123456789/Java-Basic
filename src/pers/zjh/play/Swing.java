package pers.zjh.play;


import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

/**
 * @author jinghui.zhu
 * @description swing弹窗写着玩玩
 * @createTime 2022/12/1 12:09 AM
 */
public class Swing extends JFrame {

    public static void main(String[] args) throws InterruptedException, IOException {
        Random random = new Random();
        Thread threadA = new Thread(() -> {
            for (int i=0; i<50; i++) {
                int x = random.nextInt(1300) + 100;
                int y = random.nextInt(600) + 100;
                int number = random.nextInt(6);
                new Swing(x, y, number);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadB = new Thread(() -> {
            for (int i=0; i<50; i++) {
                int x = random.nextInt(1500) + 100;
                int y = random.nextInt(700) + 100;
                int number = random.nextInt(6);
                new Swing(x, y, number);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread threadC = new Thread(() -> {
            for (int i=0; i<50; i++) {
                int x = random.nextInt(1700) + 100;
                int y = random.nextInt(900) + 100;
                int number = random.nextInt(6);
                new Swing(x, y, number);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
    }

    public Swing(int x, int y, int number) {
        setTitle("https://www.baidu.com");
        setBounds(x, y, 350, 150);
        getContentPane().setLayout(null);
        JPanel jPanel = new JPanel();
        jPanel.setBounds(0, 0, 350, 200);
        Color []colors = {Color.GREEN, Color.BLUE, Color.RED, Color.CYAN, Color.GRAY, Color.LIGHT_GRAY};
        jPanel.setBackground(colors[number]);
        getContentPane().add(jPanel);
        JLabel jLabel = new JLabel("美女壮～");
        jLabel.setFont(new Font("宋体", Font.BOLD, 30));
        jPanel.add(jLabel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}