import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * CustomFileReader reads words from a file and provides utility methods
 * to get word counts, retrieve words by index,
 * and find words containing a specific letter.
 */
public class CustomFileReader {

  /** Scanner used to read words from the file. */
  private Scanner scanner;

  /** List of words collected by findNewWord(). */
  private List<String> newSentence;

  /** Counter for the number of words read in the file. */
  private int count;

  /**
   * Constructor for CustomFileReader.
   * Initializes the Scanner to read the given file
   * and an empty newSentence list.
   *
   * @param fileName The path to the file to read.
   */
  public CustomFileReader(final String fileName) {
    newSentence = new ArrayList<>();
    try {
      scanner = new Scanner(new FileReader(fileName));
    } catch (FileNotFoundException e) {
      System.out.println("File not found: " + e.getMessage());
      // Ideally replace with proper logging in production
    }
  }

  /**
   * Counts the number of words in the text file.
   *
   * @return Total number of words in the file.
   */
  public int howManyWordsInFile() {
    while (scanner.hasNext()) {
      scanner.next();
      count++;
    }
    return count;
  }

  /**
   * Returns the word at the specified index in the text file.
   *
   * @param index The word index to retrieve.
   * @return The word at the index, or "Bad index" if index is out of bounds.
   */
  public String returnThatWord(final int index) {
    String returnWord = "";
    try {
      for (int i = 0; i < index; i++) {
        returnWord = scanner.next();
      }
    } catch (NoSuchElementException e) {
      return "Bad index";
    }
    return returnWord;
  }

  /**
   * Finds the first word in the file that contains the specified letter
   * and adds it to the newSentence list.
   *
   * @param letter The letter to search for in words.
   */
  public void findNewWord(final CharSequence letter) {
    try {
      String word = scanner.next();
      while (!word.contains(letter)) {
        word = scanner.next();
      }
      newSentence.add(word);
    } catch (NoSuchElementException e) {
      newSentence.add("Error");
    }
  }

  /**
   * Getter for the newSentence list.
   *
   * @return The list of words found using findNewWord().
   */
  public List<String> getNewSentence() {
    return newSentence;
  }

  /**
   * Setter for the newSentence list.
   *
   * @param betterSentence A new list of words to set.
   */
  public void setNewSentence(final List<String> betterSentence) {
    newSentence = betterSentence;
  }
}
