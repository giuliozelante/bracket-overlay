
package it.giuliozelante.model;

import java.util.LinkedHashMap;
import java.util.Map;

public class Extensions {

    public CacheControl cacheControl;
    public long queryComplexity;
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
