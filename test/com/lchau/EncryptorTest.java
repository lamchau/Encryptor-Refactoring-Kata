package com.lchau;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Test;

public class EncryptorTest {

  @Test
  public void testCryptSentence() {
    Assert.assertEquals(Encryptor.cryptSentence("hello world!"), "jgnnq\"yqtnf#");
  }

  @Test
  public void testCryptSentenceEmpty() {
    Assert.assertEquals(Encryptor.cryptSentence(""), "");
  }

  @Test
  public void testCryptSentenceNull() {
    Assert.assertEquals(Encryptor.cryptSentence(null), "");
  }

  @Test
  public void testCryptWord() {
    Assert.assertEquals(Encryptor.cryptWord("hello"), "jgnnq");
  }

  @Test
  public void testCryptWordSome() {
    Assert.assertEquals(Encryptor.cryptWord("hello", "eo"), "hgllq");
    Assert.assertEquals(Encryptor.cryptWord("hello", "ho"), "jellq");
  }

  @Test
  public void testCryptWordAll() {
    Assert.assertEquals(Encryptor.cryptWord("hello", "hello"), "jgnnq");
  }

  @Test
  public void testCryptWordNull() {
    Assert.assertEquals(Encryptor.cryptWord(null), "");
  }

  @Test
  public void testCryptWordNullWord() {
    Assert.assertEquals(Encryptor.cryptWord(null, "foo"), "");
  }

  @Test
  public void testCryptWordNullReplace() {
    Assert.assertEquals(Encryptor.cryptWord("hello", null), "");
  }

  @Test
  public void testCryptWordToNumbers() {
    Assert.assertEquals(Encryptor.cryptWordToNumbers("hello"), "106103110110113");
  }

  @Test
  public void testCryptWordToEmpty() {
    Assert.assertEquals(Encryptor.cryptWordToNumbers(null), "");
  }

  @Test
  public void testGetWords() {
    Assert.assertArrayEquals(Encryptor.getWords("hello world"), new String[] { "hello", "world"});
  }

  @Test
  public void testGetWordsEmpty() {
    Assert.assertArrayEquals(Encryptor.getWords(""), new String[0]);
  }

  @Test
  public void testGetWordsSpace() {
    Assert.assertArrayEquals(Encryptor.getWords(" "), new String[0]);
  }

  @Test
  public void testGetWordsNull() {
    Assert.assertArrayEquals(Encryptor.getWords(null), new String[0]);
  }

  @Test
  public void testPrintWords() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream stream = new PrintStream(outputStream);

    Encryptor.printWords("this is a test", stream);

    String actual = new String(outputStream.toByteArray());
    String expected = ""
        + "<this>\n"
        + "<is>\n"
        + "<a>\n"
        + "<test>\n";
    Assert.assertEquals(expected, actual);
  }

  @Test
  public void testPrintWordsNull() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream stream = new PrintStream(outputStream);

    Encryptor.printWords(null, stream);

    String actual = new String(outputStream.toByteArray());
    String expected = "";
    Assert.assertEquals(expected, actual);
  }
}
