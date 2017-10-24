package com.yuchu.service;

import com.github.pagehelper.PageInfo;
import com.yuchu.common.ServerResponse;
import com.yuchu.pojo.Shipping;

/**
 * @Author: yuchu
 * @Description:
 * @Date: Create in 9:39  2017/10/24
 * @Modified By:
 */
public interface IShippingService {

    ServerResponse add(Integer userId, Shipping shipping);

    ServerResponse<String> del(Integer userId,Integer shippingId);

    ServerResponse update(Integer userId, Shipping shipping);

    ServerResponse<Shipping> select(Integer userId,Integer shippingId);

    ServerResponse<PageInfo> list(Integer userId, Integer pageNum, Integer pageSize);
}
