
package it.giuliozelante.model.bracket;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class Slot {

    public String id;
    public Entrant entrant;

}