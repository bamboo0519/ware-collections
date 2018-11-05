package top.ibamboo.user.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import top.ibamboo.common.BambooResponse;
import top.ibamboo.user.api.model.WareUser;
import top.ibamboo.user.repository.persistant.WareUserRepository;

import javax.jws.soap.SOAPBinding;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/2/002.
 */

@Slf4j
@Controller
public class UserResourceController {

    @Autowired
    private WareUserRepository wareUserRepository;

    public UserResourceController() {
        log.info("构造方法");
        int i = 0;
        log.info("构造方法:{}", i++);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public BambooResponse<Integer> create(@RequestBody Map<String, String> params) {
        WareUser wareUser = new WareUser();
        wareUser.setUsername(params.get("username"));
        wareUser.setPassword((params.get("password")));
         wareUserRepository.save(wareUser);

        log.info("create[]wareUser:{}", wareUser);
        return BambooResponse.ok();
    }
}
