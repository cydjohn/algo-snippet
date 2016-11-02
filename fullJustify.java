/*
给定一个字符串数组以及规定长度，按规则将其分组输出；

题目本身是不难的，主要是规则繁杂：

首先，输出以是否为末行分为两类；
对于非末行单词组，又以其包含的单词个数分为两类，一是单个单词，二是多个单词；
第一步，讨论非末行单词组合： 
（1）若该组只包含一个单词，规定其左对齐，不足指定长度以空格填充； 
（2）若该组包含count个单词，那么它有（count-1）个间隔，每个间隔放置一个空格；此时，求出不足指定长度需要的额外空格数目，extraSpace，每个单词间隔填充extra/（count-1）个空格；此时，若不整除那么前extra%(count-1)个间隔再次填充一个空格；

第二步，讨论末行单词组合： 
（1）若只有一个单词，左对齐，不足指定长度以空格填充； 
（2）若该组有count个单词，那么它有（count-1）个间隔，每个间隔放置一个空格；不足指定长度，末尾填充；
*/
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
    	List<String> res = new ArrayList();
        if (words == null || words.length == 0) return res;
        int sz = words.length;
        List<String> tmp = new ArrayList();
        /*sumLen记录当前字符串长度，count记录包含的单词个数*/
        int curLen = 0, cnt = 0;
        for (int i = 0; i < words.length; i++) {
        	/*判断是否可以添加一个字符串*/
        	if (curLen + words[i].length() + cnt <= maxWidth) {
        		/*满足要求，单词个数增一，保存*/
        		cnt++;
        		curLen += words[i].length();
        		tmp.add(words[i]);
        		continue;
        	} else {
        		/*只有一个单词，左对齐*/
        		if (cnt == 1) {
        			String str = tmp.get(0);
        			while (str.length() < maxWidth) str += " ";
        			res.add(str);
        		} else {
        			String str = "";
        			/*计算多余的空格总数，每个间隔至少一个空格*/
        			int extraSpace = maxWidth - curLen - cnt + 1;
        			/*每个间隔需再增加的间隔*/
        			int everySpace = extraSpace / (cnt - 1);
        			/*前间隔需要额外放置一个空格的间隔数*/
        			int frontSpace = extraSpace % (cnt - 1);
        			for (int k = 0; k < cnt - 1; k++) {
        				int total = everySpace;
        				while (total >= 0) {//原来有一个分隔的空格也需要加上
        					tmp.set(k, tmp.get(k) + " ");
        					total--;
        				}
        			}
        			/*前frontSpace个间隔需要再放一个空格*/
        			for (int k = 0; k < frontSpace; k++) {
        				tmp.set(k, tmp.get(k) + " ");
        			}
        			/*连接这些字符串*/
        			for (String t : tmp) {
        				str += t;
        			}
        			res.add(str);
        		}
        		tmp.clear();
        	    cnt = 0; curLen = 0;
        	    i--;
        	}
        }
        /*处理最后一组,也就是尾行*/
         /*只有一个单词，左对齐*/
        if (cnt == 1) {
        	String str = tmp.get(0);
        	while (str.length() < maxWidth) str += " ";
        	res.add(str);
        } else {
        	String str = "";
        	/*末行的每个单词间放一个空格，其余空格放在尾部*/
        	for (int k = 0; k < cnt - 1; k++) {
        		str += tmp.get(k) + " ";
        	}
        	str += tmp.get(cnt - 1);
        	while (str.length() < maxWidth) {
        		str += " ";
        	}
        	res.add(str);
        }
        return res;
    }
}