## I. Maximum Distinct

Consider two arrays a and b where each consists of n integers. In one operation:
* Select two indices i and j (0 <= i, j < n)
* Swap integers a[i] and b[j]

This operation can be performed at most k times.

Find the maximum number of distinct elements that can be achieved in array a after at most k operations.

### Example
n = 5  
a = [2,3,3,2,2]  
b = [1,3,2,4,1]  
k = 2

To get the maximum number of distinct elements in array a:
* Select i = 2, j = 0. Swap a[2] and b[0]. Now a = [2,3,1,2,2] and b = [3,3,2,4,1]
* Select i = 4, j = 3. Swap a[4] and b[3]. Now a = [2,3,1,2,4] and b = [3,3,2,2,1]

Now a = [2,3,1,2,4] contains 4 distinct elements. There can never be more than 4 distinct elements in a.

### Functional description
Complete the function getMaximumDistinctCount in the editor below.

getMaximumDistinctCount has the following parameters
* int a[n]: an array of integers
* int b[n]: an array of integers
* int k: the maximum number of operations

### Returns
int: the maximum number of distinct elements in a after at most k operations

### Constraints
* 1 <= n, k <= 10^5
* 1 <= a[i], b[j] <= 10^9

### Input Format For Custom Testing
* The first line contains an integer, n, the number of elements in a.
* Each line i of the n subsequent lines (where 0 <= i < n) contains an integer, a[i]
* The next line contains an integer, n, the number of elements in b.
* Each line i of the n subsequent lines (where 0 <= i < n) contains an integer, b[i]
* The last line contains an integer, k.

### Case 0
### Input
<pre>
STDIN        FUNCTION
-----        --------
5     ->     n = 5
1     ->     a = [1, 1, 4, 5, 5]
1
4
5
5
5     ->     n = 5
4     ->     a = [4, 4, 3, 1, 5]
4
3
1
5
2     ->     k = 2
</pre>

### Output
4

### Explanation
* swap a[2] and b[3] -> a = [1,1,3,5,5] and b = [5,4,4,4,1]
* swap a[0] and b[1] -> a = [4,1,3,5,5] and b = [5,1,4,4,1]

### Case 1
### Input
<pre>
STDIN        FUNCTION
-----        --------
3     ->     n = 3
1     ->     a = [1, 2, 3]
2
3
3     ->     n = 3
4     ->     a = [4, 5, 6]
5
6
5     ->     k = 5
</pre>

### Output
3

### Explanation
All elements in a are distinct