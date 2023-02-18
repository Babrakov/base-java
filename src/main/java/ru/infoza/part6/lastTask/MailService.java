package ru.infoza.part6.lastTask;

import java.util.Collections;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<Sendable<T>> {

    private Map<String, List<T>> mailBox;

    public Map<String, List<T>> getMailBox() {
        return mailBox;
    }

    public MailService() {
        mailBox = new MyHashMap<>();
    }

    @Override
    public void accept(Sendable<T> t) {

        if(mailBox.containsKey(t.getTo())) {
            List<T> val;
            val = mailBox.get(t.getTo());
            val.add(t.getContent());
            mailBox.put(t.getTo(), val);
        } else {
            List<T> val;
            val = new LinkedList<>();
            val.add(t.getContent());
            mailBox.put(t.getTo(), val);
        }

    }

    private static class MyHashMap<K,V> extends HashMap<K,V> {
        @Override
        public V get(Object key){
            V temp = super.get(key);
            try {
                if (temp == null) temp = (V) Collections.emptyList();
            } catch (ClassCastException e) {}
            return temp;
        }
    }
}
