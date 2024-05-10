
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
        "tournaments"
})
@Serdeable
public class Data {

    @JsonProperty("tournaments")
    private Tournaments__1 tournaments;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    @JsonProperty("tournaments")
    public Tournaments__1 getTournaments() {
        return tournaments;
    }

    @JsonProperty("tournaments")
    public void setTournaments(Tournaments__1 tournaments) {
        this.tournaments = tournaments;
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
