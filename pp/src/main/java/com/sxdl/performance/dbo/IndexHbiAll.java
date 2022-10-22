package com.sxdl.hp.dbo;

import lombok.Data;

import java.util.List;

@Data
public class IndexHbiAll {
    String name;
    Integer count;
    Integer countWq;
    Double zz;
    Double bl;

    public IndexHbiAll() {
    }

    public IndexHbiAll(Integer count, Integer countWq, Double zz, Double bl,String name,List<IndexHbiAll> list) {
        this.count = count;
        this.countWq = countWq;
        this.zz = zz;
        this.bl = bl;
        this.name=name;
        this.list=list;
    }
    public IndexHbiAll(Integer count, Integer countWq, Double zz, Double bl,String name) {
        this.count = count;
        this.countWq = countWq;
        this.zz = zz;
        this.bl = bl;
        this.name=name;
    }
    List<IndexHbiAll> list;


}
