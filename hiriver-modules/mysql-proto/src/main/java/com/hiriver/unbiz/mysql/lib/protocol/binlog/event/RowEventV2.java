package com.hiriver.unbiz.mysql.lib.protocol.binlog.event;

import com.hiriver.unbiz.mysql.lib.protocol.Position;
import com.hiriver.unbiz.mysql.lib.protocol.binlog.BinlogEvent;
import com.hiriver.unbiz.mysql.lib.protocol.binlog.TableMetaProvider;
import com.hiriver.unbiz.mysql.lib.protocol.datautils.MysqlNumberUtils;
import com.hiriver.unbiz.mysql.lib.protocol.datautils.MysqlStringUtils;

public class RowEventV2 extends RowEventV1 implements BinlogEvent {

    public RowEventV2(TableMapEvent tableMapEvent, TableMetaProvider tableMetaProvider, int eventType,
            final long eventBinlogPos, boolean hasCheckSum) {
        super(tableMapEvent, tableMetaProvider, eventType, eventBinlogPos, hasCheckSum);
    }

    @Override
    protected void parseVerPostHeader(byte[] buf, Position pos) {
        int len = MysqlNumberUtils.read2Int(buf, pos);
        MysqlStringUtils.readFixString(buf, pos, len);
        pos.forwardPos();
    }
}
