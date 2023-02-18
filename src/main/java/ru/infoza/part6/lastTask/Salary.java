package ru.infoza.part6.lastTask;

public class Salary implements Sendable<Integer>{

    String from;
    String to;

    @Override
    public String getFrom() {
        return null;
    }

    @Override
    public String getTo() {
        return to;
    }

    @Override
    public Integer getContent() {
        return null;
    }

    int salary;

    public Salary(String company, String employee, int count) {
        this.from = company;
        this.to = employee;
        this.salary = count;
    }
}
