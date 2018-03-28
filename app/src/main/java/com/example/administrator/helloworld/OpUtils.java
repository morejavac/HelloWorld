package com.example.administrator.helloworld;


import java.util.Random;

/**
 * Created by Administrator on 2018/3/28.
 */

public class OpUtils {
    //早(中餐/下午/晚)_时间_时钟
    private static final int Z_SJ_SZ=8;
    private static final int ZC_SJ_SZ=12;
    private static final int XW_SJ_SZ=13;
    private static final int W_SJ_SZ=17;
    private static final String fgf=":"; //分隔符

    //时间_分钟_上半区间_区间_小（大）
    private static final int SJ_FZ_MIX_BOUND_MIX=1;
    private static final int SJ_FZ_MIX_BOUND_MAX=25;

    //时间_分钟_下半区间_区间_小（大）
    private static final int SJ_FZ_MAX_BOUND_MIX=31;
    private static final int SJ_FZ_MAX_BOUND_MAX=50;
    //时间_秒钟_区间_小（大）
    private static final int SJ_MZ_BOUND_MIX=1;
    private static final int SJ_MZ_BOUND_MAX=58;
    //取随机整数
    //0 至 bound 包含0不包括bound
    //0 至 bound-1
    //区间min 至 max 写法 nextInt（max-mix+1）+mix
    public static int getRandom (int mix,int max) {
        Random rand=new Random();
        return rand.nextInt(max-mix+1)+mix;
    }

    public static String getTzSjZ(){
        String tmp;
        tmp=String.format("%02d",Z_SJ_SZ)+ fgf;
        tmp=tmp+String.format("%02d",getRandom(SJ_FZ_MIX_BOUND_MIX,SJ_FZ_MIX_BOUND_MAX));
        tmp=tmp+fgf;
        tmp=tmp+String.format("%02d",getRandom(SJ_MZ_BOUND_MIX,SJ_MZ_BOUND_MAX));
        return tmp;
    }

    public static String getTzSjZC(){
        String tmp;
        tmp=String.format("%02d",ZC_SJ_SZ)+ fgf;
        tmp=tmp+String.format("%02d",getRandom(SJ_FZ_MIX_BOUND_MIX,SJ_FZ_MIX_BOUND_MAX));
        tmp=tmp+fgf;
        tmp=tmp+String.format("%02d",getRandom(SJ_MZ_BOUND_MIX,SJ_MZ_BOUND_MAX));
        return tmp;
    }

    public static String getTzSjXW(){
        String tmp;
        tmp=String.format("%02d",XW_SJ_SZ)+ fgf;
        tmp=tmp+String.format("%02d",getRandom(SJ_FZ_MAX_BOUND_MIX,SJ_FZ_MAX_BOUND_MAX));
        tmp=tmp+fgf;
        tmp=tmp+String.format("%02d",getRandom(SJ_MZ_BOUND_MIX,SJ_MZ_BOUND_MAX));
        return tmp;
    }

    public static String getTzSjW(){
        String tmp;
        tmp=String.format("%02d",W_SJ_SZ)+ fgf;
        tmp=tmp+String.format("%02d",getRandom(SJ_FZ_MAX_BOUND_MIX,SJ_FZ_MAX_BOUND_MAX));
        tmp=tmp+fgf;
        tmp=tmp+String.format("%02d",getRandom(SJ_MZ_BOUND_MIX,SJ_MZ_BOUND_MAX));
        return tmp;
    }
}
