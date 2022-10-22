package com.sxdl.hpqc.function;


import java.util.List;

@FunctionalInterface
public interface Funcation2<T,E,R> {
    List<T> execute(E t1, R t2);
}
