package top.ibamboo.user.repository.persistant;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import top.ibamboo.user.api.model.WareUser;

/**
 * Created by Administrator on 2018/11/2/002.
 */
@Repository
public interface WareUserRepository extends JpaRepository<WareUser,Long> {
    WareUser findByUsername(String username);
    WareUser findByMobile(String mobile);
}
