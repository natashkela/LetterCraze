package Common;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;

public class WordTable {
    static Hashtable<String,Boolean> table;

    /** Default word table. */
    public static final String wordTable = "WordTable.sort";

    /**
     * Load up word table. Note that there may be superfluous spaces throughout for formatting
     * reasons, and these are excised before being added to the table.
     * 
     * @throws IOException   if unable to find file 
     */
    public static void loadWordTable() throws IOException {
        table = new Hashtable<String,Boolean>();

        Iterator<String> it = new StringFileIterator(new File (".", wordTable));
        while (it.hasNext()) {
            String word = it.next();
            word = word.trim();
            table.put(word, Boolean.TRUE);
        }
    }

    /**
     * Load up word table from ArrayList of strings.
     * 
     * @param words     ArrayList of words to be loaded
     */
    public static void loadWordTable(LinkedList<String> words) {
        table = new Hashtable<String,Boolean>();

        int numWords = words.size();
        for (int i = 0; i < numWords; i++) {
            String word = words.get(i);
            word = word.trim();
            word = word.toLowerCase();
            table.put(word, Boolean.TRUE);
        }
    }

    /**
     * Converts word to lowercase and checks whether exists within table.
     * 
     * @param s
     * @return     <code>true</code> if a word in the table; <code>false</code> otherwise.
     */
    public static boolean isWord(String s) {
        if (table == null) {
            try {
                loadWordTable();
            } catch (IOException ioe) {
                System.err.println("Word Table Not Yet Initialized!");
                return false;
            }
        }

        s = s.toLowerCase();
        return table.containsKey(s);
    }
}
