
package it.giuliozelante.model.tournament;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import io.micronaut.serde.annotation.Serdeable;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "cacheControl",
        "queryComplexity"
})

@Serdeable
public class Extensions {

    @JsonProperty("cacheControl")
    private CacheControl cacheControl;
    @JsonProperty("queryComplexity")
    private Integer queryComplexity;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("cacheControl")
    public CacheControl getCacheControl() {
        return cacheControl;
    }

    @JsonProperty("cacheControl")
    public void setCacheControl(CacheControl cacheControl) {
        this.cacheControl = cacheControl;
    }

    @JsonProperty("queryComplexity")
    public Integer getQueryComplexity() {
        return queryComplexity;
    }

    @JsonProperty("queryComplexity")
    public void setQueryComplexity(Integer queryComplexity) {
        this.queryComplexity = queryComplexity;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
