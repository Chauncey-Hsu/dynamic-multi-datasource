package com.warm.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.warm.common.DBTypeEnum;
import com.warm.common.DataSourceSwitch;
import com.warm.system.entity.AccessSerial;
import com.warm.system.entity.User;
import com.warm.system.mapper.AccessSerialMapper;
import com.warm.system.mapper.OrderMapper;
import com.warm.system.mapper.UserMapper;
import com.warm.system.service.db1.AccessSerialService;
import com.warm.system.service.db1.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@Service
public class AccessSerialServiceImpl extends ServiceImpl<AccessSerialMapper, AccessSerial> implements AccessSerialService {
    @Autowired
    private AccessSerialMapper accessSerialMapper;


    @Override
    public Integer save(AccessSerial accessSerial) {
        return accessSerialMapper.insert(accessSerial);
    }

    @Override
    public Integer getF(Integer cacheId) {
        return accessSerialMapper.getF(cacheId);
    }

    @Override
    public AccessSerial selectById1(int tailId) {
        return selectById(tailId);
    }

    @Override
    public void deleteById1(int tailId) {
        deleteById(tailId);
    }
}
