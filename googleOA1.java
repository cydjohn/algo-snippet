public class Solution{
  /**
  * @param int 
  * @return 
  */
    public static int replaceAdjacentDigitToMax(int x) {
    int lastDigit = x % 10, leftPart = x / 10, rightPart = 0, tens = 1;
    int maxNum = Integer.MIN_VALUE;
    while (leftPart != 0) {
      int curDigit = leftPart % 10;
      leftPart /= 10;
      int roundUp = (int)(Math.ceil((lastDigit + curDigit)/2.0));
      int tempNum = (roundUp + leftPart * 10) * tens + rightPart;
      if (tempNum > maxNum) maxNum = tempNum;
      rightPart = lastDigit * tens + rightPart;
      lastDigit = curDigit;
      tens *= 10;
    }
    return maxNum;
   }
    public static void main(String []args){
        System.out.println(replaceAdjacentDigitToMax(623315));
    }
}

