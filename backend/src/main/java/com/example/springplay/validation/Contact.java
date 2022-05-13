package com.example.springplay.validation;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public record Contact(
    @NotNull
    @NotBlank
    String mediaName,
    String user,
    String url,

    @Valid
    List<@NotBlank String> friends
) {
}
