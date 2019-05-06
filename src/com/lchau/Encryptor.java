package com.lchau;

import java.io.PrintStream;

public class Encryptor {

  private static final String EMPTY_STRING = "";

  public static String cryptSentence(String sentence) {
    if (sentence == null || sentence.isEmpty()) {
      return EMPTY_STRING;
    }
    char[] sentenceArray = sentence.toCharArray();
    String newWord = "";
    for (int i = 0; i < sentence.length(); i++) {
      int charValue = sentenceArray[i];
      newWord += String.valueOf((char) (charValue + 2));
    }

    return newWord;
  }

  public static void printWords(String sentence, PrintStream stream) {
    if (sentence == null || stream == null) {
      return;
    }
    String[] words = getWords(sentence);
    for (String word : words) {
      stream.println("<" + word + ">");
    }
  }

  public static String cryptWord(String word) {
    if (containsSpace(word)) {
      return EMPTY_STRING;
    }

    char[] wordArray = word.toCharArray();
    String newWord = "";
    for (int i = 0; i < word.length(); i++) {
      int charValue = wordArray[i];
      newWord += String.valueOf((char) (charValue + 2));
    }

    return newWord;
  }

  public static String cryptWordToNumbers(String word) {
    if (containsSpace(word)) {
      return EMPTY_STRING;
    }

    char[] wordArray = word.toCharArray();
    String newWord = "";
    for (int i = 0; i < word.length(); i++) {
      int charValue = wordArray[i];
      newWord += String.valueOf(charValue + 2);
    }

    return newWord;
  }

  public static String cryptWord(String word, String charsToReplace) {
    if (containsSpace(word)) {
      return EMPTY_STRING;
    }

    if (charsToReplace == null || charsToReplace.isEmpty()) {
      return EMPTY_STRING;
    }

    char[] wordArray = word.toCharArray();
    char[] replacement = charsToReplace.toCharArray();
    char[] result = wordArray.clone();
    for (int i = 0; i < wordArray.length; i++) {
      for (int j = 0; j < replacement.length; j++) {
        if (replacement[j] == wordArray[i]) {
          int charValue = wordArray[i];
          result[i] = (char) (charValue + 2);
        }
      }
    }
    return String.valueOf(result);
  }

  public static String[] getWords(String sentence) {
    if (sentence == null || sentence.isEmpty()) {
      return new String[0];
    }
    return sentence.split(" ");
  }

  private static boolean containsSpace(String word) {
    return word == null || word.contains(" ");
  }
}