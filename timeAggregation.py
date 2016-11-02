# Enter your code here. Read input from STDIN. Print output to STDOUT.
# need to check if in range
import sys
import collections

def validTimeRange (curTime, timeRange):
    minYear = int(timeRange[0][:4])
    minMonth = int(timeRange[0][-2:])
    maxYear = int(timeRange[1][:4])
    maxMonth = int(timeRange[1][-2:])
    curYear = int(curTime[:4])
    curMonth  = int(curTime[-2:])
    if (curYear < minYear or curYear > maxYear or 
        (curYear == minYear and curMonth < minMonth) or 
        (curYear == maxYear and curMonth >= maxMonth)):
        return False 
    else:
        return True
    
    
def splitWithOptionalSpace (curLine, nextLine):
    engagement_index = 11
    if (nextLine[11] == ' '):
        engagement_index += 1
    engagement = ''
    while(nextLine[engagement_index] != ','):
        engagement += nextLine[engagement_index]
        engagement_index += 1
    curLine.append(engagement)
    count_index = engagement_index + 1
    if (nextLine[count_index] == ' '):
        count_index += 1
    count = ''
    while(nextLine[count_index] != '\n'):
        count += nextLine[count_index]
        count_index += 1
    curLine.append(count)
    
    
    
timeRange = sys.stdin.readline().split(', ')

sys.stdin.readline()

nextLine = sys.stdin.readline()
# string : {}
# {} is string : int
ret = {}
while (nextLine != ''):
    curLine = [nextLine[:10]]
    # deal with fields seperated by optional space 
    splitWithOptionalSpace (curLine, nextLine)
    # test if time is in valid range
    curTime = curLine[0][:7]
    if (validTimeRange(curTime, timeRange) is False):
        nextLine = sys.stdin.readline()
        continue
    # aggregate one line to the structure we want
    if curTime not in ret:
        ret[curTime] = {curLine[1] : int(curLine[2])}
    else:
        if curLine[1] in ret[curTime]:
            ret[curTime][curLine[1]] += int(curLine[2])
        else:
            ret[curTime][curLine[1]] = int(curLine[2])
    
    nextLine = sys.stdin.readline()

# format output
for entry in sorted(ret.items(), key=lambda x: x[0], reverse=True):
    toPrint = entry[0] + ', '
    for subEntry in sorted(entry[1].items(), key=lambda x: x[0], reverse=True):
        toPrint += subEntry[0] + ', ' + str(subEntry[1]) + ', '
    sys.stdout.write(toPrint[:-2] + '\n')