/** Scorble - a simple Scrabble word score calculator.
 *
 *  This godforsaken thing works in the following way:
 *  - Make sure word was given, show usage if not
 *  - Translates each letter to their scores, places into array.
 *    - Letters are their standard values.
 *    - Blanks are 0 and numbers
 *    - Numbers represent multipliers, and are saved as negatives for future
 *      checking and calculation.
 *  - While the first value of the array is negative, negate it (positive again)
 *    and factor it into the wordMultiplier,
 */

import scala.io.StdIn.readLine;

object Main {

  def main(args: Array[String]): Unit = {

    // Check that input has been given, and convert it to lowercase if so.
    var word: String = "";
    try {
      word = args(0).toLowerCase();
    } catch {
      // If no argument has been passed, show usage.
      case e: IndexOutOfBoundsException => {
        println(usage);
        System.exit(0);
      }
    }

    // Things we need to track:
    var wordMult: Int = 1; // Double/Triple word score tracker
    var scoreString: String = ""; // Stores visual output of numbers sum
    var scores: Array[Int] = Array(); // An array that will hold dictionary
                                      // value of each tile, as well as
                                      // negatives for multipliers (explained above)

    // If characters aren't letters or special symbols, show error msg.
    try {
      scores = word.map(letterValues(_)).toArray();
    } catch {
      case e: NoSuchElementException => {
        Console.err.println("Please insert a valid word. Type `scorble` for usage.");
        System.exit(1);
      }
    }

    // Check for word scores
    while (scores(0) < 0) {
      wordMult *= -scores(0); // Factor in word multiplier for later math.
      scores = scores.tail; // Trim first character
      word = word.tail;
    }

    // First pass fixes multipliers and prepares output string.
    for (x <- 0 to (scores.length - 1)) {

      if (scores(x) >= 0) {
        if (x > 0) scoreString += " + "; // Don't add plus sign to beginning.
        scoreString += s"[${word(x).toUpper}] ${scores(x)}";
      } else {
        scores(x - 1) = -scores(x) * scores(x - 1); // Multiply value
        scoreString += s"(x${-(scores(x))}=${scores(x - 1)})"
        scores(x) = 0; // Then remove multiplier from play.
      }

    }

    println(scoreString + s" = ${scores.sum()}")
    if (wordMult > 1) {
      println(s"[${wordMult}x Word!] ${scores.sum()} x $wordMult = ${scores.sum() * wordMult}")
    }
  }
}

def usage = """usage: java -jar scorble `word`
              |
              |- Use '_' for blank tile.
              |- Use '2' or '3' after a letter for double and triple letter scores respectively.
              |  - Ex: "scorble driv3ers" if 'v' is on triple letter
              |- Use them at the beginning of a word to signify a triple word score.
              |  - Ex: "scorble 3fork2s" if triple word with 'k' on double letter.
            """.stripMargin()

val letterValues: Map[Char, Int] = Map(
  'a' -> 1,
  'b' -> 3,
  'c' -> 3,
  'd' -> 2,
  'e' -> 1,
  'f' -> 4,
  'g' -> 2,
  'h' -> 4,
  'i' -> 1,
  'j' -> 8,
  'k' -> 5,
  'l' -> 1,
  'm' -> 3,
  'n' -> 1,
  'o' -> 1,
  'p' -> 3,
  'q' -> 10,
  'r' -> 1,
  's' -> 1,
  't' -> 1,
  'u' -> 1,
  'v' -> 4,
  'w' -> 4,
  'x' -> 8,
  'y' -> 4,
  'z' -> 10,
  '_' -> 0,
  '2' -> -2,
  '3' -> -3
)
