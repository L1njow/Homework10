import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class WordsCounter {
    public static void main(String[] args) {
        List<Word> words = new ArrayList<>();
        boolean isContainsInList = false;

        //Зчитуємо кожне слово з файлу
        try (Scanner s = new Scanner(new File("words.txt"))) {
            while (s.hasNext()) {
                String checkedWord = s.next();

                //Перевірка, чи є слово в списку
                for (Word word : words) {
                    if (checkedWord.equals(word.getWord())) {
                        word.countIncrement();
                        isContainsInList = true;//Якщо слово є в списку, тоді збільшуємо кількість його входжень на 1
                        break;
                    }
                }
                //Якщо слова немає в списку, тоді додаємо його
                if (!isContainsInList) {
                    words.add(new Word(checkedWord));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }

        //Виведення в консоль з сортуванням
        while (!words.isEmpty()) {
            int index = 0;
            int maxCount = 0;

            //Проходимо по кожному слову і знаходимо індекс слова з найбільшою кількістю входжень
            for (int i = 0; i < words.size(); i++) {
                if (words.get(i).getCount() > maxCount) {
                    maxCount = words.get(i).getCount();
                    index = i;
                }
            }
            System.out.println(words.get(index).getWord() + " " + words.get(index).getCount());
            words.remove(index);//Видаляємо слово зі списку
        }

    }
}
