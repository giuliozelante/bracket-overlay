
package it.giuliozelante.model.bracket;

import lombok.EqualsAndHashCode;

@lombok.Data
@EqualsAndHashCode(callSuper = false)
public class Data extends Base {
    public PhaseGroup phaseGroup;
}
