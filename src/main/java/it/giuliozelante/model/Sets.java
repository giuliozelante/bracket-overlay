
package it.giuliozelante.model;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class Sets extends Base {

    public PageInfo pageInfo;
    public List<Node> nodes;

}
