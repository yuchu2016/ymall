package com.yuchu.controller.backend;

import com.github.pagehelper.PageInfo;
import com.yuchu.common.Const;
import com.yuchu.common.ResponseCode;
import com.yuchu.common.ServerResponse;
import com.yuchu.pojo.User;
import com.yuchu.service.IOrderService;
import com.yuchu.service.IUserService;
import com.yuchu.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @Author: yuchu
 * @Description:
 * @Date: Create in 21:31  2017/10/25
 * @Modified By:
 */
@Controller
@RequestMapping("/manage/order")
public class OrderManageController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private IOrderService iOrderService;
    @RequestMapping("list.do")
    @ResponseBody
    public ServerResponse<PageInfo> orderList(HttpSession session,
                                              @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                              @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验一下是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //是管理员
            //增加我们处理分类的逻辑
            return iOrderService.manageList(pageNum,pageSize);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }
    @RequestMapping("detail.do")
    @ResponseBody
    public ServerResponse<OrderVo> orderDetail(HttpSession session, Long orderNo){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验一下是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //是管理员
            //增加我们处理分类的逻辑
            return iOrderService.manageDetail(orderNo);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping("search.do")
    @ResponseBody
    public ServerResponse<PageInfo> orderSearch(HttpSession session, Long orderNo,
                                                @RequestParam(value = "pageNum",defaultValue = "1") Integer pageNum,
                                                @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验一下是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //是管理员
            //增加我们处理分类的逻辑
            return iOrderService.manageSearch(orderNo,pageNum,pageSize);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

    @RequestMapping("send_goods.do")
    @ResponseBody
    public ServerResponse<String> orderSendGoods(HttpSession session, Long orderNo){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null){
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(),"用户未登录，请登录");
        }
        //校验一下是否是管理员
        if (iUserService.checkAdminRole(user).isSuccess()){
            //是管理员
            //增加我们处理分类的逻辑
          return iOrderService.manageSendGoods(orderNo);
        }else {
            return ServerResponse.createByErrorMessage("无权限操作，需要管理员权限");
        }
    }

}
