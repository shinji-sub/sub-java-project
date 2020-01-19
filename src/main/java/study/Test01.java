// BufferedReader 기본 사용방법 및 사용

package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test01 {
public static void main(String[] args) throws Exception{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  int[] arr = new int [5]; // String = 1 2 3 4 5
  arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::pasersInt).toArrays;
  System.out.println(arr);
}
}
