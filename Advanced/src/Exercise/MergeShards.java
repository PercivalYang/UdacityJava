package Exercise;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public final class MergeShards {
  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
      System.out.println("Usage: MergeShards [input folder] [output file]");
      return;
    }

    List<Path> inputs = Files.walk(Path.of(args[0]), 1).skip(1).collect(Collectors.toList());
    List<BufferedReader> readers = new ArrayList<>(inputs.size());
    Path outputPath = Path.of(args[1]);

    // TODO: Inside a try-finally block, create the List of BufferedReaders: one for each "input"
    //       Path. Without modifying the shard files, merge them together into a single text file
    //       whose location is specified by the "outputPath".
    //
    //       To do this, you should put words in a PriorityQueue<WordEntry>, but make sure the
    //       priority queue never contains more entries than there are input files. The whole point
    //       of doing a distributed merge sort is that there are too many words to fit into memory!
    //
    //       In the "finally" part of the try-finally block, make sure to close all the
    //       BufferedReaders.
    try {
      for (Path path:inputs){
        readers.add(Files.newBufferedReader(path, StandardCharsets.UTF_8));
      }
    }catch (IOException e){
      e.printStackTrace();
    }
    try(BufferedWriter writer = Files.newBufferedWriter(outputPath,StandardCharsets.UTF_8)) {
      PriorityQueue<WordEntry> queue = new PriorityQueue<>();
      for (BufferedReader reader:readers){
        WordEntry wordEntry = new WordEntry(reader.readLine(),reader);
        queue.offer(wordEntry);
      }
      while (!queue.isEmpty()) {
        WordEntry minWord = queue.poll();
        String minStr = minWord.word;
        BufferedReader reader = minWord.reader;
        String nextStr;
        if ((nextStr=reader.readLine())!=null) {
          queue.offer(new WordEntry(nextStr, reader));
        }
        writer.write(minStr);
        writer.newLine();
      }
    }catch (IOException e){
      e.printStackTrace();
    }finally {
      for (BufferedReader reader:readers){
        reader.close();
      }
    }
  }

  private static final class WordEntry implements Comparable<WordEntry> {
    private final String word;
    private final BufferedReader reader;

    private WordEntry(String word, BufferedReader reader) {
      this.word = Objects.requireNonNull(word);
      this.reader = Objects.requireNonNull(reader);
    }

    @Override
    public int compareTo(WordEntry other) {
      return word.compareTo(other.word);
    }
  }
}
