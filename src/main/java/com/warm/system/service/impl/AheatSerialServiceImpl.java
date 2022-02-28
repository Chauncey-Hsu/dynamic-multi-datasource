package com.warm.system.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.warm.system.entity.AheatSerial;
import com.warm.system.mapper.AheatSerialMapper;
import com.warm.system.service.db1.AheatSerialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author dgd123
 * @since 2018-02-10
 */
@Service
public class AheatSerialServiceImpl extends ServiceImpl<AheatSerialMapper, AheatSerial> implements AheatSerialService {
    @Autowired
    private AheatSerialMapper aheatSerialMapper;


    @Override
    public Integer insert1(AheatSerial aheatSerial) {
        return aheatSerialMapper.insert(aheatSerial);
    }

    @Override
    public Integer sumSum() {
        return aheatSerialMapper.sumSum();
    }

    @Override
    public AheatSerial getColdest() {
        List<AheatSerial> list = aheatSerialMapper.getColdest();
        return list.get(0);
    }

    @Override
    public void deleteById1(Integer id) {
        deleteById(id);
    }

    @Override
    public AheatSerial selectById1(Integer cacheId) {
        return selectById(cacheId);
    }

    @Override
    public void updateById1(AheatSerial aheatSerial) {
        updateById(aheatSerial);
    }
}
