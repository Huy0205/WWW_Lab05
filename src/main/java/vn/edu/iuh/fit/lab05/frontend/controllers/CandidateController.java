package vn.edu.iuh.fit.lab05.frontend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import vn.edu.iuh.fit.lab05.backend.models.Candidate;
import vn.edu.iuh.fit.lab05.backend.services.CandidateService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CandidateController {
    @Autowired
    private CandidateService candidateService;
    @GetMapping("/candidates")
    public String showCandidateListPaging(Model model, @RequestParam("page")Optional<Integer> page, @RequestParam("size") Optional<Integer> size){
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);
        Page<Candidate> candidatePage = candidateService.findAll(currentPage - 1, pageSize, "id", "asc");
        model.addAttribute("candidatePage", candidatePage);
        int totalPage = candidatePage.getTotalPages();
        if(totalPage > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "candidates/candidates-paging";
    }
}