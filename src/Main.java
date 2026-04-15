import java.util.List;

/**
 * This program basically is supposed to be funny.
 * It uses three instances of
 * a CustomFileReader class to interact
 * with three separate dictionaries.
 * The first reader counts the number of
 * words in the first dictionary.
 * It then passes this number to the second
 * reader which reads that many words
 * from the second dictionary and gives the word it
 * stopped on to the third reader.
 * The third reader will use the first letter of this
 * word to find the first word in
 * the third dictionary that contains this letter and
 * add it to a list.  The sentence
 * will be as long as the user specifies in the program arguments.
 * The program continues
 * this pattern, until the number of words we want for our sentence is met.
 * In the end we
 * give the sentence constructed by the third reader to
 * the first reader and display it.
 */
public final class Main {
  /**
   * Private constructor to prevent instantiation of this utility class.
   */
  private Main() {
    // Do nothing
  }

  /**
     * This program will take four arguments.
     *     Program arguments should be arg[0] readMe1.txt, arg[1] readMe2.txt,
     *     arg[2] readMe3.txt, arg[3] how many letters you want in your sentence
     * @param args listed above
     */
    public static void main(final String[] args) {

      final int argIndexNumWords = 3;

      CustomFileReader reader1 = new CustomFileReader(args[0]);
      CustomFileReader reader2 = new CustomFileReader(args[1]);
      CustomFileReader reader3 = new CustomFileReader(args[2]);

      int numberOfWords = Integer.parseInt(args[argIndexNumWords]);

      // Construct the sentence by repeating the pattern
      for (int i = 0; i < numberOfWords; i++) {
        int howManyWords = reader1.howManyWordsInFile();
        String wordFromIndex = reader2.returnThatWord(howManyWords);
        reader3.findNewWord(wordFromIndex.substring(0, 1).toLowerCase());
      }

      // Retrieve the sentence from reader3 and set it in reader1
      List<String> sentenceForReader1 = reader3.getNewSentence();
      reader1.setNewSentence(sentenceForReader1);

      // Display the constructed sentence
      System.out.println(reader1.getNewSentence().toString());
    }
}
