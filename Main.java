public class Main {

    public static void main(String[] args) {

        String[][] arr = new String[][]{{"о", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};
        try {
            try {
                int result = sum(arr);
                System.out.println(result);
            } catch (MyArraySizeException e) {
                e.printStackTrace();
                System.out.println("Превышен размер массива");
            }
        }
        catch (MyArrayDataException e) {
            e.printStackTrace();
            System.out.println("Некорректный тип данных в ячейке [" + e.i + "][" + e.j + "]");
        }
    }

    public static int sum(String[][] arr) throws MyArraySizeException, MyArrayDataException {
        int count = 0;
        if (arr.length != 4) {
            throw new MyArraySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4) {
                throw new MyArraySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
                try {
                    count = count + Integer.parseInt(arr[i][j]);
                }
                catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }

        }
        return count;
    }

}
