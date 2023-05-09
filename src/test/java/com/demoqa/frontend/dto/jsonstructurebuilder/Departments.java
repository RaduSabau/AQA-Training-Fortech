package com.demoqa.frontend.dto.jsonstructurebuilder;

import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(setterPrefix = "with")
public class Departments {
    @SerializedName(value = "Department")
    private Department department;
}
