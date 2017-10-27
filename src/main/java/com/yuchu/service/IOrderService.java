package com.yuchu.service;

import com.github.pagehelper.PageInfo;
import com.yuchu.common.ServerResponse;
import com.yuchu.vo.OrderVo;

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

    ServerResponse createOrder(Integer userId,Integer shippingId);

    ServerResponse<String> cancel(Integer userId,Long orderNo);

    ServerResponse getOrderCartProduct(Integer userId);

    ServerResponse<OrderVo> getOrderDetail(Integer userId, Long orderNo);

    ServerResponse<PageInfo> getOrderList(Integer userId, Integer pageNum, Integer pageSize);

    //backend
    ServerResponse<PageInfo> manageList(Integer pageNum,Integer pageSize);

    ServerResponse<OrderVo> manageDetail(Long orderNo);

    ServerResponse<PageInfo> manageSearch(Long orderNo,Integer pageNum,Integer pageSize);

    ServerResponse<String> manageSendGoods(Long orderNo);
}
