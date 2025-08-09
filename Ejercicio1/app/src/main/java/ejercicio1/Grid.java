package ejercicio1;
class Grid{
    private int rows;
    private int cols;
    private boolean[][] grid;
    private char finalDirection;

    public Grid(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = false;
            }
        }
    }

    public char getFinalDirection() {
        return finalDirection;
    }

    public void walkArroundGrid(){
        //First position 
        grid[0][0] = true;
        finalDirection = 'R';
        moveRight(0, 0);
    }

    private void moveRight(int rowState, int colState){
        int i = rowState;
        for (int j = colState; j < cols; j++){
            if (j+1 < cols && grid[i][j+1] == false) {
                grid[i][j+1] = true;
            }else if(i+1< rows && grid[i+1][j] == false) {
                moveDown(i, j);
                return;
            }else{
                finalDirection = 'R';
                return;
            }
        }   
    }
    private void moveDown(int rowState, int colState){
        int j = colState;
        for (int i = rowState; i< rows; i++){
            if (i+1 < rows && grid[i+1][j] == false) {
                grid[i+1][j] = true;
            } else if (j-1 >= 0 && grid[i][j-1] == false) {
                moveLeft(i, j);
                return;
            }else{
                finalDirection = 'D';
                return;
            }
        }
    }
    private void moveLeft(int rowState, int colState){
        int i = rowState;
        for (int j=colState; j >= 0; j--){
            if (j-1 >= 0 && grid[i][j-1] == false) {
                grid[i][j-1] = true;
            } else if (i-1 >= 0 && grid[i-1][j] == false) {
                moveUp(i, j);
                return;
            }else{
                finalDirection = 'L';
                return;
            }
        }
    }
    private void moveUp(int rowState, int colState){
        int j = colState;
        for (int i = rowState; i >= 0; i--){
            if(i-1 >= 0 && grid[i-1][j] == false) {
                grid[i-1][j] = true;
            } else if (j+1 < cols && grid[i][j+1] == false) {
                moveRight(i, j);
                return;
            }else{
                finalDirection = 'U';
                return;
            }
        }
    }

}