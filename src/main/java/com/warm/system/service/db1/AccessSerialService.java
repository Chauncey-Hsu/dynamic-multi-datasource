package com.warm.system.service.db1;

import com.baomidou.mybatisplus.service.IService;
import com.warm.system.entity.AccessSerial;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
public interface AccessSerialService extends IService<AccessSerial> {

    /**
     *
     * @param accessSerial setedId
     * @return 更新行数
     */
    Integer save(AccessSerial accessSerial);

    Integer getF(Integer cacheId);

    AccessSerial selectById1(int tailId);

    void deleteById1(int tailId);
}
