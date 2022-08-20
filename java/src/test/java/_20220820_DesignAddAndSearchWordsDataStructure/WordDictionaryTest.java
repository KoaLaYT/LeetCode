package _20220820_DesignAddAndSearchWordsDataStructure;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class WordDictionaryTest {

    private WordDictionary wordDictionary;

    @Before
    public void setup() {
        wordDictionary = new WordDictionary();
    }

    @Test
    public void test() {
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        Assert.assertFalse(wordDictionary.search("pad"));
        Assert.assertTrue(wordDictionary.search("bad"));
        Assert.assertTrue(wordDictionary.search(".ad"));
        Assert.assertTrue(wordDictionary.search("b.."));
        Assert.assertFalse(wordDictionary.search("daddy"));
    }

}