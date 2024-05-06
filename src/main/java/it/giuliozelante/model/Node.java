
package it.giuliozelante.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Node {

    public long id;
    public List<Slot> slots;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}