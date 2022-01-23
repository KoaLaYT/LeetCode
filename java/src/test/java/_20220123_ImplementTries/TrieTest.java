package _20220123_ImplementTries;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TrieTest {

    private Trie trie;

    @Before
    public void setup() {
        this.trie = new Trie();
    }

    @Test
    public void basic() {
        trie.insert("apple");
        Assert.assertTrue(trie.search("apple"));
        Assert.assertFalse(trie.search("app"));
        Assert.assertTrue(trie.startsWith("app"));

        trie.insert("app");
        Assert.assertTrue(trie.search("app"));
    }

}