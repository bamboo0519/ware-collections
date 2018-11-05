package top.ibamboo.user.api.model;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Administrator on 2018/11/5/005.
 */
public class WareUserTests {

    @Test
    public void test_setExt_normal_case(){
        WareUser user = new WareUser();
        Integer myCount = 100;
        Boolean bool  = true;
        user.setExt(WareUser.extString("myCount", myCount));
        Assert.assertEquals("{myCount=100}", user.getExt().toString());

        user.setExt(WareUser.extString("bool", bool));
        Assert.assertEquals("{bool=true, myCount=100}", user.getExt().toString());

        Assert.assertEquals(true, user.getExt().get("bool"));
        Assert.assertEquals(100, user.getExt().get("myCount"));
    }

}
