package com.macfu.datasource;

/**
 * @Author: liming
 * @Date: 2018/11/15 17:18
 * @Description: DataSourceContextHolder
 */
public class DataSourceContextHolder {
    public static enum DataSourceType {
        MASTER,
        READ
    }

    private static final ThreadLocal<DataSourceType> contextHolder = new ThreadLocal<DataSourceType>();

    public static void read() {
        contextHolder.set(DataSourceType.READ);
    }

    public static void write() {
        contextHolder.set(DataSourceType.MASTER);
    }

    public final String get() {
        return contextHolder.get().name();
    }

}
