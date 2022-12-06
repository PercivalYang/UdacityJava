package DesignPatternExercise;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public final class Main {

  public static void main(String[] args) {
    UdacisearchClient client =
        new UdacisearchClient(
            "CatFacts LLC",
            17,
            8000,
            5,
            Instant.now(),
            Duration.ofDays(180),
            ZoneId.of("America/Los_Angeles"),
            "555 Meowmers Ln, Riverside, CA 92501");

    System.out.println(client);
  }
}
