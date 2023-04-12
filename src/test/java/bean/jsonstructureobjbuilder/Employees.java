package bean.jsonstructureobjbuilder;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder(setterPrefix = "with")
public class Employees {
    private Collection<ID> ids;
}
