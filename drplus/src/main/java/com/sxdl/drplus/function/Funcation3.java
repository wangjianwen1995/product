package com.sxdl.drplus.function;


import java.util.List;

@FunctionalInterface
public interface Funcation3<T> {
    List<T> execute(Object t1,Object t2,Object t3);
}
