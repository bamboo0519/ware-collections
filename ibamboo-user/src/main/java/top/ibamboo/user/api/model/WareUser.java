package top.ibamboo.user.api.model;

import lombok.Data;
import org.apache.logging.log4j.util.Strings;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Administrator on 2018/11/2/002.
 */

@Data
@Entity
@Table(name="t_user")
public class WareUser implements Serializable {
    private static final long serialVersionUID = 1232142667878311232L;

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
}
