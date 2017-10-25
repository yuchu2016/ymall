package com.yuchu.service;

import com.yuchu.common.ServerResponse;

import java.util.Map;

/**
 * @Author: yuchu
 * @Description:
 * @Date: Create in 19:55  2017/10/24
 * @Modified By:
 */
public interface IOrderService {

    ServerResponse pay(Long orderNo, Integer userId, String path);

    ServerResponse aliCallBack(Map<String,String> params);

    ServerResponse queryOrderPayStatus(Integer userId,Long orderNo);
}
