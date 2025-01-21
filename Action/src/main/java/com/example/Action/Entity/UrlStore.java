package com.example.Action.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UrlStore {

    private long id;
    private String apiUrl;
    private String apiMethod;
    private LocalDateTime time;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getApiMethod() {
        return apiMethod;
    }

    public void setApiMethod(String apiMethod) {
        this.apiMethod = apiMethod;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
}
