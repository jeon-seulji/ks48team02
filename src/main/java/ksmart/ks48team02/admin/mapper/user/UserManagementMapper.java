package ksmart.ks48team02.admin.mapper.user;

import ksmart.ks48team02.admin.dto.UserManagement;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserManagementMapper {
    // 회원 로그인 내역 조회
    public List<UserManagement> getLoginLogById(String memberId, String startDate, String endDate);


}
