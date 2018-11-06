package top.ibamboo.user.web.controller;

import lombok.Data;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.ibamboo.common.BambooResponse;
import top.ibamboo.user.business.ShiroLoginAuthBusiness;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/6/006.
 */

@Controller
public class LoginAuthController {
    @Autowired
    private ShiroLoginAuthBusiness shiroLoginAuthBusiness;

    @Data
    public static class CommonLoginToken implements AuthenticationToken {
        String loginAuthChannelCode;
        Object principal;
        Object credentials;
    }

    /**
     * 异步登录请求
     * @param request
     * @param response
     * @param loginAuthParams
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/anonApi/v1/uaa/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public BambooResponse asyncLogin(HttpServletRequest request, HttpServletResponse response,
                        @RequestBody Map<String, Object> loginAuthParams) throws Exception {
        // TODO: 2018/11/6/006 loginAuthParams入参检查，

        // TODO: 2018/11/6/006 获取请求应用（从cookie中取）

        // TODO: 2018/11/6/006 创建登录认证token
        BambooResponse bambooResponse = shiroLoginAuthBusiness.loginAuthBusiness();

        // TODO: 2018/11/6/006  根据登录结构返回登录认证状态

        return bambooResponse;
    }

    /**
     * 同步登录请求
     * @param request
     * @param response
     * @param loginAuthParams
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/anonApi/v1/uaa/sync/login", method = RequestMethod.POST)
    public String  syncLogin(HttpServletRequest request, HttpServletResponse response,
                                @RequestBody Map<String, Object> loginAuthParams) throws Exception {
        // TODO: 2018/11/6/006 loginAuthParams入参检查，

        // TODO: 2018/11/6/006 获取请求应用（从cookie中取）

        // TODO: 2018/11/6/006 创建登录认证token
        BambooResponse bambooResponse = shiroLoginAuthBusiness.loginAuthBusiness();

        // TODO: 2018/11/6/006  根据登录结构返回登录认证状态

        // TODO: 2018/11/6/006 重定向到指定页面
        return "redirect"+bambooResponse.getData().toString();
    }

}
