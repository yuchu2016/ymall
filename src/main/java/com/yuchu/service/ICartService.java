package com.yuchu.service;

import com.yuchu.common.ServerResponse;
import com.yuchu.vo.CartVo;

/**
 * @Author: yuchu
 * @Description:
 * @Date: Create in 14:44  2017/10/16
 * @Modified By:
 */
public interface ICartService {

    ServerResponse<CartVo> add(Integer userId, Integer productId, Integer count);

    ServerResponse<CartVo> update(Integer userId,Integer productId,Integer count);

    ServerResponse<CartVo> deleteProduct(Integer userId,String productIds);

    ServerResponse<CartVo> list(Integer userId);

    ServerResponse<CartVo> selectOrUnSelect(Integer userId,Integer productId,Integer checked);

    ServerResponse<Integer> getCartProductCount(Integer userId);
}
