package DesignPatternExercise;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;

public final class Main {

  public static void main(String[] args) {
    UdacisearchClient client =
//        new UdacisearchClient(
//            "CatFacts LLC",
//            17,
//            8000,
//            5,
//            Instant.now(),
//            Duration.ofDays(180),
//            ZoneId.of("America/Los_Angeles"),
//            "555 Meowmers Ln, Riverside, CA 92501");
            new UdacisearchClient.Builder()
                    .setName("CatFacts LLC")
                    .setId(17)
                    .setQuarterlyBudget(8000)
                    .setNumEmployees(5)
                    .setContractStart(Instant.now())
                    .setContractLength(Duration.ofDays(180))
                    .setTimeZone(ZoneId.of("America/Los_Angeles"))
                    .setBillingAddress("555 Meowmers Ln, Riverside, CA 92501")
                    .build();

    System.out.println(client);
  }
}
