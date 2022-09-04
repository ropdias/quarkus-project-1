package org.acme;

import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import java.util.Scanner;

@QuarkusMain
public class Main implements QuarkusApplication {
  @Override
  public int run(String... args) throws Exception {
    Scanner reader = new Scanner(System.in); // Reading from System.in
    System.out.println("Enter CEP: ");
    int n = reader.nextInt();
    System.out.println("CEP to make a REST request: " + n);
    reader.close(); // once finished
    return 0;
  }
}
