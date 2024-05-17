package com.project.qvick.domain.check.application.service;

import com.project.qvick.domain.check.presentation.dto.response.CheckCodeResponse;

import java.util.concurrent.CompletableFuture;

public interface CheckCodeService {

    CompletableFuture<CheckCodeResponse> generate();

}