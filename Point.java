//=================================================
// Duy Pham
// MAZESOLVER
// 09/08/2022
//
// This file is used to create and manage a Point 
// in the maze.
//=================================================
import java.util.*;

class Point{

    // data members
    private int x;
    private int y;

    // member functions

    // default constructor
    Point(){
        x = 0;
        y = 0;
    } 

    // overloaded constructor
    Point(int x_val, int y_val){
        x = x_val;
        y = y_val;
    }

    // copy constructor
    Point(Point other){
        x = other.x;
        y = other.y;
    }


    // getX method
    public int getX() {
        return x;
    }


    // getY method
    public int getY() {
        return y;
    }

    // setX method
    public void setX(int newX) {
        x = newX;
    }

    // setY method
    public void setY(int newY) {
        y = newY;
    }

    // isEqual method
    public boolean isEqual(Point p) {
        return (x == p.getX() && y == p.getY());
    }

    // read method
    public Point read(Scanner sc) {
        String[] xy = sc.nextLine().split(" ");
        Point inP = new Point(Integer.parseInt(xy[0]),Integer.parseInt(xy[1]));
        return inP;
    }

    // print method
    public void print() {
        System.out.println("(" + x + ", " + y + ")");
    }


}