package com.demoqa.frontend.dto.practiceform;

import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
    @Builder(setterPrefix = "with")
    public class Student {
        private String firstName;
        private String lastName;
        private String email;
        private String gender;
        private String mobileNumber;
        private Date dateOfBirth;
        private String subject;
        private String address;
}
