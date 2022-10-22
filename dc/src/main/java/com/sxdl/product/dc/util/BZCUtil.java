package com.sxdl.product.dc.util;

import java.math.BigDecimal;
import java.util.stream.DoubleStream;

/**
 * 计算标准差 变异系数
 */
public class BZCUtil {

    /**
     * 随机生成小数
     * @param num 生成多少个
     * @return
     */
    public static double[] rom(Integer num) {
        double [] ds = DoubleStream.generate(()->Math.random()*100000).limit(num)
                .map(a -> Double.parseDouble(String.format("%.2f", a))).
                        toArray();
        return ds;
    }

    public static void main(String[] args) {


        int i=0;
        while (true){
            double cv = CV(rom(10));
            System.out.println(cv);
            if(cv>1){
                break;
            }
            i++;

        }

        System.out.println("循环了"+i);




    }

    /** SD 公式: s^2=[(x1-x)^2 +...(xn-x)^2]/(n-1)
     * 标准差 SD
     * @param x
     * @return
     */
    public static double SD(double[] x) {
        int m=x.length;
        double sum=0;
        for(int i=0;i<m;i++){//求和
            sum+=x[i];
        }
        double dAve=sum/m;//求平均值
        double dVar=0;
        for(int i=0;i<m;i++){//求方差
            dVar+=(x[i]-dAve)*(x[i]-dAve);
        }


        BigDecimal b = new BigDecimal(Math.sqrt(dVar/m));
        double f1 = b.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }

    /**
     * 变异系数 CV
     * @param x
     * @return
     */
    public static double CV(double[] x) {
        int m=x.length;
        double sum=0;
        for(int i=0;i<m;i++){//求和
            sum+=x[i];
        }
        double dAve=sum/m;//求平均值
        double dVar=0;
        for(int i=0;i<m;i++){//求方差
            dVar+=(x[i]-dAve)*(x[i]-dAve);
        }
        //reture Math.sqrt(dVar/(m-1));

        BigDecimal b = new BigDecimal((Math.sqrt(dVar/m))/dAve);
        double f1 = b.setScale(5, BigDecimal.ROUND_HALF_UP).doubleValue();
        return f1;
    }


}
