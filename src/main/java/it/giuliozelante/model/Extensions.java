
package it.giuliozelante.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class Extensions extends Base {

    public CacheControl cacheControl;
    public long queryComplexity;

}
