package com.example.springplay.validation;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class Contact {
    @NotNull
    @NotBlank
    private String mediaName;
    private String user;
    private String url;

    @Valid
    private List<@NotBlank String> friends;
}
