package main.java.part3.integral;

import java.util.function.DoubleUnaryOperator;

/*
Реализуйте метод, выполняющий численное интегрирование заданной функции
на заданном интервалепо формуле левых прямоугольников.

Функция задана объектом, реализующим интерфейс java.util.function.DoubleUnaryOperator.
Его метод applyAsDouble() принимает значение аргумента и возвращает значение функции в заданной точке.

Интервал интегрирования задается его конечными точками aa и bb, причем a \lt = ba<=b.
Для получения достаточно точного результата используйте шаг сетки не больше 10^{-6}.

Пример. Вызов integrate(x -> 1, 0, 10) должен возвращать значение 10.
 */
public class CalcIntegral {

    public static void main(String[] args) {
        System.out.println(integrate(x -> 1, 0, 10));//10.0
        System.out.println(integrate(x -> x + 2, 0, 10));//70.0
        System.out.println(integrate( x -> Math.sin(x) / x , 1, 5));//0.603848
    }
    public static double integrate(DoubleUnaryOperator f, double a, double b) {
        //ваш код
        double n = 1e7;
        double h = (b-a)/n;
        double s = 0;
        for (int i = 0; i < n; i++) {
            s += f.applyAsDouble(a + h * i);
        }
        return s * h;
    }

}
