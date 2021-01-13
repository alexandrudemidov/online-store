package ro.ase.pdm.mpai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ase.pdm.mpai.model.Transaction;
import ro.ase.pdm.mpai.service.TransactionService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/store/vendor")
public class VendorController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/addTransaction")
    @ResponseBody
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return transactionService.addVendorTransaction(transaction);
    }
}
