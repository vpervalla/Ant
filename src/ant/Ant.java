/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ant;

/**
 *
 * @author probe droid
 */
public class Ant {

    public class Point {

        private int m_x;
        private int m_y;

        Point(int x, int y) {
            m_x = x;
            m_y = y;
        }

        public int getX() {
            return m_x;
        }

        public int getY() {
            return m_y;
        }

    }

    public Ant(int fov) {
        m_fov = fov;
    }

    private Point m_pos;
    private int m_fov;

    public void setPos(Point pos) {
        m_pos = pos;
    }

    public Point getPos() {
        return m_pos;
    }

    public int getX() {
        return m_pos.getX();
    }

    public int getY() {
        return m_pos.getY();
    }

    public void setFov(int fov) {
        m_fov = fov;
    }

    public int getFov() {
        return m_fov;
    }

    public void moveUp() {
        m_pos.m_x--;
    }

    public void moveDown() {
        m_pos.m_x++;
    }

    public void moveLeft() {
        m_pos.m_y--;
    }

    public void moveRight() {
        m_pos.m_y++;
    }
    
    public Point see(int idx)
    {
        int size = 2*m_fov+1;
        
        if (idx >= Math.pow(size,2)/2)
            idx++;
        
        int row = idx/size-m_fov;
        int col = idx%size-m_fov;       
        
        return new Point(m_pos.getX()+row,m_pos.getY()+col);
    }

}
