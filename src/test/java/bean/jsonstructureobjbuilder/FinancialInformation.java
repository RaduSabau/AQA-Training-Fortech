package bean.jsonstructureobjbuilder;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder(setterPrefix = "with")
public class FinancialInformation {
    private Integer salary;
    private Integer bonus;
    private String lastUpdated;
}
