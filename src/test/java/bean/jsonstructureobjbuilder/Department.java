package bean.jsonstructureobjbuilder;

import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder(setterPrefix = "with")
public class Department {
    private Collection<Employees> employees;
}
