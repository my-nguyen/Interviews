## Minimize Array Cost

Given an array of n positive integers, assuming 0-based indexing, its cost is  
Sum (a[i] - ar[i-1])^2

Insert any integer at any location of the array such that the cost of the array is minimized. Find the minimum possible cost of the array after inserting exactly one element.

### Example
a = [1, 3, 5, 2, 10]

The cost of the array before insertion = (1-3)^2 + (3-5)^2 + (5-2)^2 + (2-10)^2 = 81

Two of the many scenarios are shown below:
* Insert 4 between 3 and 5, cost of array = (1-3)^2 + (3-4)^2 + (4-5)^2 + (5-2)^2 + (2-10)^2 = 79
* Insert 6 between 2 and 10, cost of array = (1-3)^2 + (3-5)^2 + (5-2)^2 + (2-6)^2 + (6-10)^2 = 49

It can be proven that 49 is the minimum cost possible. Return 49.

### Function description
getMinimumCost has the following parameter
* int arr[n]: array of integers

### Return
long_int: the minimum possible cost of the array after inserting one element

### Constraints
* 2 <= n <= 10^4
* 1 <= arr[i] <= 10^5

### Input Format For Custom Testing
* The first line contains an integer, n, the number of elements in the array arr
* Each line i of the n subsequent lines (where 0 <= i < n) contains an integer arr[i]

### Case 0
### Input
<pre>
STDIN        FUNCTION
-----        --------
4     ->     n = 4
4     ->     arr = [4, 7, 1, 4]
7
1
4
</pre>

### Output
36

### Explanation
* The cost of the array before insertion = (4-7)^2 + (7-1)^2 + (1-4)^2 = 54
* Insert 5 between 4 and 7, cost = (4-5)^2 + (5-7)^2 + (7-1)^2 + (1-4)^2 = 50
* Insert 4 between 7 and 1, cost = (4-7)^2 + (7-4)^2 + (4-1)^2 + (1-4)^2 = 36

### Case 1
### Input
<pre>
STDIN        FUNCTION
-----        --------
3     ->     n = 3
4     ->     arr = [4, 7, 7]
7
7
</pre>

### Output
5

### Explanation
* The cost of the array before insertion = (4-7)^2 + (7-7)^2 = 9
* Insert 5 between 4 and 7, cost = (4-5)^2 + (5-7)^2 + (7-7)^2 = 5
* Insert 6 between 4 and 7, cost = (4-6)^2 + (6-7)^2 + (7-7)^2 = 5
