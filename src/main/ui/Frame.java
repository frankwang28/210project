package ui;

import model.Game;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame {

    private static final int INTERVAL = 17;

    // Set up timer
    // MODIFIES: none
    // EFFECTS: initializes a timer that updates game each
    // INTERVAL milliseconds
    public void addTimer(Game g, Panel p) {
        Timer t = new Timer(INTERVAL, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (g.activeGame) {
                    g.update();
                    p.repaint();
                }
            }
        });
        t.start();
    }

    /*
     * A key handler to respond to key events
     */
    public static class KeyHandler extends KeyAdapter {

        @Override
        public void keyPressed(KeyEvent e) {
            Main.gameUi.keyPressed(e.getKeyCode());

        }
    }



}
