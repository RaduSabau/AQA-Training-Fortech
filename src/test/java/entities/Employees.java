package entities;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(setterPrefix = "with")
public class Employees {
    private List<Employee> employees;
}
