package com.htps.service;

import com.htps.dto.ProgressDTO;

public interface ProgressService {

    ProgressDTO getProgressByUserId(Long userId);

    void updateProgress(Long userId, ProgressDTO progressDTO);
}
