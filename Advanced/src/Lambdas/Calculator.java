package Lambdas;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.function.BinaryOperator;
public final class Calculator {
  Map<String, BinaryOperator<Integer>> symbolsToOperator = new HashMap<>();
  // TODO: Fill this class in.
    public void registerOperation(String symbol, BinaryOperator<Integer> operator){
      // .strip()去除字符串开头和结尾的空格
      symbolsToOperator.put(symbol.strip(), operator);
    }
    public int calculate(int a, String symbol, int b){
      return symbolsToOperator.get(symbol).apply(a,b);
    }
}
