package com.lhiot.uc.warehouse.service;

import com.leon.microx.web.result.Pages;
import com.lhiot.uc.warehouse.entity.WarehouseConvert;
import com.lhiot.uc.warehouse.mapper.WarehouseConvertMapper;
import com.lhiot.uc.warehouse.model.WarehouseConvertParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

/**
 * Description:仓库出入库记录明细服务类
 *
 * @author yijun
 * 2018/09/07
 */
@Service
@Transactional
public class WarehouseConvertService {

    private final WarehouseConvertMapper warehouseConvertMapper;

    @Autowired
    public WarehouseConvertService(WarehouseConvertMapper warehouseConvertMapper) {
        this.warehouseConvertMapper = warehouseConvertMapper;
    }

    /**
     * Description:根据id修改仓库出入库记录明细
     *
     * @param warehouseConvert WarehouseProductConvert
     * @return int
     */
    public int updateById(WarehouseConvert warehouseConvert) {
        return this.warehouseConvertMapper.updateById(warehouseConvert);
    }

    /**
     * Description:根据ids删除仓库出入库记录明细
     *
     * @param ids String
     * @return int
     */
    public int deleteByIds(String ids) {
        return this.warehouseConvertMapper.deleteByIds(Arrays.asList(ids.split(",")));
    }

    /**
     * Description:根据id查找仓库出入库记录明细
     *
     * @param id Long
     * @return WarehouseProductConvert
     */
    public WarehouseConvert selectById(Long id) {
        return this.warehouseConvertMapper.selectById(id);
    }

    /**
     * Description: 查询仓库出入库记录明细分页列表
     *
     * @param param WarehouseConvertParam
     * @return Pages<WarehouseProductConvert>
     */
    public Pages<WarehouseConvert> pageList(WarehouseConvertParam param) {
        return Pages.of(this.warehouseConvertMapper.warehouseConvertCountById(param.getWarehouseId()), this.warehouseConvertMapper.pageWarehouseConverts(param));
    }
}

