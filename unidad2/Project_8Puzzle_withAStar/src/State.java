import java.util.*;
public class State {
    int[][] board;
    int x, y; // Position of the empty space (0)

    State(int[][] board) {
        this.board = board;
        // Find the position of the empty space
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    x = i;
                    y = j;
                    return; // Found the empty space, exit the loop
                }
            }
        }
    }

    boolean isGoal() {
        int[][] goalState = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
        return Arrays.deepEquals(board, goalState);
    }

    List<State> getNextStates() {
        List<State> nextStates = new ArrayList<>();
        int[] dx = {-1, 1, 0, 0}; // Up, Down, Left, Right
        int[] dy = {0, 0, -1, 1};
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                int[][] newBoard = new int[3][3];
                for (int j = 0; j < 3; j++) {
                    newBoard[j] = Arrays.copyOf(board[j], 3);
                }
                // Swap empty space with adjacent tile
                newBoard[x][y] = newBoard[nx][ny];
                newBoard[nx][ny] = 0;
                nextStates.add(new State(newBoard));
            }
        }
        return nextStates;
    }

    void printState() {
        for (int[] row : board) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    int manhattanDistance() {
        int distance = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int value = board[i][j];
                if (value != 0) {
                    int targetX = (value - 1) / 3;
                    int targetY = (value - 1) % 3;
                    distance += Math.abs(i - targetX) + Math.abs(j - targetY);
                }
            }
        }
        return distance;
    }
}
