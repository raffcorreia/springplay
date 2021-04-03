package com.example.springplay.sqlinjection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SqlInjectionLoginResponse {
    private Boolean authenticated;
}
