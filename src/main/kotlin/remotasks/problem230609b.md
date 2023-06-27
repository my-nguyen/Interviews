## Matrix Traversal

Given a 4 x 4 matrix mat, the initial energy is 100. The task is to reach the last row of the matrix with the maximum possible energy left.

The matrix can be traversed in the following way:
* Start with any cell in the first row.
* In each move, traverse from cell (i, j) of the ith row and jth column to any existing cell out of (i+1, j-1), (i+1, j) or (i+1, j+1)
* Finish the traversal in the last row.

After stepping on a cell (i, j), energy decreases by mat[i][j] units. Find the maximum possible energy left at the end of the traversal.

Note: the final energy can be negative.

### Example
<pre>
mat[][] = [[10, 20, 30, 40],
           [60, 50, 20, 80],
           [10, 10, 10, 10],
           [60, 50, 60, 50]]
</pre>

Possible paths (0-based index)
* (0, 0) - (1, 1) - (2, 2) - (3, 3). Energy left = 100 - 10 - 50 - 10 - 50 = -20
* (0, 1) - (1, 2) - (2, 2) - (3, 2). Energy left = 100 - 20 - 20 - 10 - 50 = 0

It can be proven that 0 is the maximum energy possible at the end of the traversal. so return 0.

### Function Description
Complete the function maxEnergy in the editor below

maxEnergy has the following parameters
* int mat[4][4]: a matrix of integers

### Returns
int: the maximum possible energy at the end of the traversal

### Constraints
0 <= mat[i][j] < 100

### Input Format For Custom Testing
* The first line contains an integer, n, denoting the number of rows in the matrix, mat (which is always 4)
* The second line contains an integer, m, denoting the number of columns in the matrix, mat (which is always 4)
* Each of the next 4 lines contains 4 space-separated integers denoting the 4 rows of our matrix, mat

### Case 0
### Input
<pre>
STDIN        FUNCTION
-----        --------
4     ->     mat[][] size n = 4
4     ->     mat[i] size m = 4
 4  6 14 21
17  0  5  5
 4 41 22  3
 2 51  6  0
</pre>

### Output
90

### Explanation
Possible paths
* (0, 0) - (1, 1) - (2, 2) - (3, 3).
* (0, 0) - (1, 1) - (2, 0) - (3, 0).

For the first path, energy left = 100 - 4 - 0 - 22 - 0 = 74  
For the second path, energy left = 100 - 4 - 0 - 4 - 2 = 90.  
It can be proven that 90 is the maximum energy possible at the end of the traversal.

### Case 1
### Input
<pre>
STDIN        FUNCTION
-----        --------
4     ->     mat[][] size n = 4
4     ->     mat[i] size m = 4
41 22 56 84
22 51  1 20
 5  7 18 19
11 22  3 15
</pre>

### Output
67

### Explanation
Possible paths
* (0, 1) - (1, 0) - (2, 0) - (3, 0).
* (0, 1) - (1, 2) - (2, 1) - (3, 2).

For the first path, energy left = 100 - 22 - 22 - 5 - 11 = 40  
For the second path, energy left = 100 - 22 - 1 - 7 - 3 = 67  
It can be proven that 67 is the maximum energy possible at the end of the traversal.