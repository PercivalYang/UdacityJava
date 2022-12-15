import javax.swing.plaf.basic.BasicTreeUI;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public final class TestRunner {

  private static final List<Class<?>> TESTS = List.of(CalculatorTest.class);

  public static void main(String[] args) throws Exception {

    List<String> passed = new ArrayList<>();
    List<String> failed = new ArrayList<>();

    for (Class<?> klass : TESTS) {
      // TODO: For each test class "klass", do the following:
      //        1. Ensure the class implements the UnitTest interface.
      //        2. Create an instance of the class and cast it to UnitTest.
      if (!UnitTest.class.isAssignableFrom(klass)){
        throw new IllegalArgumentException("Class " + klass.getName() + " must implements UniTest!");
      }
      CalculatorTest test = (CalculatorTest) klass.getConstructor().newInstance();

      // TODO: For each method that is annotated with @Test:
      //        1. Call beforeEachTest()
      //        2. Invoke the method annotated with @Test
      //        3. Call afterEachTest()
      //        4. Record the test results by adding getTestName(...) to either the "passed" list
      //           of the "failed" list.
      for (Method method:klass.getMethods()){
        if (method.getAnnotation(Test.class) != null) {
          try {
            test.beforeEachTest();
            method.invoke(test);
            test.afterEachTest();
            passed.add(getTestName(klass,method));
          }catch (Throwable throwable){
            failed.add(getTestName(klass,method));
          }
        }
      }
    }

    System.out.println("Passed tests: " + passed);
    System.out.println("FAILED tests: " + failed);
  }

  private static String getTestName(Class<?> klass, Method method) {
    return klass.getName() + "#" + method.getName();
  }
}
