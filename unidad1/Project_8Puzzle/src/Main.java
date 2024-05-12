import java.util.Scanner;

public class Main {
    private static EightPuzzle solve = new EightPuzzle();
    private static Scanner sc = new Scanner(System.in);
    private static int select;
    private static boolean flag = true;
    private static long initialTime, endTime;

    public static void main(String[] args) {
        /*
        EASY:
        int[][] initialBoard = {
            {1, 2, 3},
            {0, 4, 5},
            {7, 8, 6}
        };

        MEDIUM
        int[][] initialBoard = {
            {1, 2, 3},
            {4, 0, 6},
            {7, 5, 8}
        };


        HARD
        int[][] InitialBoard = {
            {8, 7, 1},
            {6, 0, 2},
            {5, 4, 3}
        };
        */

        int[][] initialBoard = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 5, 8}
        };
        State initialState = new State(initialBoard);
        System.out.println("Initial State:");
        initialState.printState();

        while (flag) {
            System.out.println("\nSelect search algorithm:");
            System.out.println( "1) Breadth First Search" +
                                "\n2) Depth First Search:" +
                                "\n3) BFS and DFS" +
                                "\n0) Exit");
            select = checkInt();

            switch (select) {
                case 1:
                    System.out.println("\nBFS:");
                    initialTime = System.currentTimeMillis();
                    solve.BFS(initialState);
                    endTime = System.currentTimeMillis();
                    System.out.println("\nTime Taken: " + (endTime-initialTime) + " milliseconds");
                    flag = false;
                    break;

                case 2:
                    System.out.println("\nDFS:");
                    initialTime = System.currentTimeMillis();
                    solve.DFS(initialState);
                    endTime = System.currentTimeMillis();
                    System.out.println("\nTime Taken: " + (endTime-initialTime) + " milliseconds");
                    flag = false;
                    break;

                case 3:
                    System.out.println("\nBFS and DFS: ");
                    System.out.println("\nDFS: ");
                    initialTime = System.currentTimeMillis();
                    solve.DFS(initialState);
                    endTime = System.currentTimeMillis();
                    System.out.println("\nTime Taken: " + (endTime-initialTime) + " milliseconds");

                    System.out.println("\nBFS:");
                    initialTime = System.currentTimeMillis();
                    solve.BFS(initialState);
                    endTime = System.currentTimeMillis();
                    System.out.println("\nTime Taken: " + (endTime-initialTime) + " milliseconds");
                    flag = false;
                    break;

                case 0:
                    flag = false;
                    break;

                default:
                    System.out.println("Please enter a valid integer!");
                    break;
            }
        }
        System.out.println("\nEnd of Program");
    }

    public static int checkInt() {
        int select = 0;
        boolean isInt = false;

        while (!isInt) {
            try {
                select = sc.nextInt();
                isInt = true; // Set isInt to true only if input is integer
            } catch (Exception e) {
                System.out.println("\nPlease enter a valid integer!");
                sc.next(); // Clear the invalid input from scanner
            }
        }
        return select;
    }
}