package dto.practiceform;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder(setterPrefix = "with")
public class Students {
    private List<Student> students;
}
