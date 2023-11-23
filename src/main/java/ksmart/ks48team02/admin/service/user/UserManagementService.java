package ksmart.ks48team02.admin.service.user;

import ksmart.ks48team02.admin.dto.UserManagement;
import ksmart.ks48team02.admin.mapper.user.UserManagementMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserManagementService {

    private final UserManagementMapper userManagementMapper;

    public List<UserManagement> getLoginLogById(String memberId){
        return userManagementMapper.getLoginLogById(memberId);
    }
}
