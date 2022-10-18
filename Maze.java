//=================================================
// Duy Pham
// MAZESOLVER
// 09/08/2022
//
// This file will create and manage a maze object,
// as well as print and solve the maze and print
// the result. 
//=================================================
import java.util.*;

class Maze{

    // data members
    private int row;
    private int col;
    private char[][] maze;
    protected Point begin;
    protected Point end;
    private int count = 0;
    private String letter = "abcdefghijklmnopqrstuvwxyz";

    // member functions

    // default constructor
    Maze(){
       initialize();
    }


    // overloaded constructor
    Maze(int r, int c){
        row = r + 2;
        col = c + 2;
        maze = new char[r+2][c+2];
    }

    // initialize method
    public void initialize() {
        row = 0;
        col = 0;
        maze = null;
    }

    // read method
    public void read(Scanner scan) {
       

       //read the line and store the dimmension of the maze
       String dimmension[] = scan.nextLine().split(" ");
       row = Integer.parseInt(dimmension[0]);
       col = Integer.parseInt(dimmension[1]);

       maze = new char[row + 2][col + 2]; //create an empty maze

       //read the next line and store the locations of start and end point. 
       String coordinates[] = scan.nextLine().split(" ");
       begin = new Point(Integer.parseInt(coordinates[0]), Integer.parseInt(coordinates[1]));
       end = new Point(Integer.parseInt(coordinates[2]), Integer.parseInt(coordinates[3]));
    
       //filling the outside edges of maze
       //vertical
       for (int k = 0; k <= row + 1; k++) {
        maze[k][0] = '*';
        maze[k][col+1] = '*';
        }

       //horizontal
       for (int i = 0; i <= col + 1; i++ ) {
        maze[0][i] = '*';
        maze[row+1][i] = '*';
       }

       //filling inside maze
        for (int r = 1; r <= row; r++) {
            String line = scan.nextLine();
            for (int c = 1; c <= col ; c++) {
                maze[r][c] = line.charAt(c - 1);
            }
        }
       
    }

    // print method
    public void print() {
        for(int rowPrint = 0; rowPrint< this.row + 2; rowPrint++) {
            for(int colPrint = 0; colPrint < this.col + 2; colPrint++) {
                System.out.print(maze[rowPrint][colPrint]);
            }
            System.out.println();
        }
    }

    // printall method
    public void printAll() {
        System.out.println("Size: " + row + " * " + col);
        System.out.println("Start: "); 
        begin.print();
        System.out.println("End: "); 
        end.print();
        print();
    }

    // findpath method
    public boolean findPath(Point begin1, Point end1) {
        //get begin point's location
        int x1 = begin1.getX();
        int y1 = begin1.getY();
        
        //check if the point hits the wall (out of bound) or has been visited (!='.')
        if (x1 >= col + 1 || x1 <= 0 || y1 >= row + 1 || y1 <= 0 || maze[x1][y1] != '.') {
            return false;
        }

        //start moving
        maze[x1][y1] = letter.charAt(count % 26); 
        count++;
        
        //check if reached the end
        if(begin1.isEqual(end1)) {
            print();
            return true;
        }

        //recursive methods to go up down left and right
        boolean down = findPath(new Point(x1 + 1, y1), end1); 
        boolean left = findPath(new Point(x1, y1 + 1), end1); 
        boolean up = findPath(new Point(x1 - 1, y1), end1);
        boolean right = findPath(new Point(x1, y1 - 1), end1);

        // go back if path was false
        maze[x1][y1] = '.';
        count = (count + 25) % 26;

        return down || left || up || right;
    }

}