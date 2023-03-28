package by.it.group_251003.zdanovich.lesson02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Даны события events
реализуйте метод calcStartTimes, так, чтобы число включений регистратора на
заданный период времени (1) было минимальным, а все события events
были зарегистрированы.
Алгоритм жадный. Для реализации обдумайте надежный шаг.
*/

public class A_VideoRegistrator {

    public static void main(String[] args) {
        A_VideoRegistrator instance=new A_VideoRegistrator();
        double[] events=new double[]{1, 1.1, 1.6, 2.2, 2.4, 2.7, 3.9, 8.1, 9.1, 5.5, 3.7};
        List<Double> starts=instance.calcStartTimes(events,1); //рассчитаем моменты старта, с длинной сеанса 1
        System.out.println(starts);                            //покажем моменты старта
    }
    //модификаторы доступа опущены для возможности тестирования
    List<Double> calcStartTimes(double[] events, double workDuration) {
        List<Double> result = new ArrayList<>();

        // Сортируем массив событий по возрастанию
        Arrays.sort(events);

        // Инициализируем переменную для времени старта видеокамеры
        double startTime = 0;

        //Инициализация первого элемента (с него начнется первое включение регистратора)
        result.add(events[0]);
        startTime = events[0];

        // Проходим по всем событиям
        for (int i = 1; i < events.length; i++) {

            // Если текущее событие происходит после времени окончания работы видеокамеры,
            // то регистрируем его и обновляем время окончания работы видеокамеры
            if (events[i] > startTime + workDuration) {
                result.add(events[i]);
                startTime = events[i];
            }
        }

        return result;
    }
}