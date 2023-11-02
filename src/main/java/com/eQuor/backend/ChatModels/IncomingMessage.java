package com.eQuor.backend.ChatModels;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IncomingMessage {
    private String name;

    private String message;
    private  String receiver;
}
