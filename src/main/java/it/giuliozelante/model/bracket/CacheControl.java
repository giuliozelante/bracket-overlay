
package it.giuliozelante.model.bracket;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CacheControl extends Base {
    public long version;
    public Object hints;
}