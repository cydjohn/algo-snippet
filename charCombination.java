import java.io.*;
import java.util.*;


public class Solution {
  public static class TrieNode {
    String word = null;
    TrieNode[] next = new TrieNode[26];
  }
  static List<String> res = new ArrayList<>();
  public static List<String> charCombination(char[] arr, List<String> strs) {
    TrieNode root = buildTrie(strs);
    Map<Integer, Integer> map = buildMap(arr);
    dfs(root, map);
    return res;
  }
  private static void dfs(TrieNode root, Map<Integer, Integer> map) {
    if (root.word != null) {
      res.add(root.word);
    }
    for (int i = 0; i < 26; i++) {
      if (root.next[i] == null) continue;
      if (!map.containsKey(i) || map.get(i) == 0) continue;
      map.put(i, map.get(i) - 1);
      dfs(root.next[i], map);
      map.put(i, map.get(i) + 1);
    }
  }
  private static TrieNode buildTrie(List<String> strs) {
    TrieNode root = new TrieNode();
    for (String s : strs) {
      TrieNode p = root;
      for (char c : s.toCharArray()) {
        if (p.next[c - 'A'] == null) {
          p.next[c - 'A'] = new TrieNode();
        }
        p = p.next[c - 'A'];
      }
      p.word = s;
    }
    return root;
  }
  private static Map<Integer, Integer> buildMap(char[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (char a : arr) {
      if (!map.containsKey(a - 'A')) {
        map.put(a - 'A', 1);
      } else {
        map.put(a - 'A', map.get(a - 'A') + 1);
      }
    }
    return map;
  }
  public static void main(String[] args) {
    char[] arr = {'A', 'B', 'C', 'A'};
    List<String> strs = Arrays.asList(new String[]{"A", "AA", "BA", "AAA"});
    List<String> res = charCombination(arr, strs);
    for (String r : res) {
       System.out.println(r);
    }
  }
}

