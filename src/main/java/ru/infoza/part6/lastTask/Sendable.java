package ru.infoza.part6.lastTask;

public interface Sendable<T> {
    String getFrom();

    String getTo();

    T getContent();
}
