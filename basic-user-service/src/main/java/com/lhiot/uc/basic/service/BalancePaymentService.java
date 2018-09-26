package com.lhiot.uc.basic.service;

import com.leon.microx.util.Maps;
import com.leon.microx.util.Retry;
import com.lhiot.uc.basic.entity.BalanceLog;
import com.lhiot.uc.basic.mapper.BalanceLogMapper;
import com.lhiot.uc.basic.mapper.BaseUserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;

/**
 * @author zhangfeng created in 2018/9/12 10:51
 **/
@Service
@Slf4j
@Transactional
public class BalancePaymentService {
    private BaseUserMapper baseUserMapper;
    private BalanceLogMapper balanceLogMapper;

    public BalancePaymentService(BaseUserMapper baseUserMapper, BalanceLogMapper balanceLogMapper) {
        this.baseUserMapper = baseUserMapper;
        this.balanceLogMapper = balanceLogMapper;
    }

    /**
     * 用户扣除鲜果币
     *
     * @param baseUserId     基础用户Id
     * @param operationMoney 需要扣除的金额
     * @return
     */
    public boolean subCurrency(Long balance, Long operationMoney, Long baseUserId) {
        Retry<Boolean> retry = Retry.of(() -> {
            int count = baseUserMapper.updateCurrencyByIdForSub(Maps.of("id", baseUserId, "balance", balance, "money", operationMoney));
            if (count <= 0) {
                throw new RuntimeException("减鲜果币失败！");
            }
            return true;
        }).count(3).intervalMs(30L).run();
        if (Objects.nonNull(retry.exception())) {
            return false;
        }
        return retry.result();
    }

    /**
     * 增加鲜果币
     *
     * @param baseUserId     Long
     * @param operationMoney Long
     * @return boolean
     */
    public boolean addCurrency(Long baseUserId, Long operationMoney) {
        return baseUserMapper.updateCurrencyByIdForAdd(Maps.of("id", baseUserId, "money", operationMoney)) > 0;
    }

    public boolean addCurrencyLog(BalanceLog balanceLog) {
        return balanceLogMapper.insert(balanceLog) > 0;
    }

    public Long findCurrencyById(Long baseUserId) {
        return baseUserMapper.findCurrencyById(baseUserId);
    }
}
