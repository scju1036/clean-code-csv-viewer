package com.exxeta.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CSVData {

    List<String> header;

    HashMap<Integer, List<String>> content;

    List<Integer> maxCharactersPerColumn;

    public CSVData() {
        this.header = new ArrayList<>();
        this.content = new HashMap<>();
        this.maxCharactersPerColumn = new ArrayList<>();
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

    public List<Integer> getMaxCharactersPerColumn() {
        return maxCharactersPerColumn;
    }

    public void setMaxCharactersPerColumn(List<Integer> maxCharactersPerColumn) {
        this.maxCharactersPerColumn = maxCharactersPerColumn;
    }
}
