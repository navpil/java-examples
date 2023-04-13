package ua.lviv.navpil.collections.impl;

import ua.lviv.navpil.collections.Person;

import java.util.AbstractSet;
import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class ExternalHashCodeSet<T> extends AbstractSet<T> {


    public static void main(String[] args) {
        ExternalHashCodeSet<Person> people = new ExternalHashCodeSet<>(person -> person.getAge() * 21);

        people.add(new Person("John", 32));
        people.add(new Person("Jim", 31));
        people.add(new Person("Jack", 32));
        people.add(new Person("Jill", 19));

        for (Person person : people) {
            System.out.println(person);
        }

    }


    private final Function<? super T, Integer> hashCodeFunction;
    private final HashMap<Integer, List<T>> delegate;
    private int size;
    private long modification;

    public ExternalHashCodeSet(Function<? super T, Integer> hashCodeFunction) {
        this.hashCodeFunction = hashCodeFunction;
        delegate = new HashMap<>();
    }

    @Override
    public boolean add(T t) {
        Integer hashCode = hashCodeFunction.apply(t);
        if (delegate.containsKey(hashCode)) {
            List<T> list = delegate.get(hashCode);
            if (list.contains(t)) {
                return false;
            }
            list.add(t);
        } else {
            LinkedList<T> list = new LinkedList<>();
            list.add(t);
            delegate.put(hashCode, list);
        }
        size++;
        modification++;
        return true;
    }

    @Override
    public Iterator<T> iterator() {
        return new ExternalHashCodeIterator();
    }



    private class ExternalHashCodeIterator implements Iterator<T> {

        private final long expectedModification;
        private boolean hasNext = false;
        private Iterator<T> delegateIt;
        private final Iterator<Integer> keys;

        public ExternalHashCodeIterator() {
            expectedModification = modification;
            keys = delegate.keySet().iterator();
            if (keys.hasNext()) {
                hasNext = true;
                delegateIt = delegate.get(keys.next()).iterator();
            }
        }

        @Override
        public boolean hasNext() {
            return hasNext;
        }

        @Override
        public T next() {
            if (expectedModification != modification) {
                throw new ConcurrentModificationException();
            }
            if (!hasNext) {
                throw new NoSuchElementException();
            }
            T n = delegateIt.next();
            if (!delegateIt.hasNext()) {
                if (keys.hasNext()) {
                    delegateIt = delegate.get(keys.next()).iterator();
                } else {
                    hasNext = false;
                }
            }
            return n;
        }

        @Override
        public void remove() {
            if (expectedModification != modification) {
                throw new ConcurrentModificationException();
            }

        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean contains(Object o) {
        T o1 = (T) o;
        Integer hashCode = hashCodeFunction.apply(o1);
        if (delegate.containsKey(hashCode)) {
            List<T> list = delegate.get(hashCode);
            if (list.isEmpty()) {
                return false;
            } else {
                for (T t : list) {
                    if (t.equals(o)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
