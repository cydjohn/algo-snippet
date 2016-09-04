//Fenwick Tree O(logn) for each oparation
public class NumArray {
    int[] num;//Input array for whic prefix sum is evaluated.
    int[] sum;//Array that represents Binary Indexed Tree.
    int n;//No. of elements present in input array.   
    public NumArray(int[] nums) {
        n = nums.length;
        num = new int[n];
        sum = new int[n+1];
        for (int i = 0; i < nums.length; i++) { 
            update(i, nums[i]);// Store the actual values in BITree[] using update()
        }
    }

    public int lowbit(int i) {
        return (i & -i);
    }

    public void update(int i, int val) {
        int diff = val - num[i];
        num[i] = val;//change value in input array
        i += 1; // index in sum[] is 1 more than the index in num[]
        while (i <= n) {
            sum[i] += diff;
            i += lowbit(i);
        }
    }

    public int getSum(int i) {
        i += 1;
        int res = 0;
        while (i > 0) {
            res += sum[i];
            i -= lowbit(i);
        } 
        return res;
    }

    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i-1);//the ith element should be calculated in the range sum
    }
}

/*lowbit(x)为x的二进制表达式中最右边的1所对应的值。
比如，1234的二进制是0100 1101 0010  lowbit(1234)=2，在程序的实现中，
Lowbit(x)=x&-x;（为什么这样写呢？因为计算机内部采用补码表示，-x是x按位取反，尾数+1的结果）;
对于节点x，
为左子结点，则父结点的编号是x+lowbit(x)，
为右子结点，则父结点的编号是x-lowbit(x)*/
/*getSum(): 顺着结点i往左走，边走边往上爬，沿途经过的sum[i]所对应的长条不重复不遗漏的包含了所有需要累加的元素。
update(): 如果修改了一个num[i] ,那么从sum[i]往右走，边走边网上爬，沿途修改所有结点对应的c[i]即可。*/


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.update(1, 10);
// numArray.sumRange(1, 2);

//TLE O(n) for each operation
public class NumArray {
    int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length+1];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i-1] + nums[i-1];
        }
    }

    void update(int i, int val) {
        int diff = val - sumRange(i, i);
        for (int j = i+1; j < sum.length; j++) {
            sum[j] += diff;
        }
    }

    public int sumRange(int i, int j) {
        return sum[j+1] - sum[i];
    }
}