package com.example.projekuas.CinemaSelect;
import java.util.List;

public class MovieResponse<T> {
    List<T> result;
    public List<T> getResult() {
        return result;
    }
    public void setResult(List<T> result) {
        this.result = result;
    }
}

