package ua.lviv.navpil.collections.impl;

import ua.lviv.navpil.collections.Person;

import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class ExternalHashCodeSet2<T> extends AbstractSet<T> {

    public static void main(String[] args) {
        ExternalHashCodeSet2<Person> people = new ExternalHashCodeSet2<>(person -> person.getAge() * 21);

        people.add(new Person("John", 32));
        people.add(new Person("Jim", 31));
        people.add(null);
        people.add(new Person("Jack", 32));
        people.add(new Person("Jill", 19));

        for (Person person : people) {
            System.out.println(person);
        }

        people.remove(new Person("Jack", 32));
        people.remove(null);

        for (Person person : people) {
            System.out.println(person);
        }

    }

    private final Function<? super T, Integer> hashCodeFunction;
    private T[] arr;
    private int size;
    private long modification;
    private boolean containsNull = false;

    public ExternalHashCodeSet2(Function<? super T, Integer> hashCodeFunction) {
        this.hashCodeFunction = hashCodeFunction;
        arr = createArray(16);
    }

    @SuppressWarnings("unchecked")
    private T[] createArray(int size) {
        return (T[])new Object[size];
    }

    //Optional
    @Override
    public boolean add(T t) {
        if (t == null) {
            if (containsNull) {
                return false;
            } else {
                containsNull = true;
            }
        } else {
            Integer hashCode = hashCodeFunction.apply(t);
            int index = hashCode % arr.length;
            while (arr[index] != null) {
                if (arr[index].equals(t)) {
                    return false;
                }
                index++;
                if (index == arr.length) {
                    index = 0;
                }
            }
            arr[index] = t;
        }
        size++;
        modification++;
        ensureSize();
        return true;
    }

    private void ensureSize() {
        if (size * 1.0 / arr.length > 0.75) {
            T[] tempArr = createArray(arr.length * 2);
            for (T o : arr) {
                if (o == null) continue;
                Integer hashCode = hashCodeFunction.apply((T)o);
                int index = hashCode % tempArr.length;
                while (tempArr[index] != null) {
                    index++;
                    if (index == tempArr.length) {
                        index = 0;
                    }
                }
                tempArr[index] = o;
            }
            arr = tempArr;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ExternalHashCodeIterator();
    }

    private class ExternalHashCodeIterator implements Iterator<T> {

        private final long expectedModification;
        private int nextIndex;
        private int currentIndex = -1;
        private boolean showNull;

        ExternalHashCodeIterator() {
            expectedModification = modification;
            nextIndex = findNextIndex();
            showNull = containsNull;
        }

        private int findNextIndex() {
            int newNextIndex = currentIndex + 1;
            while(arr.length > newNextIndex && arr[newNextIndex] == null) {
                newNextIndex++;
            }
            if (arr.length == newNextIndex) {
                return -1;
            }
            return newNextIndex;
        }

        @Override
        public boolean hasNext() {
            return showNull || nextIndex >= 0;
        }

        @Override
        public T next() {
            if (expectedModification != modification) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (showNull) {
                showNull = false;
                return null;
            }
            currentIndex = nextIndex;
            nextIndex = findNextIndex();
            return (T)arr[currentIndex];
        }

        @Override
        public void remove() {
            if (expectedModification != modification) {
                throw new ConcurrentModificationException();
            }
            if (currentIndex == -1 && containsNull) {
                containsNull = false;
            } else if (currentIndex == -1) {
                throw new NoSuchElementException();
            } else {
                arr[currentIndex] = null;
            }
            size--;
            modification++;
        }
    }

    @Override
    public int size() {
        return size;
    }

    //Performance optimization
    @Override
    public boolean contains(Object o) {
        if (o == null) {
            return containsNull;
        }
        T o1;
        try {
            o1 = (T) o;
        } catch (ClassCastException e) {
            return false;
        }
        Integer hashCode = hashCodeFunction.apply(o1);
        int index = hashCode % arr.length;

        while (arr[index] != null) {
            if (arr[index].equals(o)) {
                return true;
            }
        }
        return false;
    }

}
