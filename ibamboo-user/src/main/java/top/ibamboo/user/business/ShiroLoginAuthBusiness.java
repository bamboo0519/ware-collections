package top.ibamboo.user.business;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Component;
import top.ibamboo.common.BambooResponse;
import top.ibamboo.user.web.controller.LoginAuthController;

/**
 * Created by Administrator on 2018/11/6/006.
 */

@Component
public class ShiroLoginAuthBusiness {
    public BambooResponse loginAuthBusiness() {
        LoginAuthController.CommonLoginToken commonLoginToken = new LoginAuthController.CommonLoginToken();

        // TODO: 2018/11/6/006 指向subject.login
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(commonLoginToken);
        }catch (Exception e) {

        }

        return BambooResponse.ok();
    }
}
