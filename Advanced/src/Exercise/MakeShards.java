package Exercise;

import javax.xml.stream.StreamFilter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStream;
import java.io.Reader;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.AlgorithmConstraints;
import java.text.CollationElementIterator;
import java.util.*;
import java.util.stream.Stream;

public final class MakeShards {
    private static final int SHARD_SIZE = 100;

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.out.println("Usage: MakeShards [input file] [output folder]");
            return;
        }

        Path input = Path.of(args[0]);
        if (!Files.exists(Path.of(args[1]))) {
            Files.createDirectory(Path.of(args[1]));
        }
        Path outputFolder = Path.of(args[1]);


        // TODO: Read the unsorted words from the "input" Path, line by line. Write the input words to
        //       many shard files. Each shard file should contain at most SHARD_SIZE words, in sorted
        //       order. All the words should be accounted for in the output shard files; you should not
        //       skip any words. Write the shard files in the newly created "outputFolder", using the
        //       getOutputFileName(int) method to name the individual shard files.
        BufferedReader reader = Files.newBufferedReader(input, StandardCharsets.UTF_8);
        List<String> wordList = new ArrayList<>(SHARD_SIZE);
        String word = reader.readLine();
        int shardNum = 0;
        while (word != null) {
            for (int i = 0; i < SHARD_SIZE; i++) {
                wordList.add(word);
                word = reader.readLine();
            }
            Path outputFile = Path.of(outputFolder.toString(), getOutputFileName(++shardNum));
            wordList.sort(String::compareTo);
            BufferedWriter writer = Files.newBufferedWriter(outputFile, StandardCharsets.UTF_8);
            for (int j = 0; j<SHARD_SIZE;j++){
                writer.write(wordList.get(j));
                if (j<SHARD_SIZE-1)
                    writer.newLine();
            }
            writer.close();
        }
        reader.close();
    }

    private static String getOutputFileName(int shardNum) {
        return String.format("shard%02d.txt", shardNum);
    }
}
