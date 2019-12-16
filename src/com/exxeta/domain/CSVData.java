package com.exxeta.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVData {

    List<String> header;

    HashMap<Integer, List<String>> content;

    public CSVData() {
        this.header = new ArrayList<>();
        this.content = new HashMap<>();
    }

    public List<String> getHeader() {
        return header;
    }

    public void setHeader(List<String> header) {
        this.header = header;
    }

    public HashMap<Integer, List<String>> getContent() {
        return content;
    }

    public void setContent(HashMap<Integer, List<String>> content) {
        this.content = content;
    }

}
