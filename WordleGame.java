import java.io.FileNotFoundException;

public class WordleGame {
  /* allGuesses represents the wordle game */

  private static final int maxGuesses = 6;
  private static final int wordLength = 5;

  private WordleLetter[][] allGuesses;
  private int guessCount; // Number of guesses made so far
  private String answer; // The correct answer for this game
  private boolean gameOver = false; // Game is over
  private boolean gameWin = false; // Player has won
  private String guessWord;

  //Constructor
  public WordleGame(int puzzleNumber){
    allGuesses = new WordleLetter[maxGuesses][wordLength];
    answer = WordBank.getAnswerForPuzzleNumber(puzzleNumber);
  } 

  public String getAnswer(){
    return answer;
  }

  //Method to make a guess and update the game
  public void guess(String guessWord){
    if(gameOver || guessCount >= maxGuesses){
      System.out.println("Game is over. No more guesses allowed");
    }

    WordleLetter[] wordleLetters = new WordleLetter[wordLength];
    boolean[] matched = new boolean[wordLength];

    //Mark the correct letters in the correct positions
    for(int i = 0; i < wordLength; i++) {
      char guessLetter = guessWord.charAt(i);
      wordleLetters[i] = new WordleLetter(guessLetter);

      if(guessLetter == answer.charAt(i)){
        wordleLetters[i].setColor("green");
        matched[i] = true;
      }
    }

    for(int i = 0; i < wordLength; i++){
      if(wordleLetters[i].isColorSet()){
        continue;
      }
      char guessLetter = guessWord.charAt(i);

      for(int j = 0; j < wordLength; j++){
        if(i != j && guessLetter == answer.charAt(j) && !matched[j]){
          wordleLetters[i].setColor("yellow");
          matched[j] = true;
        }
      }
    }

    for(int i = 0; i < wordLength; i++){
      if(!wordleLetters[i].isColorSet()){
        wordleLetters[i].setColor("red");
      }
    }

    //Store the guess in the 2D Array
    allGuesses[guessCount] = wordleLetters;
    guessCount++;

    //Check if the latest guess matches the answer
    gameWin = guessWord.equals(answer);
    gameOver = gameWin || guessCount >= maxGuesses;
  }

  public int getNumberGuessesSoFar(){
    return guessCount;
  }

  //Get the guess at a specific index
  public WordleLetter[] getGuess(int guessNumber){
    if(guessNumber < 0 || guessNumber >= guessCount){
      System.out.println("Invalid guess number.");
    }
    return allGuesses[guessNumber];
  }

  //Check if the game is over
  public boolean isGameOver(){
    if(guessCount >= maxGuesses){
      return true;
    }
    guessWord = "";
    for(int i = 0; i < guessCount; i++){
      guessWord = "";
      for(int j = 0; j < 5; j++){
        guessWord += allGuesses[i][j].getLetter();
      }
      if(guessWord.equals(answer)){
        return true;
      }
    }
    //return false;
    return guessWord.equals(answer);
  }

  //Check if the player has won the game
  public boolean isGameWin(){
    if(guessWord.equals("")){
      return false;
    }

    //Get the last guess of the player
    WordleLetter[] lastTry = allGuesses[guessCount-1];
    System.out.println(guessCount);

    String word = "";
    for(int i = 0; i < lastTry.length; i++){
      WordleLetter letter = lastTry[i];
      word += letter.getLetter();
    }
    return word.equals(answer);
  }

  /*------TODO - implement according to spec ------*/
  

  /*------- TODO - include the remainder of the below code back in once rest of class is implemented.
            Do not modify this method implementation ------*/

  public String toString() {
    /* result will be used to build the full answer String */ 
    String result = ""; 
    /* for each word guessed so far */ 
    for (int i = 0; i < getNumberGuessesSoFar(); i++) {
      /* get each letter of each word */
      for (int j = 0; j < 5; j++) {
        /* concatenate it to the result */ 
        /* WordleLetter's toString() is automatically invoked here. */
        result += getGuess(i)[j];
      }
      /* new line separator between each word */ 
      result += "\n";
      }
    return result;
  }
}
