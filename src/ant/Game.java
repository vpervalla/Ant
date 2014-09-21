/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ant;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.Attribute;

/**
 *
 * @author ig-88
 */
public class Game {

    private final int m_dim;
    private int[][] m_grid;
    static final int EMPTY = 0;
    static final int FOOD = 1;
    static final int VISITED = -1;
    static final int OUTSIDE = -12;
    static final char W = 'W';
    static final char A = 'A';
    static final char S = 'S';
    static final char D = 'D';
    private Ant m_ant;
    private int m_score;
    private int m_moves;
    private final String m_fileName = "ant.arff";
    private final WekaWrapper1x1 m_wrapper1x1;
    private final WekaWrapper5x1 m_wrapper5x1;
    private final WekaWrapper10x1 m_wrapper10x1;
    private final WekaWrapper1x2 m_wrapper1x2;
    private final WekaWrapper5x2 m_wrapper5x2;
    private final WekaWrapper10x2 m_wrapper10x2;
    private final WekaWrapper50x2 m_wrapper50x2;
    private final Instances m_data;

    public Game(int dim, boolean first, int fov) throws FileNotFoundException, IOException {
        m_dim = dim;
        m_score = 0;
        m_moves = m_dim * 2;
        initGrid();
        initFood();
        initAnt(fov);
        if (first) {
            initFile();
        }
        BufferedReader reader = new BufferedReader(new FileReader(m_fileName));
        m_data = new Instances(reader);
        m_data.setClassIndex(m_data.numAttributes() - 1);
        m_wrapper1x1 = new WekaWrapper1x1();
        m_wrapper5x1 = new WekaWrapper5x1();
        m_wrapper10x1 = new WekaWrapper10x1();
        m_wrapper1x2 = new WekaWrapper1x2();
        m_wrapper5x2 = new WekaWrapper5x2();
        m_wrapper10x2 = new WekaWrapper10x2();
        m_wrapper50x2 = new WekaWrapper50x2();
    }

    public void move(char key) {
        key = Character.toUpperCase(key);

        saveStatus();

        if (key != W && key != A && key != S && key != D) {
            key = keyFromWeka(0);
        }

        switch (key) {
            case W:
                m_ant.moveUp();
                break;
            case S:
                m_ant.moveDown();
                break;
            case A:
                m_ant.moveLeft();
                break;
            case D:
                m_ant.moveRight();
                break;
            default:
                break;
        }

        saveMove(key);

        checkPos();
        m_moves--;
    }

    private void initGrid() {
        m_grid = new int[m_dim][m_dim];

        for (int i = 0; i < m_dim; ++i) {
            for (int j = 0; j < m_dim; ++j) {
                m_grid[i][j] = EMPTY;
            }
        }
    }

    private void initFood() {
        int nFood = 0;
        Random rng = new Random();

        while (nFood < m_dim) {
            int row = rng.nextInt(m_dim);
            int col = rng.nextInt(m_dim);

            if (m_grid[row][col] == EMPTY) {
                nFood++;
                m_grid[row][col] = FOOD;
            }
        }
    }

    private void initAnt(int fov) {
        m_ant = new Ant(fov);
        boolean initDone = false;

        while (!initDone) {
            Random rng = new Random();
            int row = rng.nextInt(m_dim);
            int col = rng.nextInt(m_dim);

            if (m_grid[row][col] == EMPTY) {
                m_ant.setPos(m_ant.new Point(row, col));
                initDone = true;
            }
        }
    }

    private void checkPos() {

        if (outOfGrid(m_ant.getX(), m_ant.getY())) {
            m_score += OUTSIDE;
        } else {
            m_score += getValue(m_ant.getX(), m_ant.getY());
            // aggiorna griglia
            if (getValue(m_ant.getX(), m_ant.getY()) != FOOD) {
                m_grid[m_ant.getX()][m_ant.getY()] += VISITED;
            } else {
                m_grid[m_ant.getX()][m_ant.getY()] = VISITED;
            }
        }

    }

    public void printGrid() {
        for (int i = 0; i < m_dim; ++i) {
            for (int j = 0; j < m_dim; ++j) {
                if (!isVisible(i, j)) {
                    System.out.print("* ");
                } else if (m_ant.getX() == i && m_ant.getY() == j) {
                    System.out.print("F ");
                } else {
                    System.out.print(getValue(i, j) + " ");
                }
            }

            System.out.println("\n");
        }
    }

    public boolean isOver() {
        return (outOfGrid(m_ant.getX(), m_ant.getY()) || foodAvailable() <= 0 || movesAvailable() <= 0);
    }

    public int getScore() {
        return m_score;
    }

    public int getDim() {
        return m_dim;
    }

    private void initFile() {
        BufferedWriter writer = null;
        try {
            File file = new File(m_fileName);
            writer = new BufferedWriter(new FileWriter(file));
            writer.write("@RELATION ant\n\n");
            for (int i = 0; i < Math.pow(2 * m_ant.getFov() + 1, 2) - 1; ++i) {
                writer.write("@ATTRIBUTE " + i + "\tREAL\n");
            }
            writer.write("@ATTRIBUTE class\t{W,A,S,D}\n\n");
            writer.write("@DATA\n");
        } catch (Exception e) {
        } finally {
            try {
                writer.close();
            } catch (Exception e) {
            }
        }
    }

    private void saveStatus() {
        BufferedWriter writer = null;
        try {
            File file = new File(m_fileName);
            writer = new BufferedWriter(new FileWriter(file, true));
            String status = getStatus();
            writer.write(status);
        } catch (java.io.IOException e) {
            System.out.println("Cannot open file " + m_fileName);
        } finally {
            try {
                writer.close();
            } catch (java.io.IOException e) {
                System.out.println("Cannot close file " + m_fileName);
            }
        }
    }

    private void saveMove(char move) {
        BufferedWriter writer = null;
        try {
            File file = new File(m_fileName);
            writer = new BufferedWriter(new FileWriter(file, true));
            writer.write(move + "\n");
        } catch (java.io.IOException e) {
            System.out.println("Cannot open file " + m_fileName);
        } finally {
            try {
                writer.close();
            } catch (java.io.IOException e) {
                System.out.println("Cannot close file " + m_fileName);
            }
        }
    }

    private String getStatus() {
        String out = "";
        int status;

        int startRow = m_ant.getX() - m_ant.getFov();
        int endRow = m_ant.getX() + m_ant.getFov();

        int startCol = m_ant.getY() - m_ant.getFov();
        int endCol = m_ant.getY() + m_ant.getFov();

        for (int i = startRow; i <= endRow; ++i) {
            for (int j = startCol; j <= endCol; ++j) {

                if (!isAnt(i, j)) {
                    if (!outOfGrid(i, j)) {
                        status = getValue(i, j);
                    } else {
                        status = OUTSIDE;
                    }
                    out += (status + ",");
                }
            }
        }

        return out;
    }

    private boolean outOfGrid(int row, int col) {
        
        return !(row >= 0 && row < m_dim && col >= 0 && col < m_dim);
    }

    public boolean isVisible(int row, int col) {
        
        int minX = m_ant.getX() - m_ant.getFov();
        int minY = m_ant.getY() - m_ant.getFov();
        
        int maxX = m_ant.getX() + m_ant.getFov();
        int maxY = m_ant.getY() + m_ant.getFov();
        
        return (row >= minX && row <= maxX && col >= minY && col <= maxY);
    }

    public int getValue(int row, int col) {
        if (outOfGrid(row, col)) {
            return -(m_dim + 2);
        }
        return m_grid[row][col];
    }

    public int see(int idx) {

        int row = m_ant.see(idx).getX();
        int col = m_ant.see(idx).getY();

        if (outOfGrid(row, col)) {
            return -(m_dim + 2);
        }

        return m_grid[row][col];
    }

    public boolean isAnt(int row, int col) {
        return (m_ant.getX() == row && m_ant.getY() == col);
    }

    public int foodAvailable() {
        int out = 0;

        for (int i = 0; i < m_dim; ++i) {
            for (int j = 0; j < m_dim; ++j) {
                if (getValue(i, j) == FOOD) {
                    out++;
                }
            }
        }

        return out;
    }

    public int movesAvailable() {
        return m_moves;
    }

    // TODO: classifier might be set to specify which classifier has to be used
    private char keyFromWeka(int classifier) {
        
        char key = W;
        
        Instance i = new Instance(m_ant.getNumAttributes() + 1);
        i.setDataset(m_data);
        for (int j = 0; j < i.numAttributes() - 1; ++j) {
            i.setValue(new Attribute(Integer.toString(j), j), see(j));
        }

        i.setClassValue(1);
        double p = -1;
        try {
            p = m_wrapper10x1.classifyInstance(i);
        } catch (Exception ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch ((int)p){
            case 0:
                key = W;
                break;
            case 1:
                key = A;
                break;
            case 2:
                key = S;
                break;
            case 3:
                key = D;
                break;
            default:
                System.err.println("Unexpected classifier output!");
                break;
        }
        
        return key;
    }
}
