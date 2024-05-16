import java.util.*;

public class EightPuzzle {
    static void BFS(State initial) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        Node initialNode = new Node(initial, null, 0 ,0);
        queue.add(initialNode);
        visited.add(Arrays.deepToString(initial.board));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            State currentState = currentNode.state;
            if (currentState.isGoal()) {
                printSolution(currentNode, visited.size());
                return;
            }
            for (State nextState : currentState.getNextStates()) {
                String nextStateStr = Arrays.deepToString(nextState.board);
                if (!visited.contains(nextStateStr)) {
                    visited.add(nextStateStr);
                    Node nextNode = new Node(nextState, currentNode, currentNode.depth + 1, currentNode.depth + 1);
                    queue.add(nextNode);
                }
            }
        }
    }

    // Depth First Search
    static void DFS(State initial) {
        Stack<Node> stack = new Stack<>();
        Set<String> visited = new HashSet<>();
        Node initialNode = new Node(initial, null, 0, 0);
        stack.push(initialNode);
        visited.add(Arrays.deepToString(initial.board));

        while (!stack.isEmpty()) {
            Node currentNode = stack.pop();
            State currentState = currentNode.state;
            if (currentState.isGoal()) {
                printSolution(currentNode, visited.size());
                return;
            }
            for (State nextState : currentState.getNextStates()) {
                String nextStateStr = Arrays.deepToString(nextState.board);
                if (!visited.contains(nextStateStr)) {
                    visited.add(nextStateStr);
                    Node nextNode = new Node(nextState, currentNode, currentNode.depth + 1, currentNode.depth + 1);
                    stack.push(nextNode);
                }
            }
        }
    }

    static void AStar(State initial) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n -> n.cost));
        Map<String, Integer> visited = new HashMap<>();
        Node initialNode = new Node(initial, null, 0, initial.manhattanDistance());
        queue.add(initialNode);
        visited.put(Arrays.deepToString(initial.board), 0);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            State currentState = currentNode.state;
            if (currentState.isGoal()) {
                printSolution(currentNode, visited.size());
                return;
            }
            for (State nextState : currentState.getNextStates()) {
                String nextStateStr = Arrays.deepToString(nextState.board);
                int newCost = currentNode.depth + 1 + nextState.manhattanDistance();
                if (!visited.containsKey(nextStateStr) || newCost < visited.get(nextStateStr)) {
                    visited.put(nextStateStr, newCost);
                    Node nextNode = new Node(nextState, currentNode, currentNode.depth + 1, newCost);
                    queue.add(nextNode);
                }
            }
        }
    }

    static void printSolution(Node node, int visitedNodes) {
        List<State> path = new ArrayList<>();
        int cost = 0;
        int depth = 0;
        while (node != null) {
            path.add(0, node.state);
            node = node.parent;
        }
        for (State state : path) {
            state.printState();
        }
        System.out.println("Visited Nodes: " + visitedNodes);
    }

}
