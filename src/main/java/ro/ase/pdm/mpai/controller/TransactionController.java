package ro.ase.pdm.mpai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ro.ase.pdm.mpai.model.Transaction;
import ro.ase.pdm.mpai.service.TransactionService;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/store/transactions")
public class TransactionController {

    @Autowired
    TransactionService transactionService;

    @PostMapping("/addTransaction")
    @ResponseBody
    public Transaction addTransaction(@RequestBody Transaction transaction){
        return transactionService.addTransaction(transaction);
    }

    @GetMapping
    @ResponseBody
    public List<Transaction> getAllTransactions() {
        return transactionService.getAllTransaction();
    }

    @GetMapping("/{date}")
    @ResponseBody
    public List<Transaction> getAllTransactionsByDate(@PathVariable(value = "date") String date) {
        return transactionService.transactionsByDate(date);
    }

}
