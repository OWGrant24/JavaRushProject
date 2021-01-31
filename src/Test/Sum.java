package Test;

//!Простой пример применения класса RecursiveTask<V>

import java.util.concurrent.*;

// Класс RecursiveTask, используемый для вычисления
// суммы значений элементов в массиве типа douЫe
class Sum extends RecursiveTask<Double> {
    // Пороговое значение последовательного выполнения
    final int seqThresHold = 500;
    // Обрабатываемый массив
    double[] data;
    //определить часть обрабатываемых данных
    int start, end;

    Sum(double[] vals, int s, int е) {
        data = vals;
        start = s;
        end = е;
    }

    // определить сумму значений элементов в массиве типа douЫe
    protected Double compute() {
        double sum = 0;
        // Если количество элементов ниже порогового значения,
        // то выполнить далее обработку последовательно
        if ((end - start) < seqThresHold) {
            // суммировать значения элементов в массиве типа douЫe
            for (int i = start; i < end; i++){
                sum += data[i];
            }
        } else {
            // В противном случае продолжить разделение данных на меньшие части найти середину
            int middle = (start + end) / 2;
            // запустить новые подзадачи на выполнение,
            //используя разделенные на части данные
            Sum subTaskA = new Sum(data, start, middle);
            Sum subTaskB = new Sum(data, middle, end);
            // запустить каждую подзадачу путем разветвления
            subTaskA.fork();
            subTaskB.fork();
            // ожидать завершения подзадач и накопить результаты
            sum = subTaskA.join() + subTaskB.join();
        }
        // возвратить конечную сумму
        return sum;
    }
}

