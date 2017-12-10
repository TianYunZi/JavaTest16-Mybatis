package chapter02.practise.org.mapper;

import chapter02.practise.org.model.SysPrivilege;
import chapter02.practise.org.provider.PrivilegeProvider;
import org.apache.ibatis.annotations.SelectProvider;

public interface PrivilegeMapper {

    @SelectProvider(type = PrivilegeProvider.class, method = "selectById")
    SysPrivilege selectById(Long id);
}
