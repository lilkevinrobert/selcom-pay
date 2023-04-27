package com.example.selcompay.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Secret {

    private String consumer_key;
    private String consumer_secret;
}
