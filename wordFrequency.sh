# Read from the file words.txt and output the word frequency list to stdout.
# tr -s: 使用指定字符串替换出现一次或者连续出现的目标字符串（把一个或多个连续空格用换行符代替）
# sort: 将单词从小到大排序
# uniq -c: uniq用来对连续出现的行去重，-c参数为计数
# sort -rn: -r 倒序排列， -n 按照数值大小排序
# awk '{ print $2, $1 }': 格式化输出，将每一行的内容用空格分隔成若干部分，$i为第i个部分。
cat words.txt | tr -s ' ' '\n' | sort | uniq -c | sort -rn | awk '{print $2, $1}'