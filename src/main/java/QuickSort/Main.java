package QuickSort;

import java.util.Arrays;

public class Main {
    private static int counter = 1;

    public static void main(String[] args) {
    int [] array = {4,2,8,1,3,7,6,5};
    int low = 0;
    int high = array.length - 1;
    sort(array,low, high);
        System.out.println("Результат: " + Arrays.toString(array));
    }

    public static void sort (int [] array, int low, int high){

        if (array.length == 0){
            return;
        }

        if (low >= high){
            return;
        }

        int middleElement = low + (high - low) / 2;   // Выбираем средний элемент
        int middleElementValue = array [middleElement];
        int i = low;
        int j = high;

        while (i <= j){
            while (array [i] < middleElementValue){  // Итерируем массив, пока не найдем меньший элемент
                i++;
            }
            while (array[j] > middleElementValue){   // Аналогичным образом движемся в обратную сторону в поисках большего эллемента
                j--;
            }
            if (i <= j){    // Меняем местами элементы
                int temp = array [i];
                array [i] = array [j];
                array [j] = temp;
                i++;
                j--;
            }
        }
        if (low < j){       //Вызываем рекурсию
            sort(array, low, j);
            System.out.println("sort (array, " + low + ", " + j + ")");
            counter++;
        }
        if (high > i){
            sort(array, i, high);
            System.out.println("sort (array, " + i + ", " + high + ")");
            counter++;
        }
    }
}
