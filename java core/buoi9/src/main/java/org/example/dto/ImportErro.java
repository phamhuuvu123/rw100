package org.example.dto;

import java.util.List;

public class ImportErro {
    private String line;
    private List<String> message;
    public ImportErro()
    {

    }
    public String getLine() {
        return line;
    }

    public void setLine(String line) {
        this.line = line;
    }

    public ImportErro(String line, List<String> message) {
        this.line = line;
        this.message = message;
    }

    public List<String> getMessage() {
        return message;
    }

    public void setMessage(List<String> message) {
        this.message = message;
    }
}
