import java.util.concurrent.CompletableFuture;

public class CompletableFutureExample {
    public static void main(String[] args) {
        CompletableFuture<String> future =
                CompletableFuture.supplyAsync(() -> "Hello from background task")
                        .thenApply(String::toUpperCase);

        System.out.println(future.join());
    }
}
