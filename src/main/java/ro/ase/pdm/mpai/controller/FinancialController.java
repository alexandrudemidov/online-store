package ro.ase.pdm.mpai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ase.pdm.mpai.service.FinancialReportService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/store/financialReport")
public class FinancialController {

    @Autowired
    FinancialReportService financialReportService;

    @GetMapping("/generate")
    @ResponseBody
    public String generateFinancialReport() {
        financialReportService.generateFinancialReport();
        return "Financial report was successfully generated.";
    }
}
