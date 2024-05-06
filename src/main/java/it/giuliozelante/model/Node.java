
package it.giuliozelante.model;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)

public class Node extends Base {

    public long id;
    public List<Slot> slots;

}
