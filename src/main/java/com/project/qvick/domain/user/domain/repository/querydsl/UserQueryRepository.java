package com.project.qvick.domain.user.domain.repository.querydsl;


import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.domain.user.presentation.dto.request.UserApprovalPageRequest;
import com.project.qvick.domain.user.presentation.dto.response.UserPageResponse;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface UserQueryRepository {

    List<UserPageResponse> findWaitingUsers(UserApprovalPageRequest request);

    List<User> userList(PageRequest request);
}
