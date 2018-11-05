package top.ibamboo.user.api.model;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/2/002.
 */

@Data
@Entity
@Slf4j
@Table(name="t_user")
public class WareUser implements Serializable {
    private static final long serialVersionUID = 1232142667878311232L;

    private static final int EXT_MAX_LENGTH = 1024;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    String userId;
    String nickname;
    String username;
    String password;
    String salt;
    String encrypt;
    String mobile;
    String email;
    String idCode;
    String ext;


    Integer version;
    /**
     * 状态枚举类
     */
    Short status;
    Date createdAt;
    Date updatedAt;

    public String getNickname() {
        if(Strings.isEmpty(nickname)) {
            return nickname;
        } else if(Strings.isEmpty(username)) {
            return username;
        } else if(Strings.isEmpty(mobile)) {
            return mobile;
        }
        return id.toString();
    }

    public Map getExt() {
        JSONObject jsonObject = JSON.parseObject(this.ext);
        return jsonObject.getInnerMap();
    }

    public static String extString(String key, Object value) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key,value);
        return jsonObject.toJSONString();
    }

    /**
     * 仅支持基本类型的object
     * 把当前信息添加到this.ext中
     * @param extJsonString json string
     * @return
     */
    public boolean setExt(String extJsonString) {
        Map<String, Object> extJson;
        try {
            extJson = JSONObject.parseObject(extJsonString).getInnerMap();
        }catch (Exception e) {
            log.error("setExt[]parameter is no a json string. param:{}", extJsonString);
            return false;
        }
        JSONObject jsonObject;
        if(this.ext != null) {
            jsonObject = JSONObject.parseObject(this.ext);
        } else {
          jsonObject = new JSONObject();
        }

        for(Map.Entry entry : extJson.entrySet()) {
            jsonObject.put(entry.getKey().toString(), entry.getValue());
        }
        String tmpExt = jsonObject.toJSONString();
        if(tmpExt != null && tmpExt.length() > EXT_MAX_LENGTH ) {
            log.error("setExt[]there is no buffer to story more extra information. current len:{}, final len:{}",
                    this.ext.length(), tmpExt.length());
            return false;
        }
        this.ext = tmpExt;
        return true;
    }

    private boolean clearAndSetExt(String key, String extInfo) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(key, extInfo);
        String tmpExt = jsonObject.toJSONString();
        if(tmpExt != null && tmpExt.length() > EXT_MAX_LENGTH ) {
            log.error("setExt[]there is no buffer to story more extra information. current len:{}, final len:{}",
                    this.ext.length(), tmpExt.length());
            return false;
        }
        this.ext = tmpExt;
        return true;
    }
}
