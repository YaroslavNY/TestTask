package Fibonacci;

import java.util.ArrayList;

public class Main {

private int result;
private String errorMessage;
private ArrayList <Integer> fibonacciArray = new ArrayList<>();

    public static void main(String[] args) {

    }

/* Метод для рассчета числа Фибоначчи
в соответствии с заданным номером
вычисляемые числа начинаются с 0, т.е. N = 0,1,2...
 */
    public int calculateNumber( int number){

        if (number == 0){
            return result = 0;
        }
        else if (number < 2){
            return result = 1;
        }
        else {
            fibonacciArray = createArray(number); // Передаем в метод номер искомого эллемента для формироования ряда Фибоначчи
            return result = fibonacciArray.get(fibonacciArray.size() - 1); // Возвращаем последний элемент ряда (искомый)
        }
    }
    public ArrayList createArray (int number){
            fibonacciArray.clear(); // Очищаем коллекцию
            fibonacciArray.add(0); fibonacciArray.add(1);  // Добавляем в коллекцию первые числа

        for (int i = 1; i < number; i++) {
            fibonacciArray.add((fibonacciArray.get(i) + fibonacciArray.get(i-1)));  // Добавляем в коллекцию все числа до искомого
        }
        return fibonacciArray;
    }
}
