package com.internetofthings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Value {
    public Value(Double val){
        this.value = val.toString();
    }
    private String value;
}
