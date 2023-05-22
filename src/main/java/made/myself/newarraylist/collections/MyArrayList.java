package made.myself.newarraylist.collections;
import java.util.NoSuchElementException;

public interface MyArrayList<T> {
    /**
     * Добавление элемента.
     *
     * @param item элемент для добавления
     * @return добавленный элемент в качестве результата выполнения.
     */
    T add(T item);

    /**
     * Установить элемент
     * на определенную позицию,
     * затерев существующий.
     *
     * @param item  элемент для добавления
     * @param index индекс списка
     * @return добавленный элемент в качестве результата выполнения.
     * @throws ArrayIndexOutOfBoundsException Выбросить исключение,если индекс больше фактического количества элементов или выходит за пределы массива.
     */
    T set(int index, T item);

    /**
     * Удаление элемента.
     *
     * @param item элемент для удаления
     * @return удаленный элемент
     * @throws NoSuchElementException исключение, если подобный элемент отсутствует в списке.
     */
    T remove(T item);

    /**
     * Удаление элемента по индексу.
     *
     * @param index индекс элемента для удаления
     * @return удаленный элемент
     * @throws NoSuchElementException исключение, если подобный элемент отсутствует в списке.
     */
    Object remove(int index);

    /**
     * Проверка на существование элемента.
     *
     * @param item элемент для проверки
     * @return True or False
     */
    boolean contains(T item);

    /**
     * Поиск элемента
     *
     * @param item элемент для поиска
     * @return индекс элемента OR -1 в случае отсутствия
     */
    int indexOf(T item);

    /**
     * Поиск элемента с конца.
     *
     * @param item элемент для поиска
     * @return индекс элемента OR -1 в случае отсутствия
     */
    int lastIndexOf(T item);

    /**
     * Получить элемент по индексу.
     *
     * @param index индекс элемента
     * @return элемент по индексу
     * @throws ArrayIndexOutOfBoundsException исключение, если выходит за рамки фактического количества элементов
     */
    Object get(int index);

    /**
     * Сравнить текущий список с другим.
     *
     * @param otherList другой List для сравнения
     * @return True OR False
     * @throws NullPointerException исключение, если передан null.
     */
    boolean equals(MyArrayList otherList);

    /**
     * @return фактическое количество элементов.
     */
    int size();

    /**
     * @return True, если элементов в списке нет, иначе False
     */
    boolean isEmpty();

    /**
     * Удалить все элементы из списка.
     */
    void clear();

}
