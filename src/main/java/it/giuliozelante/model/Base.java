package it.giuliozelante.model;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Base {
    private Map<String, Object> additionalProperties = new LinkedHashMap<>();
}