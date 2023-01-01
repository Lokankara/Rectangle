package main.java.com.ua.station;

import java.awt.Color;

public interface Service<T> {

    T repair(T t);

    T wash(T t);

    T paint(T t, Color color);

    T tireFitting(T t, Fitting tire);
}
