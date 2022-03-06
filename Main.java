import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        Box<Orange> orangeBox1 = new Box();
        Box<Orange> orangeBox2 = new Box();
        Box<Apple> appleBox1 = new Box();
        Box<Apple> appleBox2 = new Box();

        for (int i = 0; i < 5; i++) {
            orangeBox1.add(new Orange());
        }

        for (int i = 0; i < 5; i++) {
            orangeBox2.add(new Orange());
        }

        for (int i = 0; i < 5; i++) {
            appleBox1.add(new Apple());
        }

        for (int i = 0; i < 5; i++) {
            appleBox2.add(new Apple());
        }

        Float orangeBox1Weight = orangeBox1.getWeight();
        Float orangeBox2Weight = orangeBox2.getWeight();
        Float appleBox1Weight = appleBox1.getWeight();
        Float appleBox2Weight = appleBox2.getWeight();

        System.out.println("Weight of the first box with oranges: " + orangeBox1Weight);
        System.out.println("Weight of the second box with oranges: " + orangeBox2Weight);
        System.out.println("Weight of the first box with apples: " + appleBox1Weight);
        System.out.println("Weight of the second box with apples: " + appleBox2Weight);
        System.out.println();

        System.out.println("Is the weight of the first box with oranges and the first box with apples the same? - " + orangeBox1.compare(appleBox1));
        System.out.println("Is the weight of the first box with oranges and the second box with oranges the same? - " + orangeBox1.compare(orangeBox2));
        System.out.println("Is the weight of the first box with apples and the second box with apples the same? - " + appleBox1.compare(appleBox2));
        System.out.println();

        orangeBox1.move(orangeBox2);
        appleBox1.move(appleBox2);

        Integer[] arr = {5, 15, 25, 35};

        System.out.println(Arrays.toString(arr));
        swap(arr, 0, 1);
        System.out.println(Arrays.toString(arr));

    }

    public static void swap(Object[] arr, int index1, int index2) {
        Object object = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = object;
    }

}
