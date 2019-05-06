package com.lchau;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Encryptor {

  private static final String EMPTY_STRING = "";
  private static final int SHIFT_MODIFIER = 2;

  public static String cryptSentence(String sentence) {
    if (sentence == null || sentence.isEmpty()) {
      return EMPTY_STRING;
    }
    return buildString(sentence, Encryptor::shiftChar);
  }

  public static String cryptWord(String word) {
    if (containsSpace(word)) {
      return EMPTY_STRING;
    }
    return buildString(word, Encryptor::shiftChar);
  }

  public static String cryptWord(String word, String charsToReplace) {
    if (containsSpace(word)) {
      return EMPTY_STRING;
    }

    if (charsToReplace == null || charsToReplace.isEmpty()) {
      return EMPTY_STRING;
    }

    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < charsToReplace.length(); i++) {
      char key = charsToReplace.charAt(i);
      map.put(key, shiftChar(key));
    }
    return buildString(word, ch -> map.getOrDefault(ch, ch));
  }

  public static String cryptWordToNumbers(String word) {
    if (containsSpace(word)) {
      return EMPTY_STRING;
    }
    return buildString(word, Encryptor::shiftValue);
  }

  public static String[] getWords(String sentence) {
    if (sentence == null || sentence.isEmpty()) {
      return new String[0];
    }
    return sentence.split(" ");
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

  private static String buildString(String str, Function<Character, Object> transform) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      sb.append(transform.apply(str.charAt(i)));
    }
    return sb.toString();
  }

  private static boolean containsSpace(String word) {
    return word == null || word.contains(" ");
  }

  private static char shiftChar(char c) {
    return (char) (c + SHIFT_MODIFIER);
  }

  private static String shiftValue(int value) {
    return String.valueOf(value + SHIFT_MODIFIER);
  }
}