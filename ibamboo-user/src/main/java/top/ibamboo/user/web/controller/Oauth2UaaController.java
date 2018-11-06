package top.ibamboo.user.web.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import top.ibamboo.common.BambooResponse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2018/11/6/006.
 */

@Controller
public class Oauth2UaaController {

    public static class Oauth2GetCodeParams{
        String clientId;
        String redirectUri;
        String state;
        String responseType;
        String loginAuthChannelCode;
    }

    /**
     * H4 + H5 + 多通道屏蔽方案，第三方用户中心对接入口
     * @param params
     * @return  重定向到某个页面
     * 所有条件满足，最终会重定向到 原始的redirectUri&code=xxxxx
     * 中间会涉及页面交互和跳转
     */
    @RequestMapping(value = "/anonApi/v2/oauth2/obtainCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String obtainCode(@RequestParam("oauth2GetCodeParam") Oauth2GetCodeParams params) {
        // TODO: 2018/11/6/006 检查浏览器类型以及loginAuthChannelCode，选择H4或者H5流程或者第三方登录认证

        // TODO: 2018/11/6/006 检查入参

        // TODO: 2018/11/6/006 检查clientId有效性，授权范围，判断在返回code之前，是否需要加入额外验证，例如 需要实时的进行活体认证

        // TODO: 2018/11/6/006 如果需要去第三方进行登录认证 ，拼装请求参数
        String response = "xxxx";
        if(response!=null && response.startsWith("redirect:")) {
            return "redirect:"+"xxxxx";
        }else{

        }


        // TODO: 2018/11/6/006 检查当前登录账号+该应用 属性，做出适当的提示


        // TODO: 2018/11/6/006 所有条件满足，返回code

        return "redirect:" + "redirectUri";
    }

    @RequestMapping(value = "/authApi/v2/oauth2/obtainToken", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public BambooResponse obtainToken() {

        return BambooResponse.ok();
    }

    /**
     * 从第三方平台接收code
     * @param
     * @return
     */
    @RequestMapping(value = "/anonApi/v2/oauth2/recvCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String recvCode(HttpServletRequest request, HttpServletResponse response) {

        // TODO: 2018/11/6/006 解析code 或者错误码

        // TODO: 2018/11/6/006 通过code获取token

        // TODO: 2018/11/6/006 通过token获取用户信息

        // TODO: 2018/11/6/006 用户信息关联，及冲突处理； 需要重定向到页面进行信息补全或者冲突处理
        if(false) {
            return "redirect:"+"xxxx";
        }

        // TODO: 2018/11/6/006 一切顺利，走到此处，重定向到getCode
        return "redirect:"+"/anonApi/v1/oauth2/getCode";



    }
}
