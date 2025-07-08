package itau_desafio_backend.spring.controller;

import java.time.OffsetDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import itau_desafio_backend.spring.dto.TransactionRequest;
import itau_desafio_backend.spring.model.Transaction;
import itau_desafio_backend.spring.service.TransactionService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/transacao")
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService =  transactionService;
    }

    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request){
            if(request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() <= 0){
                return ResponseEntity.unprocessableEntity().build();
            }
            transactionService.addTransaction(new Transaction(request.getDataHora(), request.getValor()));

            return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping
    public ResponseEntity<Void> clearTransactions(){
        transactionService.clearTransaction();
        return ResponseEntity.ok().build();
    }

}
