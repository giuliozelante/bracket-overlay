
package it.giuliozelante.model.bracket;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Extensions extends Base {

    public CacheControl cacheControl;
    public long queryComplexity;

}
