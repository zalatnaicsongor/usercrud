package hu.zalatnai.usercrud.user.application;


import java.time.LocalDate;

import org.springframework.util.StringUtils;

public class UserChangeSet {
    private String name;
    private LocalDate dateOfBirth;

    public UserChangeSet(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public boolean shouldChangeName() {
        return StringUtils.hasText(name);
    }

    public boolean shouldChangeDateOfBirth() {
        return dateOfBirth != null;
    }
}
