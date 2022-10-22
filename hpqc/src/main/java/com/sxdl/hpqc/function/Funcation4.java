package com.sxdl.hpqc.function;


import java.util.List;

@FunctionalInterface
public interface Funcation4<T> {
    List<T> execute(Object t1,Object t2,Object t3,Object t4);
}
