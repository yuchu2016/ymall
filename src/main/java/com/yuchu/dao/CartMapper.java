package com.yuchu.dao;

import com.yuchu.pojo.Cart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cart record);

    int insertSelective(Cart record);

    Cart selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cart record);

    int updateByPrimaryKey(Cart record);

    Cart selectCartByUserIdProductId(@Param("userId") Integer userId, @Param("productId") Integer productId);

    List<Cart> selectCartByUserId(Integer userId);

    Integer selectCartProductCheckStatusByUserId(@Param("userid") Integer userid);

    Integer deleteByUserIdProductIds(@Param("userId") Integer userId, @Param("productIdList") List<String> productIdList);

    Integer checkedOrUnCheckedProduct(@Param("userId") Integer userId, @Param("productId") Integer productId, @Param("checked") Integer checked);

    Integer selectCartProductCount(@Param("userId") Integer userId);
}