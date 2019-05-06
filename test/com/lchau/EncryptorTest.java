package com.lchau;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.Assert;
import org.junit.Test;

public class EncryptorTest {

  @Test
  public void testCryptSentence() {
    Assert.assertEquals(new Encryptor().cryptSentence("hello world!"), "jgnnq\"yqtnf#");
  }

  @Test
  public void testCryptSentenceEmpty() {
    Assert.assertEquals(new Encryptor().cryptSentence(""), "");
  }

  @Test
  public void testCryptSentenceNull() {
    Assert.assertEquals(new Encryptor().cryptSentence(null), "");
  }

  @Test
  public void testCryptWord() {
    Assert.assertEquals(new Encryptor().cryptWord("hello"), "jgnnq");
  }

  @Test
  public void testCryptWordSome() {
    Assert.assertEquals(new Encryptor().cryptWord("hello", "eo"), "hgllq");
    Assert.assertEquals(new Encryptor().cryptWord("hello", "ho"), "jellq");
  }

  @Test
  public void testCryptWordAll() {
    Assert.assertEquals(new Encryptor().cryptWord("hello", "hello"), "jgnnq");
  }

  @Test
  public void testCryptWordNull() {
    Assert.assertEquals(new Encryptor().cryptWord(null), "");
  }

  @Test
  public void testCryptWordNullWord() {
    Assert.assertEquals(new Encryptor().cryptWord(null, "foo"), "");
  }

  @Test
  public void testCryptWordNullReplace() {
    Assert.assertEquals(new Encryptor().cryptWord("hello", null), "");
  }

  @Test
  public void testCryptWordToNumbers() {
    Assert.assertEquals(new Encryptor().cryptWordToNumbers("hello"), "106103110110113");
  }

  @Test
  public void testCryptWordToEmpty() {
    Assert.assertEquals(new Encryptor().cryptWordToNumbers(null), "");
  }

  @Test
  public void testGetWords() {
    Assert
        .assertArrayEquals(new Encryptor().getWords("hello world"), new String[]{"hello", "world"});
  }

  @Test
  public void testGetWordsEmpty() {
    Assert.assertArrayEquals(new Encryptor().getWords(""), new String[0]);
  }

  @Test
  public void testGetWordsSpace() {
    Assert.assertArrayEquals(new Encryptor().getWords(" "), new String[0]);
  }

  @Test
  public void testGetWordsNull() {
    Assert.assertArrayEquals(new Encryptor().getWords(null), new String[0]);
  }

  @Test
  public void testPrintWords() {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream stream = new PrintStream(outputStream);

    new Encryptor().printWords("this is a test", stream);

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

    new Encryptor().printWords(null, stream);

    String actual = new String(outputStream.toByteArray());
    String expected = "";
    Assert.assertEquals(expected, actual);
  }
}