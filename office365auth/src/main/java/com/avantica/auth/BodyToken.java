package com.avantica.auth;

import java.io.Serializable;

/**
 * Created by max.macalupu on 31/05/2016.
 */
public class BodyToken implements Serializable{

    private String family_name;

    public BodyToken() {
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    @Override
    public String toString() {
        return "BodyToken{" +
                "family_name='" + family_name + '\'' +
                '}';
    }
}