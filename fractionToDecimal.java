/*难点：如何识别循环体？

解决方法：用一个HashMap记录每一个余数，当出现重复的余数时，那么将会进入循环，两个重复余数之间的部分就是循环体。

示例：1/13=0.076923076923076923...，当小数部分第二次出现0时，就意味着开始了循环，那么需要把076923用括号括起来，结果为0.(076923)。

涉及技巧：1）在不断相除的过程中，把余数乘以10再进行下一次相除，保证一直是整数相除；2）HashMap的key和value分别是<当前余数, 对应结果下标>，这样获取076923时就可根据value值来找。

注意点1：考虑正负数，先判断符号，然后都转化为正数；

注意点2：考虑溢出，如果输入为Integer.MIN_VALUE，取绝对值后会溢出。*/
public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        if (denominator == 0) return "";
    	String res = "";
    	//如果结果为负数 
        if ((numerator > 0)^(denominator > 0)) res += "-";
        //下面要把两个数都转为正数，为避免溢出，int转为long
        long n = numerator, d = denominator;
        n = Math.abs(n);
        d = Math.abs(d);
        //结果的整数部分  
        long ans = n/d;
        res += String.valueOf(ans);       
        long rem = n%d*10;
        //如果能够整除，返回结果  
        if (rem == 0) return res;
        //结果的小数部分
        Map<Long, Integer> map = new HashMap<Long, Integer>();
        res += ".";
        while (rem != 0) {
        	//如果前面已经出现过该余数，那么将会开始循环  
        	if (map.containsKey(rem)) {
        		int cur = map.get(rem);//循环体开始的位置  
        		String part1 = res.substring(0, cur);
        		String part2 = res.substring(cur);
        	    return part1 + "(" + part2 + ")";
        	}
        	//继续往下除 
        	map.put(rem, res.length());
        	ans = rem/d;
        	res += String.valueOf(ans);
        	rem = rem%d*10;
        }
        return res;
    }
}