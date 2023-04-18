package bean.jsonstructureobjbuilder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class FinancialInformation {
    private Integer salary;
    private Integer bonus;
    private String lastUpdated;
}
