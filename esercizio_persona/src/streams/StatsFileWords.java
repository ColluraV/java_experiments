package streams;

import static org.junit.jupiter.api.DynamicTest.stream;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayNameGenerator.Standard;

public class StatsFileWords implements StreamWords {
	List<String> lsWords;
	
	
	@SuppressWarnings("unchecked")
	public  void fileReader(String File) throws IOException {
		File file=new File(File);
		Path path2=file.toPath();

		//salva tutte le righe in una lista
		//lsWords=Files.readAllLines(path2);
		
		//salva le righe in uno stream
		lsWords=(List<String>) Files.lines(path2, StandardCharsets.UTF_8)						
									.flatMap(line -> Stream.of(line.split(" +")))
						            .filter(w->!w.isEmpty())
						            .map((w)->w.toUpperCase())
						            .sorted()
						            .collect(Collectors.toList());

	}



	@Override
	/* 1. Returns the count of words in the file */
	public long countAll() throws IOException {
				return lsWords.stream()
						.count();
	}

	@Override
	/* 2. Returns all words in the file */
	public String[] words() throws IOException {
		return lsWords
	            .toArray(String[]::new);
	}

	@Override
	/* 3. Returns the number of occurrences of a word */
	public long count(String parola) throws IOException {
		return lsWords.stream().filter(word-> word.equals(parola))
	            .count();
	}

	@Override
	/* 4. Returns the greater word (alphabetically greater) */
	public String wordGreater() throws IOException {
		Optional<String> word = lsWords.stream().findFirst();
		String first=word.toString();
		return first;
	}

	@Override
	/* 5. Returns all words with less then n characters */
	public String[] wordsWithLenghtLessThen(int numChar) throws IOException {
		return  lsWords.stream()
						.filter(word -> word.length() < numChar)
						.toArray(String[]::new);
	}

	@Override
	/* 6. Returns a string with all file words concatenated */
	public String wordsJoined() throws IOException {
		return lsWords.stream().collect(Collectors.joining());
	}

}
