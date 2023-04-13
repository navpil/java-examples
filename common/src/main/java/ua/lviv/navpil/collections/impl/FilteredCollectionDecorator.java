package ua.lviv.navpil.collections.impl;

import ua.lviv.navpil.collections.Person;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class FilteredCollectionDecorator<T> extends AbstractCollection<T> {


    public static void main(String[] args) {
        FilteredCollectionDecorator<Person> people = new FilteredCollectionDecorator<>(person -> person.getAge() > 17, new ArrayList<>());
        people.add(new Person("Jim", 23));
        people.add(new Person("Jannie", 16));
        for (Person person : people) {
            System.out.println(person);
        }
        List<Person> arrayList = new ArrayList<>(people);
        System.out.println(arrayList);
    }

    private final Predicate<? super T> filter;
    private final Collection<T> delegate;

    public FilteredCollectionDecorator(Predicate<? super T> filter, Collection<T> delegate) {
        this.delegate = delegate;
        this.filter = filter;
    }

    @Override
    public boolean add(T t) {
        return filter.test(t) && delegate.add(t);
    }

    @Override
    public Iterator<T> iterator() {
        return delegate.iterator();
    }

    @Override
    public int size() {
        return delegate.size();
    }
}
