
package it.giuliozelante.model.brackets;

import java.util.LinkedHashMap;
import java.util.Map;

import lombok.EqualsAndHashCode;

@lombok.Data
@EqualsAndHashCode(callSuper = false)
public class Standing__1 {

    public Integer placement;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
