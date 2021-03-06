package com.lhiot.uc.basic.service;

import com.leon.microx.util.StringUtils;
import com.leon.microx.web.result.Pages;
import com.leon.microx.web.result.Tuple;
import com.lhiot.uc.basic.entity.ApplyUser;
import com.lhiot.uc.basic.mapper.ApplyUserMapper;
import com.lhiot.uc.basic.model.QuerySearch;
import com.lhiot.uc.basic.model.UserDetailResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangfeng created in 2018/9/7 11:23
 **/
@Service
@Slf4j
@Transactional
public class UserService {
    private ApplyUserMapper applyUserMapper;

    public UserService(ApplyUserMapper applyUserMapper) {
        this.applyUserMapper = applyUserMapper;
    }

    /**
     * 根据业务用户ID查询用户信息
     *
     * @param applyUserId Long
     * @return UserDetailResult
     */
    public UserDetailResult findById(Long applyUserId) {
        return applyUserMapper.findById(applyUserId);
    }

    /**
     * 根据业务用户ID查询用户信息
     *
     * @param openId String
     * @return UserDetailResult
     */
    public UserDetailResult findByOpenId(String openId) {
        return applyUserMapper.findByOpenId(openId);
    }

    /**
     * 根据业务用户ID查询用户信息
     *
     * @param phone           String
     * @param applicationType String
     * @return UserDetailResult
     */
    public UserDetailResult findByPhone(String phone, String applicationType) {
        ApplyUser applyUser = new ApplyUser();
        applyUser.setApplicationType(applicationType);
        applyUser.setPhone(phone);
        return applyUserMapper.findByPhone(applyUser);
    }


    /**
     * 根据用户ID字符串集合查询用户集合
     *
     * @param ids String
     * @return Tuple<UserDetailResult>
     */
    public Tuple<UserDetailResult> findUsersByIds(String ids) {
        List<String> idList = Arrays.asList(StringUtils.commaDelimitedListToStringArray(ids));
        List<UserDetailResult> userList = applyUserMapper.findByIdList(idList);
        if (CollectionUtils.isEmpty(userList)) {
            return Tuple.of(new ArrayList<>());
        }
        return Tuple.of(userList);
    }

    /**
     * 根据业务用户手机号码集合查询用户集合
     *
     * @param phones String
     * @return Multiple<UserDetailResult>
     */
    public Tuple<UserDetailResult> findUsersByPhones(String phones) {
        List<String> phoneList = Arrays.asList(phones.split(","));
        List<UserDetailResult> userList = applyUserMapper.findByPhoneList(phoneList);
        if (CollectionUtils.isEmpty(userList)) {
            return Tuple.of(new ArrayList<>());
        }
        return Tuple.of(userList);
    }

    /**
     * 根据关键字模糊匹配手机号，或者用户昵称查询用户集合
     *
     * @param keyword String
     * @return Multiple
     */
    public Tuple<UserDetailResult> findByKeyword(String keyword) {
        keyword = "%" + keyword + "%";
        List<UserDetailResult> userList = applyUserMapper.findByKeyword(keyword);
        if (CollectionUtils.isEmpty(userList)) {
            return Tuple.of(new ArrayList<>());
        }
        return Tuple.of(userList);
    }

    public Pages<UserDetailResult> userQuery(QuerySearch querySearch){
       List<UserDetailResult> userList =  applyUserMapper.findQuery(querySearch);
      int total =  applyUserMapper.countByQuery(querySearch);
      return Pages.of(total,userList);
    }

    public boolean countById(Long id) {
        return applyUserMapper.countById(id) > 0;
    }

    /**
     * 修改用户头像，昵称，说明，地址，QQ，email，性别
     *
     * @param user ApplyUser
     * @return boolean
     */
    public boolean updateUserById(ApplyUser user) {
        return applyUserMapper.updateUserById(user) > 0;
    }

    public boolean updatePasswordById(ApplyUser user) {
        return applyUserMapper.updatePasswordById(user) > 0;
    }

    public boolean updatePaymentPermissionsById(ApplyUser user) {
        return applyUserMapper.updatePaymentPermissionsById(user) > 0;
    }

    public boolean updateUnionIdByUserId(ApplyUser user) {
        return applyUserMapper.updateUnionIdByUserId(user) > 0;
    }

    public boolean countByIdAndPassword(ApplyUser user) {
        return applyUserMapper.countByIdAndPassword(user) > 0;
    }
}
