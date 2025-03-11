//package com.htps.service;
//
//import com.htps.dto.ProgressDTO;
//import com.htps.entities.Progress;
//import com.htps.repository.ProgressRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class ProgressServiceImpl implements ProgressService {
//
//    @Autowired
//    private ProgressRepository progressRepository;
//
//    @Override
//    public ProgressDTO getProgressByUserId(Long userId) {
//        Progress progress = progressRepository.findByUserId(userId);
//        return new ProgressDTO(progress.getUserId(), progress.getWeight(), progress.getBodyFatPercentage(), progress.getStatus());
//    }
//
//    @Override
//    public void updateProgress(Long userId, ProgressDTO progressDTO) {
//        Progress progress = new Progress();
//        progress.setUserId(userId);
//        progress.setWeight(progressDTO.getWeight());
//        progress.setBodyFatPercentage(progressDTO.getBodyFatPercentage());
//        progress.setStatus(progressDTO.getStatus());
//        progressRepository.save(progress);
//    }
//}


package com.htps.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.htps.dto.ProgressDTO;
import com.htps.entities.Progress;
import com.htps.entities.User;
import com.htps.repository.ProgressRepository;
import com.htps.repository.UserRepository;

@Service
public class ProgressServiceImpl implements ProgressService {

    @Autowired
    private ProgressRepository progressRepository;

    @Autowired
    private UserRepository userRepository; // Add this to retrieve User

    @Override
    public ProgressDTO getProgressByUserId(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Progress progress = progressRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("Progress not found for user ID: " + userId));

        return new ProgressDTO(user.getUserId(), progress.getWeight(), progress.getBodyFatPercentage(), progress.getStatus());
    }

    @Override
    public void updateProgress(Long userId, ProgressDTO progressDTO) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with ID: " + userId));

        Progress progress = progressRepository.findByUser(user)
                .orElse(new Progress()); // If no progress exists, create a new one

        progress.setUser(user); // Set user reference
        progress.setWeight(progressDTO.getWeight());
        progress.setBodyFatPercentage(progressDTO.getBodyFatPercentage());
        progress.setStatus(progressDTO.getStatus());

        progressRepository.save(progress);
    }
}
