package com.project.qvick.domain.user.service.querydsl;

import com.project.qvick.domain.user.presentation.dto.User;
import com.project.qvick.domain.user.presentation.dto.request.UserApprovalPageRequest;
import com.project.qvick.domain.user.presentation.dto.response.UserPageResponse;
import com.project.qvick.global.common.dto.request.PageRequest;

import java.util.List;

public interface UserQueryService {

    List<UserPageResponse> findWaitingUsers(UserApprovalPageRequest request);

    List<User> userList(PageRequest pageRequest);
}
