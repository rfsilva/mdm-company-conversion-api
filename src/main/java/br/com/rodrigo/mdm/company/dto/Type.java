package br.com.rodrigo.mdm.company.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@AllArgsConstructor
@Getter
public enum Type {

    PUBLIC(1), PRIVATE(2), COOPERATIVE(3);

    @JsonValue
    private int value;

    public static Type of(int value) {
        return Arrays.stream(Type.values())
                .filter(tc -> value == tc.getValue())
                .findFirst().orElseThrow(IllegalAccessError::new);
    }
}
