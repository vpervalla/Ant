/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ant;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author spazzino java
 */
public class AntGame implements KeyListener, ActionListener {

    private final static int N = 10;
    private final JFrame m_gameFrame = new JFrame();
    private final JLabel m_scoreLabel;
    private final JLabel m_foodLabel;
    private final JLabel m_movesLabel;
    private final JLabel m_numGameLabel;
    private final JButton[][] m_gameGrid;
    private final JButton m_newGameButton;
    private static Game m_game;
    private int m_numGame;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        m_game = new Game(N, true, 1);
        new AntGame(m_game, 0);
    }

    public AntGame(Game game, int numGame) {
        
        m_numGame = numGame;
        
        int rows = game.getDim();
        int cols = game.getDim();

        GridBagLayout gameLayout = new GridBagLayout();

        m_gameFrame.setLayout(gameLayout);
        GridBagConstraints lim = new GridBagConstraints();

        m_gameGrid = new JButton[rows][cols];

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                m_gameGrid[i][j] = new JButton(iconFromGame(i, j));
                m_gameGrid[i][j].setPreferredSize(new Dimension(60, 60));
                lim.gridx = j;
                lim.gridy = i;
                gameLayout.setConstraints(m_gameGrid[i][j], lim);
                m_gameFrame.add(m_gameGrid[i][j]);
            }
        }

        int pos = 0;
        
        m_scoreLabel = new JLabel("Punteggio: " + m_game.getScore());
        lim.gridx = game.getDim();
        lim.gridy = pos++;
        gameLayout.setConstraints(m_scoreLabel, lim);
        m_gameFrame.add(m_scoreLabel);

        m_foodLabel = new JLabel("Cibo disponibile: " + m_game.foodAvailable());
        lim.gridx = game.getDim();
        lim.gridy = pos++;
        gameLayout.setConstraints(m_foodLabel, lim);
        m_gameFrame.add(m_foodLabel);

        m_movesLabel = new JLabel("Mosse rimanenti: " + m_game.movesAvailable());
        lim.gridx = game.getDim();
        lim.gridy = pos++;
        gameLayout.setConstraints(m_movesLabel, lim);
        m_gameFrame.add(m_movesLabel);
        
        m_numGameLabel = new JLabel("Partite giocate: " + m_numGame);
        lim.gridx = game.getDim();
        lim.gridy = pos++;
        gameLayout.setConstraints(m_numGameLabel, lim);
        m_gameFrame.add(m_numGameLabel);

        m_newGameButton = new JButton("Nuovo gioco");
        lim.gridx = game.getDim();
        lim.gridy = pos++;
        m_newGameButton.addActionListener(this);
        gameLayout.setConstraints(m_newGameButton, lim);
        m_gameFrame.add(m_newGameButton);

        m_gameFrame.addKeyListener(this);
        m_gameFrame.setFocusable(true);

        m_gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        m_gameFrame.pack();
        m_gameFrame.setVisible(true);
        
        
    }

    public void showGame() {
        int rows = m_game.getDim();
        int cols = m_game.getDim();

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < cols; ++j) {
                m_gameGrid[i][j].setIcon(iconFromGame(i, j));
            }
        }
    }

    public void showInfo() {
        m_scoreLabel.setText("Punteggio: " + m_game.getScore());
        m_foodLabel.setText("Cibo disponibile: " + m_game.foodAvailable());
        m_movesLabel.setText("Mosse rimanenti: " + m_game.movesAvailable());
    }

    private Icon iconFromGame(int row, int col) {

        if (m_game.isAnt(row, col)) {
            return new ImageIcon("ant.png");
        }

        if (!m_game.isVisible(row, col) && !m_game.isOver()) {
            return new ImageIcon("fog.png");
        } else {
            switch (m_game.getValue(row, col)) {
                case Game.EMPTY:
                    return new ImageIcon("grass.png");
                case Game.VISITED:
                    return new ImageIcon("ground.png");
                case Game.FOOD:
                    return new ImageIcon("food.png");
            }
        }
        return new ImageIcon("ground.png");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("keyTyped=" + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //System.out.println("keyPressed=" + KeyEvent.getKeyText(e.getKeyCode()));
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try {
            //System.out.println(e.getKeyChar());

            m_game.move(e.getKeyChar());
        } catch (Exception ex) {
            Logger.getLogger(AntGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        showGame();
        showInfo();

        if (m_game.isOver()) {
            m_gameFrame.setFocusable(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        m_gameFrame.setVisible(false);
        m_gameFrame.dispose();
        try {
            m_game = new Game(N, false, 1);
        } catch (IOException ex) {
            Logger.getLogger(AntGame.class.getName()).log(Level.SEVERE, null, ex);
        }
        new AntGame(m_game,++m_numGame);
    }
}
