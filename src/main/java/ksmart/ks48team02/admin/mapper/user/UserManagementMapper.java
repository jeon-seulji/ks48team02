package ksmart.ks48team02.admin.mapper.user;

import ksmart.ks48team02.admin.dto.UserManagement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserManagementMapper {
    public List<UserManagement> getLoginLogById(String memberId);
}
