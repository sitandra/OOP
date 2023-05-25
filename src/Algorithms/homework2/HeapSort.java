package Algorithms.homework2;

public class HeapSort {
    public void sort(int[] arr) {
        int n = arr.length;

        // Построение кучи (перегруппировка массива)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Извлечение элементов из кучи
        for (int i = n - 1; i > 0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

    // Перегруппировка поддерева с корнем на i-ой позиции
    private void heapify(int[] arr, int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2 * i + 1; // Левый потомок
        int r = 2 * i + 2; // Правый потомок

        // Если левый потомок больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // Если правый потомок больше наибольшего элемента
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // Если наибольший элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Рекурсивно перегруппировываем поддерево
            heapify(arr, n, largest);
        }
    }
}
