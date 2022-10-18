//=================================================
// Duy Pham
// MAZESOLVER
// 09/08/2022
//
// This file contains the main class and run the 
// maze, it also reads from the terminal and print
// out the output.
//=================================================
import java.util.*;

class MazeSolver{
    
    public static void main(String [] args){

        Scanner sc = new Scanner(System.in);

        //read the number of mazes
        int nuMaze = Integer.parseInt(sc.nextLine()); 
        
        //skip the fist line
        sc.nextLine();

        for (int i = 0; i < nuMaze; i++) {
            
            //initialize a new maze
            Maze m = new Maze();
            
            //read and fill in 
            m.read(sc);

            System.out.println();

            if(m.findPath(m.begin, m.end))
               System.out.println();
            else {
                System.out.println("NO PATH EXISTS");
                System.out.println();
            }

         }

        System.out.println("Game Over");
    }
}