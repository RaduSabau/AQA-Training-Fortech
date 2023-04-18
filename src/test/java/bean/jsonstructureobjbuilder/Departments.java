package bean.jsonstructureobjbuilder;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;

@Data
@Builder(setterPrefix = "with")
public class Departments {
    @SerializedName(value = "Department")
    private Department department;
}
