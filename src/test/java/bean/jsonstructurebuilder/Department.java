package bean.jsonstructurebuilder;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder(setterPrefix = "with")
public class Department {
    @SerializedName(value = "Employees")
    private Collection<Employee> employees;
}
