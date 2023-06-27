package remotasks;

import java.util.List;

public class timed230609b {
    public static int maxEnergy(List<List<Integer>> mat) {
        /* for (int i = 0; i < 4; i++)
            mat.get(2).add(i, mat.get(2).get(i) + minFromRow(mat.get(3), i));
        for (in i = 0; i < 4; i++)
            mat.get(1).add(i, mat.get(1).get(i) + minFromRow(mat.get(2), i)); */

        // start from the second to last row and iterate backward to the top row
        for (int i = 2; i >= 0; i--) {
            for (int j = 0; j < 4; j++) {
                // for each cell in the current row, the minimum value is the sum of the cell value and the minimum
                // you can get from the next row based on the current cell position/column
                mat.get(i).set(j, mat.get(i).get(j) + minFromRow(mat.get(i+1), j));
            }
        }
        int min = mat.get(0).get(0);
        for (int i = 1; i < 4; i++) {
            min = Math.min(min, mat.get(0).get(i));
        }
        return 100 - min;
    }

    // calculate the minimum you can get from the next row based on the current column
    private static int minFromRow(List<Integer> row, int column) {
        int min = 0;
        // if column is 0, the min is between element 0 and 1 in the next row
        // if column is 1, the min is between element 0, 1, and 2 in the next row
        // if column is 2, the min is between element 1, 2, and 3 in the next row
        // if column is 3, the min is between element 2 and 3 in the next row
        switch (column) {
            case 0: { min = Math.min(row.get(0), row.get(1)); break; }
            case 1: { min =  Math.min(row.get(0), Math.min(row.get(1), row.get(2))); break; }
            case 2: { min =  Math.min(row.get(1), Math.min(row.get(2), row.get(3))); break; }
            case 3: { min =  Math.min(row.get(2), row.get(3)); break; }
        }
        return min;
    }
}
