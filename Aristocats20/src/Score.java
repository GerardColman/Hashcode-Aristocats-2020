import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Score {
    Heuristic heuristic = new Heuristic();
    PizzaIO pio = new PizzaIO();


    private int score = 0;
    int pizzaArray[] = pio.Intialise();

    public Score() throws FileNotFoundException {
        this.calculateScore(pizzaArray);
    }

    public int getScore() {
        return score;
    }

    
    private int calculateScore(int arr[]){
        int index;
        for(int i = 0;i<heuristic.arrayList.size();i++){
            index = heuristic.arrayList.get(i);
            score += arr[index];
        }
        return score;
    }
}