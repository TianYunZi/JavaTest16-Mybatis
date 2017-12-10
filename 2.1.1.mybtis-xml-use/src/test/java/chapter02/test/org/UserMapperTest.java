package chapter02.test.org;

import chapter02.practise.org.mapper.UserMapper;
import chapter02.practise.org.model.SysRole;
import chapter02.practise.org.model.SysUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;
import java.util.List;

public class UserMapperTest extends BaseMapperTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserMapperTest.class);

    @Test
    public void testSelectById() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            SysUser user = userMapper.selectById(1L);
            Assert.assertNotNull(user);
            Assert.assertEquals("admin", user.getUserName());
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void testAll() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用 selectAll 方法查询所有用户
            List<SysUser> userList = userMapper.selectAll();
            //结果不为空
            Assert.assertNotNull(userList);
            //用户数量大于 0 个
            Assert.assertTrue(userList.size() > 0);
        } finally {
            //不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testSelectRolesByUserId() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //调用 selectRolesByUserId 方法查询用户的角色
            List<SysRole> roleList = userMapper.selectRolesByUserId(1L);
            //结果不为空
            Assert.assertNotNull(roleList);
            //角色数量大于 0 个
            Assert.assertTrue(roleList.size() > 0);
        } finally {
            //不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }

    @Test
    public void testInsert() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个 user 对象
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            //正常情况下应该读入一张图片存到 byte 数组中
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            //将新建的对象插入数据库中，特别注意，这里的返回值 result 是执行的 SQL 影响的行数
            int result = userMapper.insert(user);
            //只插入 1 条数据
            Assert.assertEquals(1, result);
            //id 为 null，我们没有给 id 赋值，并且没有配置回写 id 的值
            Assert.assertNull(user.getId());
        } finally {
            sqlSession.rollback();
            sqlSession.close();
        }
    }

    @Test
    public void testInsert2() {
        SqlSession sqlSession = getSqlSession();
        try {
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            //创建一个 user 对象
            SysUser user = new SysUser();
            user.setUserName("test1");
            user.setUserPassword("123456");
            user.setUserEmail("test@mybatis.tk");
            user.setUserInfo("test info");
            user.setHeadImg(new byte[]{1, 2, 3});
            user.setCreateTime(new Date());
            int result = userMapper.insert2(user);
            //只插入 1 条数据
            Assert.assertEquals(1, result);
            //因为 id 回写，所以 id 不为 null
            LOGGER.info("primary key: {}", user.getId());
            Assert.assertNotNull(user.getId());

        } finally {
            sqlSession.commit();
            //不要忘记关闭 sqlSession
            sqlSession.close();
        }
    }
}
