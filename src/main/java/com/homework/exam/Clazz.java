package com.homework.exam;

import lombok.Getter;

@Getter
public class Clazz {
    int id;
    String name;

    public Clazz(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
