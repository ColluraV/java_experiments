package streams;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.junit.jupiter.api.DisplayNameGenerator.Standard;

public class StatsFileWords implements StreamWords {

	StatsFileWords(String File) throws IOException{
		File file=new File(File);
		Path path2=file.toPath();
		//salva tutte le righe in una lista
		List<String> lsWords=Files.readAllLines(path2);
		
		//salva le righe in uno stream
		@SuppressWarnings("unchecked")
		List<String> strWords=(List<String>) Files.lines(path2, StandardCharsets.UTF_8);
	}
	
	
	
	@Override
	public long countAll() throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] words() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count(String parola) throws IOException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String wordGreater() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String[] wordsWithLenghtLessThen(int numChar) throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String wordsJoined() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
