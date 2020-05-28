package main.web;

import main.entity.Articles;
import main.entity.Balance;
import main.entity.Operations;
import main.exeption.ArticlesNotFoundExeption;
import main.exeption.BalanceNotFoundExeption;
import main.exeption.OperationsNotFoundExeption;
import main.service.ArticlesService;
import main.service.BalanceService;
import main.service.OperationsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
    @RequestMapping("/lib")
    public class LibraryController {
        private final OperationsService operationsService;
        private final ArticlesService articlesService;
        private final BalanceService balanceService;

        public LibraryController(OperationsService operationsService, ArticlesService articlesService, BalanceService balanceService) {
            this.operationsService = operationsService;
            this.articlesService = articlesService;
            this.balanceService = balanceService;
        }

        @PostMapping(value = "/addOperations", consumes = "application/json", produces = "application/json")
        public Operations addJournalRecord(@RequestBody Operations newOperations) {
            return operationsService.addOperations(newOperations);
        }

        @PostMapping(value = "/addArticles", consumes = "application/json", produces = "application/json")
        public Articles addClient(@RequestBody Articles newArticles) {
            return articlesService.addArticles(newArticles);
        }

        @PostMapping(value = "/addBalance", consumes = "application/json", produces = "application/json")
        public Balance addBook(@RequestBody Balance newBalance) {
            return balanceService.addBalance(newBalance);
        }

        @GetMapping("/operations")
        public ResponseEntity<List<Operations>> getOperations() {
            return new ResponseEntity<>(operationsService.operationlList(), HttpStatus.OK);
        }

        @GetMapping("/articles")
        public ResponseEntity<List<Articles>> getArticles() {
            return new ResponseEntity<>(articlesService.articlesList(), HttpStatus.OK);
        }

        @GetMapping("/books")
        public ResponseEntity<List<Balance>> getBalance() {
            return new ResponseEntity<>(balanceService.balanceList(), HttpStatus.OK);
        }


        @GetMapping("/operations/{id}")
        public ResponseEntity<Operations> getOperations(@PathVariable("id") int id) {
            try {
                return new ResponseEntity<>(operationsService.findOperations(id), HttpStatus.OK);
            } catch (OperationsNotFoundExeption exception) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Operations not found");
            }
        }

        @GetMapping("/articles/{id}")
        public ResponseEntity<Articles> getArticles(@PathVariable("id") int id) {
            try {
                return new ResponseEntity<>(articlesService.findArticles(id), HttpStatus.OK);
            } catch (ArticlesNotFoundExeption exception) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Articles not found");
            }
        }

        @GetMapping("/book/{id}")
        public ResponseEntity<Balance> getBalance(@PathVariable("id") int id) {
            try {
                return new ResponseEntity<>(balanceService.findBalance(id), HttpStatus.OK);
            } catch (BalanceNotFoundExeption exception) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Balance not found");
            }
        }


        @DeleteMapping("/operations/{id}")
        public void deleteOperations(@PathVariable("id") int id) {
            try {
                operationsService.deleteOperations(id);
            } catch (OperationsNotFoundExeption exception) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Operations not found");
            }
        }

        @DeleteMapping("/articles/{id}")
        public void deleteArticles(@PathVariable("id") int id) {
            try {
                articlesService.deleteArticles(id);
            } catch (ArticlesNotFoundExeption exception) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Articles not found");
            }
        }

        @DeleteMapping("/balance/{id}")
        public void deleteBook(@PathVariable("id") int id) {
            try {
                balanceService.deleteBalance(id);
            } catch (BalanceNotFoundExeption exception) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Balance not found");
            }
        }


        @PutMapping(value = "/operations/{id}", consumes = "application/json", produces = "application/json")
        public ResponseEntity<Operations> updateJournalRecord(@PathVariable("id") int id, @RequestBody Operations newOperations) {
            try {
                Operations updatedOperations = operationsService.findOperations(id);

                updatedOperations.setArticles(newOperations.getArticles());
                updatedOperations.setDebit(newOperations.getDebit());
                updatedOperations.setCredit(newOperations.getCredit());
                updatedOperations.setCreateDate(newOperations.getCreateDate());
                updatedOperations.setBalance(newOperations.getBalance());

                return ResponseEntity.ok(operationsService.addOperations(updatedOperations));
            } catch (OperationsNotFoundExeption exception) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Operations not found");
            }
        }

        @PutMapping(value = "/articles/{id}", consumes = "application/json", produces = "application/json")
        public ResponseEntity<Articles> updateClient(@PathVariable("id") int id, @RequestBody Articles newArticles) {
            try {
                Articles updatedArticles = articlesService.findArticles(id);

                updatedArticles.setName(newArticles.getName());


                return ResponseEntity.ok(articlesService.addArticles(updatedArticles));
            } catch (ArticlesNotFoundExeption exception) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Articles not found");
            }
        }

        @PutMapping(value = "/balance/{id}", consumes = "application/json", produces = "application/json")
        public ResponseEntity<Balance> updateBalance(@PathVariable("id") int id, @RequestBody Balance newBalance) {
            try {
                Balance updatedBalance = balanceService.findBalance(id);

                updatedBalance.setCreateDate(newBalance.getCreateDate());
                updatedBalance.setDebit(newBalance.getDebit());
                updatedBalance.setCredit(newBalance.getCredit());
                updatedBalance.setAmount(newBalance.getAmount());

                return ResponseEntity.ok(balanceService.addBalance(updatedBalance));
            } catch (BalanceNotFoundExeption exception) {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Balance not found");
            }
        }

    }
