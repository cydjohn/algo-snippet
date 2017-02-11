package airbnb;
/*Skype：（两道题我都没见过！应该是刷面经刷的不够～）
1. 设计一个银行帐户系统，实现： 
存钱（帐户id，存钱数目，日期），
取钱（帐户id，存钱数目，日期），
以及查账（帐户id，起始日期，结束日期）： 只需要返回两个数值，一个是起始日期的balance，一个是结束日期的balance。
描述就是这么多，剩下的自己发挥。钱的类型用integer，日期什么的自定义，我直接拿了integer.
每个帐户的balance是用hashmap实现的 key是日起，value是balance.
存取的时候更新hashmap，稍微处理了简单的corner case：比如取钱时账户余额不足。
查账的时候,对于不存在hashmap里面的日期，向前找map内存在的最接近的日期，对应的value值就是目前balance.
*/
class bankSystem {
	Map<Integer, User> users = new HashMap<>();
	class User {
		int id;
		int balance;
		Map<Integer, Integer> history;
		public User(int id){
			this.id = id;
			balance = 0;
			history = new HashMap<>();
			history.put(0, 0);//防止在search中找不到日期导致死循环
		} 
	}
	public boolean put(int id, int amount, int date) {
		if (!users.containsKey(id)) return false;
		User cur = users.get(id);
		cur.balance += amount;
		cur.history.put(date, cur.balance);
		return true;
	}
	public boolean get(int id, int amount, int date) {
		if (!users.containsKey(id) || users.get(id).balance < amount) return false;
		User cur = users.get(id);
		cur.balance -= amount;
		cur.history.put(date, cur.balance);
		return true;
	}
	public int[] search(int id, int start, int end) {
		if (!users.containsKey(id)) return int[]{-1, -1};
		User cur = users.get(id);
		int[] res = new int[2];
		while (!cur.history.containsKey(start)) start--;
		res[0] = cur.history.get(start);
		while (!cur.history.containsKey(end)) end--;
		res[1] = cur.history.get(end);
		return res;
	}
}