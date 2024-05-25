public class Matrix {

    Double[][] mx;

    public Matrix(Double[][] mx) {
        this.mx = mx;
    }

    public Double getValue(int row, int col) {
        if (row < 3 && row >= 0 & col < 3 & row >= 0) {
            return mx[row][col];
        }

        return null;
    }


}