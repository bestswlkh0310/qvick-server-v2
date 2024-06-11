package com.project.qvick.domain.user.client.api;

import com.project.qvick.domain.user.application.query.UserQueryService;
import com.project.qvick.domain.user.client.dto.User;
import com.project.qvick.domain.user.client.dto.request.UserSearchRequest;
import com.project.qvick.global.common.dto.request.PageRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user-admin")
@Tag(name = "유저 관리자", description = "유저 관리자 API")
public class UserAdminController {

    private final UserQueryService userQueryService;

    @GetMapping("/find-all")
    @Operation(summary = "전체 유저 조회", description = "전체 유저를 조회합니다")
    public ResponseEntity<List<User>>userList(@ModelAttribute PageRequest pageRequest){
        return ResponseEntity.ok(userQueryService.userList(pageRequest));
    }

    @GetMapping("/student-all")
    @Operation(summary = "전체 학생 조회", description = "전체 학생을 조회합니다")
    public ResponseEntity<List<User>>studentList(@ModelAttribute PageRequest pageRequest){
        return ResponseEntity.ok(userQueryService.studentList(pageRequest));
    }

    @GetMapping("/search")
    @Operation(summary = "유저 검색", description = "특정 유저를 이름을 기준으로 검색합니다")
    public ResponseEntity<List<User>>userSearch(@ModelAttribute UserSearchRequest searchRequest){
        return ResponseEntity.ok(userQueryService.userSearch(searchRequest));
    }

    @GetMapping("/check")
    @Operation(summary = "출석 체크 조회", description = "출석 확인자 명단을 조회합니다.")
    public ResponseEntity<List<User>>checkList(@ModelAttribute PageRequest pageRequest){
        return ResponseEntity.ok(userQueryService.checkUsers(pageRequest));
    }

    @GetMapping("/non-check")
    @Operation(summary = "출석 체크 조회", description = "출석 확인자 명단을 조회합니다.")
    public ResponseEntity<List<User>>nonCheckList(@ModelAttribute PageRequest pageRequest){
        return ResponseEntity.ok(userQueryService.nonCheckUsers(pageRequest));
    }

}
