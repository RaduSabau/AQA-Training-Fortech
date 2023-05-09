package com.demoqa.frontend.dto.webtables;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.annotations.SerializedName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.Collection;

@Data
@Builder(setterPrefix = "with")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Employees implements Serializable {
    @SerializedName(value = "Employees")
    private Collection<Employee> employees;
}
