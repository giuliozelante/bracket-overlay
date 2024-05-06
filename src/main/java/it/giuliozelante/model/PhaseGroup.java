
package it.giuliozelante.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class PhaseGroup extends Base {

    public long id;
    public String displayIdentifier;
    public Sets sets;

}
