package made.myself.newarraylist.collections;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyArrayListImpl<T> implements MyArrayList<T> {
    private static final int STEP_ARRAY_BOUNDS = 10;
    private int sizeArray = 1;
    private int size = 0;
    private Container[] value = new Container[sizeArray];


    private static class Container<T> {
        Integer index;
        T value;

        public Container(T value) {
            this.value = value;
        }

        public Container(int index) {
            this.index = index;
        }
    }

    @Override
    public T add(T item) {
        if (sizeArray == size) toArray();
        addNew(size, item);
        return item;
    }


    private void addNew(int index, T item) {
        var newContainer = new Container(item);
        newContainer.index = index;
        value[index] = newContainer;
        size++;
    }

    @Override
    public T set(int index, T item) {
        if (index >= size)
            throw new ArrayIndexOutOfBoundsException();
        value[index].value = item;
        return item;
    }

    @Override
    public T remove(T item) {
        if (size == 0) throw new NoSuchElementException();
        if (remove(value[0], item)) {
            size--;
            return item;
        } else throw new NoSuchElementException();
    }

    @Override
    public Object remove(int index) {
        if (value[index] == null) throw new NoSuchElementException();
        Object out = value[index].value;
        for (int i = index + 1; i < size; i++) {
            if (value[i].index == null) break;
            value[i].index = i - 1;
            value[i - 1] = value[i];
            value[i] = null;
        }
        size--;
        return out;
    }

    private boolean remove(Container<T> curr, T item) {
        if (curr.value.equals(item)) {
            for (int i = curr.index + 1; i < size; i++) {
                if (value[i].index == null) break;
                value[i].index = i - 1;
                value[i - 1] = value[i];
                value[i] = null;
            }
            return true;
        }
        if (curr.index == size - 1) return false;
        return remove(value[curr.index + 1], item);
    }

    @Override
    public boolean contains(T item) {
        if (size == 0) {
            return false;
        }
        return contains(value[0], item);
    }

    private boolean contains(Container<T> curr, T item) {
        if (curr.value.equals(item)) return true;
        if (curr.index == size - 1) return false;
        return contains(value[curr.index + 1], item);
    }

    private int indexOf(Container<T> curr, T item, int modifier) {
        if (curr.value.equals(item)) return curr.index;
        if(modifier==1) {
            if (curr.index == size-1) return -1;
        }
        else{
            if(curr.index == 0) return -1;
        }
        return indexOf(value[curr.index + modifier], item, modifier);
    }

    @Override
    public int indexOf(T item) {
        return indexOf(value[0], item, 1);
    }

    @Override
    public int lastIndexOf(T item) {
        return indexOf(value[size - 1], item, -1);
    }

    @Override
    public Object get(int index) {
        if (size == 0 || index>=size) throw new NoSuchElementException();
        return value[index].value;
    }

    @Override
    public boolean equals(MyArrayList otherList) {
        if(otherList.size() != this.size)
            return false;
        for(int i =0; i<size;i++)
        {
            if(this.value[i].value!=otherList.get(i))
                return false;
        }
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        for (Container<T> container : value) {
            if (container != null) return false;
        }
        return true;
    }

    @Override
    public void clear() {
        value = new Container[1];
    }


    private Container<T>[] toArray() {
        sizeArray += STEP_ARRAY_BOUNDS;
        value = Arrays.copyOf(value, sizeArray);
        return value;
    }

}
