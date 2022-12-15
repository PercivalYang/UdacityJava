import java.io.BufferedReader;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public final class MultiFileReader {

  private final List<BufferedReader> readers;

  public MultiFileReader(List<Path> paths) {
    // TODO: Build the List of BufferedReaders
  }

  public List<BufferedReader> getReaders() {
    return Collections.unmodifiableList(readers);
  }

  @Override
  public void close() {
    // TODO: Close all the readers.
  }
}
