/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ant;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Random;

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
    private Ant m_ant;
    private int m_score;
    private int m_moves;
    private final String m_fileName = "ant.arff";

    public Game(int dim, boolean first) {
        m_dim = dim;
        m_score = 0;
        m_moves = m_dim * 2;
        initGrid();
        initFood();
        initAnt();
        if (first) {
            initFile();
        }
    }

    public void move(char key) {
        key = Character.toUpperCase(key);

        switch (key) {
            case 'W':
                saveStatus();
                m_ant.moveUp();
                break;
            case 'S':
                saveStatus();
                m_ant.moveDown();
                break;
            case 'A':
                saveStatus();
                m_ant.moveLeft();
                break;
            case 'D':
                saveStatus();
                m_ant.moveRight();
                break;
            default:
                moveAI10x1Bis();
                return;
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

    private void initAnt() {
        m_ant = new Ant(1);
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

        int nRow, nCol;

        switch (idx) {
            case 0:
                nRow = -1;
                nCol = -1;
                break;
            case 1:
                nRow = -1;
                nCol = 0;
                break;
            case 2:
                nRow = -1;
                nCol = +1;
                break;
            case 3:
                nRow = 0;
                nCol = -1;
                break;
            case 4:
                nRow = 0;
                nCol = +1;
                break;
            case 5:
                nRow = +1;
                nCol = -1;
                break;
            case 6:
                nRow = +1;
                nCol = 0;
                break;
            case 7:
                nRow = +1;
                nCol = +1;
                break;
            default:
                nRow = 0;
                nCol = 0;
                break;
        }

        int row = m_ant.getX() + nRow;
        int col = m_ant.getY() + nCol;

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
            key = 'W';
        } else {
            if (see(2) <= VISITED) {
                key = 'A';
            } else {
                key = 'S';
            }
        }

        move(key);
        return key;
    }

    private char moveAI10x1() {

        char key;

        if (see(1) <= VISITED) {
            if (see(6) <= VISITED) {
                key = 'A';
            } else {
                if (see(3) <= EMPTY) {
                    if (see(2) <= EMPTY) {
                        key = 'S';
                    } else {
                        key = 'A';
                    }
                } else {
                    key = 'A';
                }
            }
        } else {
            if (see(6) > EMPTY) {
                key = 'S';
            } else {
                if (see(4) <= VISITED) {
                    if (see(1) <= EMPTY) {
                        if (see(5) <= VISITED) {
                            key = 'W';
                        } else {
                            key = 'A';
                        }
                    } else {
                        key = 'W';
                    }
                } else {
                    if (see(6) <= VISITED) {
                        if (see(3) <= EMPTY) {
                            if (see(7) <= EMPTY) {
                                if (see(4) <= EMPTY) {
                                    key = 'W';
                                } else {
                                    key = 'D';
                                }
                            } else {
                                key = 'D';
                            }
                        } else {
                            key = 'A';
                        }
                    }
                    if (see(1) <= EMPTY) {
                        if (see(0) <= EMPTY) {
                            key = 'D';
                        } else {
                            key = 'W';
                        }
                    } else {
                        key = 'W';
                    }

                }
            }
        }

        move(key);
        return key;
    }

    private char moveAI10x1Bis() {

        char key;

        if (see(4) <= EMPTY) {
            if (see(6) <= VISITED) {
                if (see(1) <= VISITED) {
                    if (see(3) <= VISITED) {
                        key = 'D';
                    } else {
                        key = 'A';
                    }
                } else {
                    if (see(3) <= EMPTY) {
                        key = 'W';
                    } else {
                        key = 'A';
                    }
                }
            } else {
                if (see(1) <= EMPTY) {
                    if (see(3) <= VISITED) {
                        if (see(1) <= VISITED) {
                            key = 'S';
                        } else {
                            if (see(5) <= VISITED) {
                                key = 'W';
                            } else {
                                if (see(2) <= EMPTY) {
                                    key = 'S';
                                } else {
                                    key = 'D';
                                }
                            }
                        }
                    } else {
                        if (see(4) <= VISITED) {
                            if (see(6) <= EMPTY) {
                                if (see(5) <= EMPTY) {
                                    key = 'A';
                                } else {
                                    key = 'S';
                                }
                            } else {
                                key = 'S';
                            }
                        } else {
                            if (see(3) <= EMPTY) {
                                if (see(0) <= EMPTY) {
                                    key = 'S';
                                } else {
                                    key = 'A';
                                }
                            } else {
                                key = 'A';
                            }
                        }
                    }
                } else {
                    key = 'W';
                }
            }
        } else {
            key = 'D';
        }

        move(key);
        return key;
    }
}
