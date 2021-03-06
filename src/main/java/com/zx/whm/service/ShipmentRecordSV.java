package com.zx.whm.service;

import com.zx.whm.common.domain.ResultDTO;
import com.zx.whm.domain.ShipmentRecord;
import com.zx.whm.domain.SysUser;
import com.zx.whm.vo.ShipmentRecordStats;
import com.zx.whm.vo.ShipmentRecordVo;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: zhangfz3
 * Date: 2017/4/15
 * Time: 13:33
 * Tel:18665598790
 * Email:zhangfz3@asiainfo.com
 */
public interface ShipmentRecordSV {
    public ResultDTO queryPageList(final ShipmentRecordVo shipmentRecordVo, ResultDTO<ShipmentRecord> resultDTO) throws Exception;
    void delete(long id);
    ShipmentRecord getRecord(long id);
    void save(SysUser user,ShipmentRecord shipmentRecord);
    ShipmentRecord getRecordByCreatorUserName(String  creatorName);
    List<ShipmentRecordStats> getRecordsByCreatorUserName(String  creatorName);
}
