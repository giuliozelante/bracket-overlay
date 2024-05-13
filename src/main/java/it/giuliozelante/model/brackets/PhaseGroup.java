
package it.giuliozelante.model.brackets;

import java.util.LinkedHashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "id",
        "displayIdentifier",
        "sets"
})

public class PhaseGroup {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("displayIdentifier")
    private String displayIdentifier;
    @JsonProperty("sets")
    private Sets sets;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonProperty("displayIdentifier")
    public String getDisplayIdentifier() {
        return displayIdentifier;
    }

    @JsonProperty("displayIdentifier")
    public void setDisplayIdentifier(String displayIdentifier) {
        this.displayIdentifier = displayIdentifier;
    }

    @JsonProperty("sets")
    public Sets getSets() {
        return sets;
    }

    @JsonProperty("sets")
    public void setSets(Sets sets) {
        this.sets = sets;
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
