package chapter02.practise.org.mapper;

import chapter02.practise.org.model.SysRole;
import chapter02.practise.org.model.SysUser;

import java.util.List;

public interface UserMapper {

    /**
     * 通过id查询用户.
     *
     * @param id
     * @return
     */
    SysUser selectById(Long id);

    /**
     * 查询全部用户.
     *
     * @return
     */
    List<SysUser> selectAll();

    /**
     * 根据用户 id 获取角色信息
     *
     * @param userId
     * @return
     */
    List<SysRole> selectRolesByUserId(Long userId);

    /**
     * 新增用户.
     *
     * @param sysUser
     * @return
     */
    int insert(SysUser sysUser);

    /**
     * 新增用户 - 使用 useGeneratedKeys 方式
     *
     * @param sysUser
     * @return
     */
    int insert2(SysUser sysUser);
}
