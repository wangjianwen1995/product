package com.sxdl.hpqc.function;


import java.util.List;

@FunctionalInterface
public interface Funcation1<T> {
    List<T> execute(Object t1);
}
