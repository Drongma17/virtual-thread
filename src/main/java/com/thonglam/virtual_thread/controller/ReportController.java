package com.thonglam.virtual_thread.controller;


import com.thonglam.virtual_thread.service.PlatformReportService;
import com.thonglam.virtual_thread.service.ReportService;
import com.thonglam.virtual_thread.service.VirtualReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @Autowired
    private PlatformReportService platformReportService;

    @Autowired
    private VirtualReportService virtualReportService;

    @PostMapping("/{region}")
    public ResponseEntity<String> generateReport(@PathVariable String region) {
        reportService.generateReportForRegion(region);
        return ResponseEntity.ok( "✅ report started for region: " + region);
    }

    @PostMapping("/platform/{region}")
    public ResponseEntity<String> generateReportPlatform(@PathVariable String region) {
        platformReportService.generateReportForRegion(region);
        return ResponseEntity.ok( "✅ Platform report started for region: " + region);
    }

    @PostMapping("/virtual/{region}")
    public ResponseEntity<String> generateReportVirtual(@PathVariable String region) {
        virtualReportService.generateReportForRegion(region);
        return ResponseEntity.ok( "✅ Virtual report started for region: " + region);
    }

}