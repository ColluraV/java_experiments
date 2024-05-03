package streams;

public interface WordsTwoFiles {

	/* 1. Returns the counter of all words */

	long countWords();

	/* 2. Returns all words sorted */

	String[] words();

	/* 3. Returns all words with supplied delimiter */

	String wordsAsString(String delimiter);

	/* 4. Returns all words sorted with no duplicates */

	String[] wordsNoDuplicates();

	/* 5. Returns all words with supplied length */

	String[] wordsOfLength(int length);

	/* 6. Add a word */

	void addWord(String word);

	/* 7. delete a word */

	boolean deleteWord(String word);

	/* 8. Return the first word (sorted) */

	String firstWord();

	/* 9. Return the last word (sorted) */

	String lastWord();

	/* 10. Return the occurrences of supplied word */

	int wordOccurrences(String word);

	/* 11. Return true if the supplied word is present */

	boolean findWord(String word);
}
