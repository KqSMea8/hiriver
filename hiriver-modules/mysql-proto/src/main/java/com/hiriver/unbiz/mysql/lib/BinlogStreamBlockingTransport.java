package com.hiriver.unbiz.mysql.lib;

import com.hiriver.unbiz.mysql.lib.protocol.binlog.ValidBinlogOutput;
import com.hiriver.unbiz.mysql.lib.protocol.binlog.extra.BinlogPosition;

/**
 * 描述binlog数据流
 * 
 * @author hexiufeng
 * 
 */
public interface BinlogStreamBlockingTransport extends BlockingTransport {
    /**
     * 按照指定的同步点开启复制
     * 
     * @param binlogPos 同步点
     */
    void dump(BinlogPosition binlogPos);

    /**
     * 返回给上层有效的binglog event。所谓有效的binlog event参见{@link ValidBinlogOutput}。<br>
     * 
     * <b>注意</b><br>
     * 该方法为堵塞模式，如果不能从mysql server读取到有效的数据，调用方线程会一直被堵塞。<br>
     * 
     * 与本方法类似但非堵塞的方法是{@link BinlogStreamBlockingTransport#getBinlogOutputImmediately()}
     * 
     * @return {@link ValidBinlogOutput}对象
     */
    ValidBinlogOutput getBinlogOutput();

    
    ValidBinlogOutput getBinlogOutputImmediately();
}
