import java.util.Objects;

public class Word {
    private String word;
    private int count = 0;

    public Word(String word) {
        this.word = word;
        count++;
    }

    public void countIncrement() {
        count++;
    }

    public String getWord() {
        return word;
    }

    public int getCount() {
        return count;
    }
}
