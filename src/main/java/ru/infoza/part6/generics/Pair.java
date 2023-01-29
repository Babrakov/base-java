package ru.infoza.part6.generics;

public class Pair<T, S> {

    private final T first;
    private final S second;

    public static <T,S> Pair<T, S> of(T first, S second) {
        return new Pair<>(first, second);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Pair)) {
            return false;
        }

        Pair<?,?> other = (Pair<?, ?>) obj;
        return (java.util.Objects.equals(first, other.first) && java.util.Objects.equals(second, other.second));
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hashCode(first)+java.util.Objects.hashCode(second);
    }

    private Pair(T first, S second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        if (first == null)
            throw new java.util.NoSuchElementException("No first present");
        return first;
    }

    public S getSecond() {
        if (second == null)
            throw new java.util.NoSuchElementException("No second present");
        return second;
    }
}
