package com.macfu.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author: liming
 * @Date: 2018/11/15 22:23
 * @Description:
 */
public class DynamicDataSource extends AbstractRoutingDataSource {
    private final AtomicLong readCount;
    private final AtomicLong writeCount;
    private final int writeDataSourceNumber;
    private final int readdDataSourceNumber;

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.DataSourceType.MASTER.name() + "" +
                this.writeCount.getAndAdd(1L) % (long) this.writeDataSourceNumber;
    }

    public DynamicDataSource(int writeDataSourceNumber, int readdDataSourceNumber) {
        this.writeDataSourceNumber = writeDataSourceNumber;
        this.readdDataSourceNumber = readdDataSourceNumber;
        this.readCount = new AtomicLong(0L);
        this.writeCount = new AtomicLong(0L);
    }
}
