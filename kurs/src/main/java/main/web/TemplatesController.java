package main.web;

import main.repository.ArticlesRepository;
import main.repository.BalanceRepository;
import main.repository.OperationsRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


    @Controller
    public class TemplatesController {
        private OperationsRepository operationsRepository;
        private ArticlesRepository articlesRepository;
        private BalanceRepository balanceRepository;


        @GetMapping("/operations")
        public String operations(Model model) {
            model.addAttribute("operations", operationsRepository.findAll());
            return "operations";
        }

        @GetMapping("/articles")
        public String articles(Model model) {
            model.addAttribute("articles", articlesRepository.findAll());
            return "articles";
        }

        @GetMapping("/balance")
        public String balance(Model model) {
            model.addAttribute("balance", balanceRepository.findAll());
            return "balance";
        }
}

