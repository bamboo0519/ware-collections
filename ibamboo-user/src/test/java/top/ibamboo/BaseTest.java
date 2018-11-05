package top.ibamboo;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

/**
 * Created by Administrator on 2018/11/2/002.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@Transactional
@ActiveProfiles("UT")
public abstract class BaseTest {

}
