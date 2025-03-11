//package com.htps.controller;
//
//import com.htps.dto.ProgressDTO;
//import com.htps.service.ProgressService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/progress")
//public class ProgressController {
//
//    @Autowired
//    private ProgressService progressService;
//
//    @GetMapping("/{userId}")
//    public ProgressDTO getProgress(@PathVariable Long userId) {
//        return progressService.getProgressByUserId(userId);
//    }
//
//    @PostMapping("/{userId}")
//    public void updateProgress(@PathVariable Long userId, @RequestBody ProgressDTO progressDTO) {
//        progressService.updateProgress(userId, progressDTO);
//    }
//}
package com.htps.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htps.dto.ProgressDTO;
import com.htps.service.ProgressService;

@RestController
@RequestMapping("/api/progress")
public class ProgressController {

    @Autowired
    private ProgressService progressService;

    @GetMapping("/{userId}")
    public ProgressDTO getProgress(@PathVariable Long userId) {
        return progressService.getProgressByUserId(userId);
    }

    @PostMapping("/{userId}")
    public void updateProgress(@PathVariable Long userId, @RequestBody ProgressDTO progressDTO) {
        progressService.updateProgress(userId, progressDTO);
    }
}
