import java.util.Arrays;
import java.util.Random;

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
		for(int[] row : this.universe){
			System.out.println(Arrays.toString(row));
		}
  }
}

public class Main {
  public static void main(String[] args) {
    int universe_length = 10;
    Game uni = new Game(10);

    uni.showUniverse();
		uni.randomPopulation();
    uni.showUniverse();

  }
}

