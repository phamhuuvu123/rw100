package org.example.dto;

import java.util.List;

public class ImportErro<T> {
    private T line;
    private List<String> message;

    public ImportErro(){}
    public ImportErro(T line, List<String> message) {
        this.line = line;
        this.message = message;
    }

    public T getLine() {
        return line;
    }

    public void setLine(T line) {
        this.line = line;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
