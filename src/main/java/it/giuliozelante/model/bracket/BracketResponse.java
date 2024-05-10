
package it.giuliozelante.model.bracket;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BracketResponse extends Base {

    private Data data;
    private Extensions extensions;
    private List<Object> actionRecords;

}
