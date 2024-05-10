
package it.giuliozelante.model.bracket;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class PageInfo extends Base {

    public long total;

}
