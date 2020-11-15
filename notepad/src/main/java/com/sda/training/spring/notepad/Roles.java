package com.sda.training.spring.notepad;

import lombok.Data;

public enum Roles {
    USR("SUPER_USER"),
    ADM("ADMIN");

    private String fullName;

    Roles(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
