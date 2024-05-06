package streams;

import java.io.File;
import java.io.IOException;
import java.lang.module.ModuleDescriptor.Builder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTwoFiles implements WordsTwoFiles{
	Stream<String> strWords1;
	Stream<String> strWords2;
	Stream<String> concStream;
	


	public StreamTwoFiles(String fileName1 , String fileName2 ) throws IOException {
		
		FileReader(fileName1, fileName2);
	
	}

	private void FileReader(String fileName1, String fileName2) throws IOException {
		File file1=new File(fileName1);
		Path path1=file1.toPath();
		
		File file2=new File(fileName2);
		Path path2=file2.toPath();
		
		strWords1 = Files.lines(path1, StandardCharsets.UTF_8)						
		.flatMap(line -> Stream.of(line.split(" +")))
        .filter(w->!w.isEmpty())
        .map((w)->w.toUpperCase())
        .sorted();
		
		strWords2=Files.lines(path2, StandardCharsets.UTF_8)						
		.flatMap(line -> Stream.of(line.split(" +")))
        .filter(w->!w.isEmpty())
        .map((w)->w.toUpperCase())
        .sorted();
		
		concStream=Stream.concat(strWords1, strWords2);
		
	}

	@Override
	public long countWords() {
		return concStream.count();
	}

	@Override
	public String[] words() {
		 String[] words= concStream.collect(Collectors.toList()).toArray(String[]::new);
		 return words;
	}

	@Override
	public String wordsAsString(String delimiter) {
		return concStream.collect(Collectors.joining(delimiter));
	}

	@Override
	public String[] wordsNoDuplicates() {
		return concStream.distinct().collect(Collectors.toList())
				.toArray(String[]::new);
	}

	@Override
	public String[] wordsOfLength(int length) {
		
		return 	concStream.filter(word -> word.length() == length)
				.collect(Collectors.toList())
				.toArray(String[]::new);
	}

	@Override
	public void addWord(String word) {
		 Stream.Builder<String> builder = Stream.builder();
		 builder.add(word);
		 concStream.forEach(builder::add);
		 concStream = builder.build();
	}

	@Override
	public boolean deleteWord(String word) {
		concStream.filter(s -> !s.equals(word))
	    .collect(Collectors.toList());
		return true;
	}

	@Override
	public String firstWord() {
		
		return concStream.findFirst().orElse("lo stream è vuoto");
	}

	@Override
	public String lastWord() {

		return 	concStream.reduce((primo, secondo) -> secondo)
			    .orElse("stream vuoto");
	}

	@Override
	public int wordOccurrences(String word) {
		return (int) concStream.filter(parola-> parola.equals(word))
        .count();
	}

	@Override
	public boolean findWord(String word) {
		String wordPresence = concStream.distinct().filter(parola-> parola.equals(word)).collect(Collectors.joining());
			if (wordPresence.contains(word)) {
				return true;
			}	
		
		return false;

	
	}
}
