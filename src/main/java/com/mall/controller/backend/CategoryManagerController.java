package com.mall.controller.backend;

import com.mall.common.Const;
import com.mall.common.ResponseCode;
import com.mall.common.ServerResponse;
import com.mall.pojo.User;
import com.mall.service.ICategoryService;
import com.mall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by eid on 2017/12/4.
 */
@Controller
@RequestMapping("/manage/category")
public class CategoryManagerController {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private ICategoryService iCategoryService;

    @RequestMapping(value = "add_category.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse addCategory(HttpSession session, @RequestParam(value = "parentId", defaultValue = "0") int parentId, String categoryName) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登陆,请登陆");
        }
        //check admin role
        if (iUserService.checkAdminRole(user).isSuccess()){
            return iCategoryService.addCategory(parentId, categoryName);
        } else {
            return ServerResponse.createByErrorMessage("没有管理员权限操作");
        }
    }

    @RequestMapping(value = "set_category_name.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse setCategoryName(HttpSession session, int categoryId, String categoryName){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登陆,请登陆");
        }
        //check admin role
        if (iUserService.checkAdminRole(user).isSuccess()){
            return iCategoryService.updateCategoryName(categoryId, categoryName);
        } else {
            return ServerResponse.createByErrorMessage("没有管理员权限操作");
        }
    }

    @RequestMapping(value = "get_category.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getChildrenParallelCategory(HttpSession session, @RequestParam(value = "categoryid", defaultValue = "0") int categoryid){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登陆,请登陆");
        }
        //check admin role
        if (iUserService.checkAdminRole(user).isSuccess()){
            //查询字节点category信息,保持平级不递归
            return iCategoryService.getchilrenParallelCategory(categoryid);
        } else {
            return ServerResponse.createByErrorMessage("没有管理员权限操作");
        }
    }

    @RequestMapping(value = "get_deep_category.do", method = RequestMethod.GET)
    @ResponseBody
    public ServerResponse getCategoryAndDeepChildrenCategory(HttpSession session, @RequestParam(value = "categoryid", defaultValue = "0") int categoryid){
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorCodeMessage(ResponseCode.NEED_LOGIN.getCode(), "用户未登陆,请登陆");
        }
        //check admin role
        if (iUserService.checkAdminRole(user).isSuccess()){
            //查询字节点categoryId,递归查询字节点
            return iCategoryService.selectCategoryAndChildrenById(categoryid);
        } else {
            return ServerResponse.createByErrorMessage("没有管理员权限操作");
        }
    }
}
