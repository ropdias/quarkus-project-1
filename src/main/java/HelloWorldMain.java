import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class HelloWorldMain implements QuarkusApplication {
  @Override
  public int run(String... args) throws Exception {
    System.out.println("Hello " + args[1]);
    return 0;
  }
}
