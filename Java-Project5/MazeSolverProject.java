import java.util.Stack;

public class MazeSolverProject {

    public static void main(String[] args) {
        int grid = 5;

        int[][] maze = getMaze(grid);

        Stack<int[]> path = new Stack<>();

        maze[1][1] = 2;
        MazeUtility.plotMaze(maze);

        int[] position = new int[]{1,1};

        path.push(position);

        move(maze, position, path, 2*grid-1);

        MazeUtility.plotMaze(maze);
    }

    public static int[][] getMaze(int grid) {
        MazeGenerator maze = new MazeGenerator(grid);
        String str = maze.toString();

        int[][] maze2D = MazeUtility.Convert2D(str);
        return maze2D;
    }

    public static int[][] move(int[][] maze, int[] position, Stack<int[]> stack, int reachDest){
        if (position[0] == reachDest && position[1] == reachDest) {
            return maze;
        }

        int[] last = stack.peek();
        int[] newPosition = getNewPosition(maze, position, last);

        if(newPosition[0] == 0 && newPosition[1] == 0) {
            int[] lastPosition = stack.pop();
            maze[lastPosition[1]][lastPosition[0]] = 0;
            maze[position[1]][position[0]] = 2;
            MazeUtility.plotMaze(maze);
            move(maze, lastPosition, stack, reachDest);
            return maze;
        }

        stack.push(position);
        maze[position[1]][position[0]] = 0;
        maze[newPosition[1]][newPosition[0]] = 2;

        MazeUtility.plotMaze(maze);
        move(maze, newPosition, stack, reachDest);

        return maze;
    }

    public static int[] getNewPosition(int[][] maze, int[] position, int[] last) {
        int[] newPosition = new int[2];
        int x = position[0];
        int y = position[1];

        if(maze[y][x+1] == 0 && x+1 != last[0]) {
            newPosition[0] = x+1;
            newPosition[1] = y;
        } else if(maze[y+1][x] == 0 && y+1 != last[1]){
            newPosition[0] = x;
            newPosition[1] = y+1;
        } else if(maze[y][x-1] == 0 && x-1 != last[0]){
            newPosition[0] = x-1;
            newPosition[1] = y;
        } else if(maze[y-1][x] == 0 && y-1 != last[1]){
            newPosition[0] = x;
            newPosition[1] = y-1;
        }

        return newPosition;
    }
}