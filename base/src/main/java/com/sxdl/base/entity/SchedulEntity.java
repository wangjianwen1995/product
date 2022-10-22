package com.sxdl.base.entity;

import lombok.Data;


/**
 * 全局调度任务实体类
 */
@Data
public class SchedulEntity {

    private String corn;//表达式
    private String stime;//绑定的调度开始时间
    private String etime;//绑定的调度结束时间
    private Integer isSys;//是否系统应用,1,base系统级的,0,各个系统的
    private String info;//调度任务信息

    public SchedulEntity() {
    }

    /**
     * 两个参数的构造方法
     *
     * @param isSys 是否系统应用,1,base系统级的,0,各个系统的
     * @param info  调度任务信息
     */
    public SchedulEntity(Integer isSys, String info) {
        this.isSys = isSys;
        this.info = info;
    }

    /**
     * 三个参数的构造方法
     *
     * @param isSys 是否系统应用,1,base系统级的,0,各个系统的
     * @param info  调度任务信息
     * @param corn  表达式
     */
    public SchedulEntity(Integer isSys, String info, String corn) {
        this.isSys = isSys;
        this.info = info;
        this.corn = corn;
    }

    /**
     * 全部参数的构造方法
     *
     * @param isSys 是否系统应用,1,base系统级的,0,各个系统的
     * @param info  调度任务信息
     * @param corn  表达式
     * @param stime 绑定的调度开始时间
     * @param etime 绑定的调度结束时间
     */
    public SchedulEntity(Integer isSys, String info, String corn, String stime, String etime) {
        this.isSys = isSys;
        this.info = info;
        this.corn = corn;
        this.stime = stime;
        this.etime = etime;
    }
}
