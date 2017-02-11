//new version:
//结果数组的顺序为正
public class Solution {
    public String multiply(String num1, String num2) {
        int[] res = new int[num1.length() + num2.length()];
        for (int i = num1.length()-1; i >= 0; i--) {
            for (int j = num2.length()-1; j >= 0; j--) {
                int idx = i + j + 1;
                res[idx] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                res[idx-1] += res[idx] / 10;
                res[idx] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        //跳过leading zeros，但是不能跳过最后一个0，因为0*0=0，这个0必须输出
        while (i < res.length-1 && res[i] == 0) i++;
        while (i < res.length) sb.append(res[i++]);
        return sb.toString();
    }
}


//old version
//结果数组的顺序为负
public class Solution {
    public String multiply(String num1, String num2) {
        int l1 = num1.length()-1, l2 = num2.length()-1;
        int[] res = new int[l1+l2+2];//进位
        for (int i = l1; i >= 0; i--) {
            for (int j = l2; j >= 0; j--) {
                int idx = l1 + l2 - i - j;
                res[idx] += (num1.charAt(i)-'0') * (num2.charAt(j)-'0');
                res[idx+1] += res[idx]/10;//进位
                res[idx] %= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = res.length-1; i >= 0; i--) {
            if (sb.length() == 0 && res[i] == 0 && i>0) continue;//如果第一位是未被赋值的则跳过，但不能跳过最后一位，因为i==0时sb还为空，说明结果应该是0，这个0需要输出
            sb.append(res[i]);
        }
        return sb.toString();
    }
}


