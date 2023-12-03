package com.example.projekuas.Upcoming;
import java.util.List;

public class ComingResponse<T> {
    List<T> result;
    public List<T> getResult() {
        return result;
    }
    public void setResult(List<T> result) {
        this.result = result;
    }
}
