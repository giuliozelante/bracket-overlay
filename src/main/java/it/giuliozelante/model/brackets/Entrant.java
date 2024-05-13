
package it.giuliozelante.model.brackets;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Entrant extends Base {

    public long id;
    public String name;

}
