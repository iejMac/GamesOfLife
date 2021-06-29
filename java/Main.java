import java.util.Arrays;
import java.util.Random;
import java.awt.Color;

import javax.swing.JFrame;


class Game {
  
  public int universe_size;
  public int[][] universe;

  public Game(int universe_size) {
    this.universe_size = universe_size;
    this.universe = new int[universe_size][universe_size];
  }

  public void randomPopulation(){
    Random rand = new Random();
    for(int i = 0 ; i < this.universe_size ; i++){
      for(int j = 0 ; j < this.universe_size ; j++){
        this.universe[i][j] = rand.nextInt(2);
      }
    }
  }

  public void showUniverse() { 
    JFrame frame = new JFrame();
    frame.setTitle("Game of Life");
    frame.setSize(420, 420);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setResizable(false);
    frame.setVisible(true);
    frame.getContentPane().setBackground(Color.darkGray);
  }
  
  public int getPopulation(int i, int j){
    int sum = 0;
    for(int row = Math.max(0, i-1) ; row <= Math.min(i + 1, this.universe_size-1) ; row++){
      for(int col = Math.max(0, j-1) ; col <= Math.min(j + 1, this.universe_size-1) ; col++){
        sum += this.universe[row][col];
      }
    }
    return sum;
  }

  public void step() {
    int[][] new_universe = new int[this.universe_size][this.universe_size];
    for(int i = 0 ; i < this.universe_size ; i++){
      for(int j = 0 ; j < this.universe_size ; j++){
        int pop = getPopulation(i, j);
        new_universe[i][j] = (((this.universe[i][j] == 0) && pop == 3) || ((this.universe[i][j] == 1) && ((pop >= 2) && (pop <= 3)))) ? 1 : 0;
      }
    }
    this.universe = new_universe;
  }
}

public class Main {
  public static void main(String[] args) {
    int universe_length = 10;
    Game uni = new Game(10);
    uni.randomPopulation();
    uni.showUniverse();

  }
}
