package ru.infoza.part6.lastTask;

public class MailMessage implements Sendable<String>{

    public String from;
    public String to;
    public String content;

    public MailMessage(String from, String to, String content) {
        this.from = from;
        this.to = to;
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }

}
