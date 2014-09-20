/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ant;

import com.sun.corba.se.impl.orbutil.DenseIntMapImpl;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import static java.lang.System.in;
import java.util.Random;
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
    private Instances m_data;

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

    public void move(char key) throws Exception {
        key = Character.toUpperCase(key);

        saveStatus();

        if (key != W && key != A && key != S && key != D) {
            Instance i = new Instance(m_ant.getNumAttributes() + 1);
            i.setDataset(m_data);
            for (int j = 0; j < i.numAttributes() - 1; ++j) {
                i.setValue(new Attribute(Integer.toString(j), j), see(j));
            }

            i.setClassValue(1);
            double p = m_wrapper10x1.classifyInstance(i);

            if (p == 0.0) {
                key = W;
            } else if (p == 1.0) {
                key = A;
            } else if (p == 2.0) {
                key = S;
            } else if (p == 3.0) {
                key = D;
            } else {
                System.err.println("Unexpected classifier output!");
                return;
            }
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
            e.printStackTrace();
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
        if (row < 0 || row >= m_dim) {
            return true;
        }

        if (col < 0 || col >= m_dim) {
            return true;
        }

        return false;
    }

    public boolean isVisible(int row, int col) {
        if (row < m_ant.getX() - m_ant.getFov() || row > m_ant.getX() + m_ant.getFov()) {
            return false;
        }

        if (col < m_ant.getY() - m_ant.getFov() || col > m_ant.getY() + m_ant.getFov()) {
            return false;
        }

        return true;
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

    private char moveAI1x1() {

        char key;

        if (see(7) <= VISITED) {
            key = W;
        } else {
            if (see(6) <= EMPTY) {
                key = D;
            } else {
                key = S;
            }
        }

        return key;
    }

    private char moveAI5x1() {

        char key;

        if (see(1) <= EMPTY) {
            if (see(4) <= VISITED) {
                if (see(6) <= EMPTY) {
                    if (see(0) <= EMPTY) {
                        if (see(3) <= VISITED) {
                            key = W;
                        } else {
                            key = A;
                        }
                    } else {
                        key = W;
                    }
                } else {
                    key = S;
                }
            } else {
                if (see(3) <= EMPTY) {
                    if (see(4) <= EMPTY) {
                        if (see(0) <= VISITED) {
                            key = S;
                        } else {
                            if (see(3) <= VISITED) {
                                key = W;
                            } else {
                                if (see(2) <= EMPTY) {
                                    if (see(6) <= VISITED) {
                                        key = W;
                                    } else {
                                        key = S;
                                    }
                                } else {
                                    key = D;
                                }
                            }
                        }
                    } else {
                        key = D;
                    }
                } else {
                    key = A;
                }
            }
        } else {
            key = W;
        }

        return key;
    }

    private char moveAI10x1() {

        char key;

        if (see(4) <= EMPTY) {
            if (see(6) <= VISITED) {
                if (see(1) <= VISITED) {
                    if (see(3) <= VISITED) {
                        key = D;
                    } else {
                        key = A;
                    }
                } else {
                    if (see(3) <= EMPTY) {
                        key = W;
                    } else {
                        key = A;
                    }
                }
            } else {
                if (see(1) <= EMPTY) {
                    if (see(3) <= VISITED) {
                        if (see(1) <= VISITED) {
                            key = S;
                        } else {
                            if (see(5) <= VISITED) {
                                key = W;
                            } else {
                                if (see(2) <= EMPTY) {
                                    key = S;
                                } else {
                                    key = D;
                                }
                            }
                        }
                    } else {
                        if (see(4) <= VISITED) {
                            if (see(6) <= EMPTY) {
                                if (see(5) <= EMPTY) {
                                    key = A;
                                } else {
                                    key = S;
                                }
                            } else {
                                key = S;
                            }
                        } else {
                            if (see(3) <= EMPTY) {
                                if (see(0) <= EMPTY) {
                                    key = S;
                                } else {
                                    key = A;
                                }
                            } else {
                                key = A;
                            }
                        }
                    }
                } else {
                    key = W;
                }
            }
        } else {
            key = D;
        }

        return key;
    }

    private char moveAI1x2() {

        char key;

        if (see(4) <= OUTSIDE) {
            key = S;
        } else {
            if (see(7) <= EMPTY) {
                if (see(23) <= VISITED) {
                    if (see(15) <= OUTSIDE) {
                        key = A;
                    } else {
                        key = W;
                    }
                } else {
                    key = A;
                }
            } else {
                key = W;
            }
        }

        return key;
    }

    private char moveAI5x2() {

        char key;

        if (see(16) <= EMPTY) {
            if (see(7) <= EMPTY) {
                if (see(11) <= VISITED) {
                    if (see(9) <= OUTSIDE) {
                        key = W;
                    } else {
                        key = S;
                    }
                } else {
                    if (see(13) <= EMPTY) {
                        if (see(12) <= EMPTY) {
                            if (see(21) <= EMPTY) {
                                if (see(7) <= VISITED) {
                                    if (see(18) <= OUTSIDE) {
                                        if (see(3) <= VISITED) {
                                            key = A;
                                        } else {
                                            if (see(11) <= EMPTY) {
                                                key = S;
                                            } else {
                                                key = A;
                                            }
                                        }
                                    } else {
                                        if (see(6) <= VISITED) {
                                            key = D;
                                        } else {
                                            key = S;
                                        }
                                    }
                                }
                                if (see(5) <= OUTSIDE) {
                                    key = D;
                                } else {
                                    if (see(15) <= VISITED) {
                                        if (see(3) <= VISITED) {
                                            key = A;
                                        } else {
                                            key = W;
                                        }
                                    } else {
                                        key = A;
                                    }
                                }
                            } else {
                                key = S;
                            }
                        } else {
                            key = D;
                        }
                    } else {
                        key = D;
                    }
                }
            } else {
                key = W;
            }
        } else {
            key = S;
        }

        return key;
    }

    private char moveAI10x2() {

        char key;

        if (see(12) <= EMPTY) {
            if (see(16) <= VISITED) {
                if (see(13) <= EMPTY) {
                    if (see(6) <= VISITED) {
                        if (see(2) <= VISITED) {
                            key = A;
                        } else {
                            if (see(6) <= OUTSIDE) {
                                if (see(18) <= VISITED) {
                                    key = W;
                                } else {
                                    key = D;
                                }
                            } else {
                                key = D;
                            }
                        }
                    } else {
                        if (see(12) <= VISITED) {
                            key = A;
                        } else {
                            key = W;
                        }
                    }
                } else {
                    key = D;
                }
            } else {
                if (see(2) <= EMPTY) {
                    if (see(7) <= EMPTY) {
                        if (see(16) <= EMPTY) {
                            if (see(11) <= VISITED) {
                                if (see(8) <= EMPTY) {
                                    if (see(21) <= EMPTY) {
                                        if (see(13) <= VISITED) {
                                            key = W;
                                        } else {
                                            if (see(6) <= VISITED) {
                                                key = D;
                                            } else {
                                                if (see(19) <= VISITED) {
                                                    key = D;
                                                } else {
                                                    key = S;
                                                }
                                            }
                                        }
                                    } else {
                                        key = S;
                                    }
                                } else {
                                    key = W;
                                }
                            } else {
                                if (see(5) <= EMPTY) {
                                    if (see(20) <= OUTSIDE) {
                                        if (see(12) <= VISITED) {
                                            key = A;
                                        } else {
                                            key = D;
                                        }
                                    } else {
                                        if (see(11) <= EMPTY) {
                                            if (see(21) <= EMPTY) {
                                                if (see(15) < EMPTY) {
                                                    if (see(3) <= OUTSIDE) {
                                                        key = S;
                                                    } else {
                                                        if (see(12) <= VISITED) {
                                                            key = A;
                                                        } else {
                                                            if (see(17) <= EMPTY) {
                                                                if (see(9) <= VISITED) {
                                                                    key = A;
                                                                } else {
                                                                    if (see(2) <= VISITED) {
                                                                        if (see(20) <= EMPTY) {
                                                                            if (see(1) <= VISITED) {
                                                                                key = A;
                                                                            } else {
                                                                                key = S;
                                                                            }
                                                                        } else {
                                                                            key = A;
                                                                        }
                                                                    } else {
                                                                        key = S;
                                                                    }
                                                                }
                                                            } else {
                                                                key = S;
                                                            }
                                                        }
                                                    }
                                                } else {
                                                    key = A;
                                                }
                                            } else {
                                                key = S;
                                            }
                                        } else {
                                            key = A;
                                        }
                                    }
                                }
                                if (see(9) <= VISITED) {
                                    key = A;
                                } else {
                                    key = W;
                                }
                            }
                        } else {
                            key = S;
                        }
                    } else {
                        key = W;
                    }
                } else {
                    key = W;
                }
            }
        } else {
            key = D;
        }

        return key;
    }
}
