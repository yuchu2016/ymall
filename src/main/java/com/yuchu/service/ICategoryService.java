package com.yuchu.service;

import com.yuchu.common.ServerResponse;
import com.yuchu.pojo.Category;

import java.util.List;

/**
 * @Author: yuchu
 * @Description:
 * @Date: Create in 10:44  2017/10/9
 * @Modified By:
 */
public interface ICategoryService {

    ServerResponse addCategory(String categoryName, Integer parentId);

    ServerResponse updateCategoryName(Integer categoryId,String categoryName);

    ServerResponse<List<Category>> getChildrenParallelCategory(Integer categoryId);

    ServerResponse<List<Integer>> selectCategoryAndChildrenById(Integer categoryId);
}
