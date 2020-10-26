class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] simulation = new double[101][101];
        simulation[0][0] = (double) poured;
        for (int row = 0; row <= query_row; row++) {
            for (int glass = 0; glass <= row; glass++) {
                if (simulation[row][glass] > 1) {
                    double excessive_one_side = (simulation[row][glass] - 1.0) / 2.0;
                    simulation[row + 1][glass] += excessive_one_side;
                    simulation[row + 1][glass + 1] += excessive_one_side;
                }
            }
        }
        
        return simulation[query_row][query_glass] < 1 
            ? simulation[query_row][query_glass]
            : 1.0;
    }
}
