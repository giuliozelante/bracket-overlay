
package it.giuliozelante.model.brackets;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@lombok.Data
@EqualsAndHashCode(callSuper = false)
public class BracketResponse extends Base {

    private Data data;
    private Extensions extensions;
    private List<Object> actionRecords;

}
