
import numpy as np
import matplotlib.pyplot as plt
import matplotlib.cm as cm
import os
# Input data files are available in the "../input/" directory.
# For example, running this (by clicking run or pressing Shift+Enter) will list the files in the input directory
 
import numpy as np
import random
from matplotlib import pyplot as plt
 
data1 = [random.gauss(15,10) for i in range(500)]
data2 = [random.gauss(5,5) for i in range(500)]
bins = np.arange(-60, 60, 2.5)
plt.xlim([min(data1+data2)-5, max(data1+data2)+5])
 
plt.hist(data1, bins=bins, alpha=0.3, label='class 1')
plt.hist(data2, bins=bins, alpha=0.3, label='class 2')
plt.title('Random Gaussian data')
plt.xlabel('variable X')
plt.ylabel('count')
plt.legend(loc='upper right')
 
 
plt.show()