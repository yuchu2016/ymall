package com.yuchu.service;

import com.github.pagehelper.PageInfo;
import com.yuchu.common.ServerResponse;
import com.yuchu.pojo.Product;
import com.yuchu.vo.ProductDetailVo;

/**
 * @Author: yuchu
 * @Description:
 * @Date: Create in 3:23 PM  10/9/2017
 * @Modified By:
 */
public interface IProductService {

    ServerResponse saveOrUpdateProdcut(Product product);

    ServerResponse<String> setSaleStatus(Integer productId,Integer status);

    ServerResponse<ProductDetailVo> manageProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductList(Integer pageNum, Integer pageSize);

    ServerResponse<PageInfo> searchProduct(String productName,Integer productId,Integer pageNum,Integer pageSize);

    ServerResponse<ProductDetailVo> getProductDetail(Integer productId);

    ServerResponse<PageInfo> getProductByKeywordCategory(String keyword,Integer categoryId,Integer pageNum,Integer pageSize,String orderBy);
}
