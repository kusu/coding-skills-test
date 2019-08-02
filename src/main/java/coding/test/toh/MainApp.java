package coding.test.toh;

import javax.swing.*;

public class MainApp extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {

        MainApp app = new MainApp();

        TohMain2 toh = new TohMain2(5);
        toh.drawTowers();
        toh.drawDisks();

        app.getContentPane().add(toh);

        app.setTitle("Towers of Hanoi");
        app.setBounds(250, 50, 800, 600);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setResizable(false);
        app.setVisible(true);


        toh.solvePuzzle();
    }
}
