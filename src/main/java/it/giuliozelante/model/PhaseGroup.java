
package it.giuliozelante.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class PhaseGroup {

    public long id;
    public String displayIdentifier;
    public Sets sets;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
