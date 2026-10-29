package org.doodle.ai.openai.api.reference3.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

@Builder
@Jacksonized
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Country {
    private String name;
    private String alpha2Code;
    private String alpha3Code;
    private String dialCode;
}
