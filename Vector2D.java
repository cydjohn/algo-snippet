import java.io.*;
import java.util.*;
 
public class Solution {
  private List<List<Integer>> array;
  private int rowId;
  private int colId;
  private int numRows;
   
  public Solution(List<List<Integer>> array) {
    this.array = array;
    rowId = 0;
    colId = 0;
    numRows = array.size();
  }
   
  public boolean hasNext() {
    if (array == null || array.isEmpty()) {
      return false;
    }
     
    while (rowId < numRows && (array.get(rowId) == null || 
      array.get(rowId).isEmpty())) {
      rowId++;
    }
     
    return rowId < numRows;
  }
   
  public int next() {
    int ret = array.get(rowId).get(colId);
    colId++;
    if (colId == array.get(rowId).size()) {
      rowId++;
      colId = 0;
    }
     
    return ret;
  }
   
  public void remove() {
    List<Integer> listToRemove;
    int rowToRemove;
    int colToRemove;
     
    // Case 1: if the element to remove is the last element of the row
    if (colId == 0) {
      rowToRemove = rowId - 1;
      listToRemove = array.get(rowToRemove);
      colToRemove = listToRemove.size() - 1;       
      listToRemove.remove(colToRemove);
    } else { // Case 2: the element to remove is not the last element
      rowToRemove = rowId;
      listToRemove = array.get(rowToRemove);
      colToRemove = colId - 1;
      listToRemove.remove(colToRemove);
    }
     
    // If the list to remove has only one element, remove this list 
    if (listToRemove.isEmpty()) {
      array.remove(listToRemove);
      rowId--;
      numRows--;
    }
     
    // Update the colId, if colID == 0, the remove happends in the last list,
    // no remove is required
    if (colId != 0) {
      colId--;
    }
  }
   
  public static void main(String[] args) {
    List<List<Integer>> array = new ArrayList<>();
    List<Integer> row1 = new ArrayList<>();
    row1.add(1);
    row1.add(2);
    row1.add(3);
     
    array.add(row1);
     
    List<Integer> row3 = new ArrayList<>();
    array.add(row3);
     
    List<Integer> row2 = new ArrayList<>();
    row2.add(4);
    row2.add(5);
    array.add(row2);
     
    Solution sol = new Solution(array);
    while (sol.hasNext()) {
      int result = sol.next();
      System.out.println(result);
       
      if (result == 3) {
        sol.remove();
      }
    }
     
    System.out.println();
     
    for (List<Integer> row : array) {
      for (Integer elem : row) {
        System.out.println(elem);
      } 
    }
  }
}



//method2
public class Vector2D implements Iterator<Integer> {
    private Iterator<List<Integer>> i;
    private Iterator<Integer> j;

    public Vector2D(List<List<Integer>> vec2d) {
        i = vec2d.iterator();
    }

    public Integer next() {
        return j.next();
    }

    public boolean hasNext() {
        while ((j == null || !j.hasNext()) && i.hasNext())
            j = i.next().iterator();
        return j != null && j.hasNext(); //j可能还没有初始化，所以要判断是否为null
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */

