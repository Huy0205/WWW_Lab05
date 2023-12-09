package vn.edu.iuh.fit.lab05.frontend.controllers;

import com.neovisionaries.i18n.CountryCode;
import jakarta.jws.WebParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import vn.edu.iuh.fit.lab05.backend.models.Address;
import vn.edu.iuh.fit.lab05.backend.models.Candidate;
import vn.edu.iuh.fit.lab05.backend.models.Job;
import vn.edu.iuh.fit.lab05.backend.services.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Controller
public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @Autowired
    private CandidateSkillService candidateSkillService;

    @Autowired
    private ExperienceService experienceService;

    @Autowired
    private AddressService addressService;

    @Autowired
    private JobService jobService;

    @GetMapping("/list")
    public String showCandidates(Model model){
        model.addAttribute("candidates", candidateService.getAll());
        return "candidates/candidates";
    }

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

    @GetMapping("/candidates/add")
    public String navigateAddPage(Model model) {
        Candidate candidate = new Candidate();
        Address address = new Address();
        candidate.setAddress(address);

        model.addAttribute("candidate", candidate);
        model.addAttribute("countryCodes", CountryCode.values());
        return "/candidates/add";
    }

    @PostMapping("/candidates/add")
    public String add(@ModelAttribute("candidate") Candidate candidate, Model model, RedirectAttributes redirectAttributes) {
        if(candidateService.finCandidateByPhone(candidate.getPhone()) == null){
            Address address = addressService.findAddressExist(candidate.getAddress());
            System.out.println(address);
            if(address == null){
                addressService.add(candidate.getAddress());
            }
            candidate.setAddress(address);
            candidateService.save(candidate);
            redirectAttributes.addFlashAttribute("messages", "Candidate " + candidate.getFullName() + " has been added success!");
            return "redirect:/candidates";
        }
        model.addAttribute("messages", "This candidate has existed");
        model.addAttribute("candidate", candidate);
        model.addAttribute("countryCodes", CountryCode.values());
        return "/candidates/add";
    }

    @GetMapping("/candidates/update")
    public String navigateUpdatePage(@RequestParam("id") long id, Model model) {
        Candidate candidate = candidateService.findCandidateById(id).get();

        model.addAttribute("candidate", candidate);
        model.addAttribute("countryCodes", CountryCode.values());
        return "/candidates/update";
    }

    public void handleUpdateCandidate(Candidate oldCandidate, Candidate candidate, RedirectAttributes redirectAttributes){
        Address address = addressService.findAddressExist(candidate.getAddress());
        if(address == null){
            addressService.add(candidate.getAddress());
        }
        candidateService.save(candidate);
        redirectAttributes.addFlashAttribute("messages", "Candidate " + candidate.getFullName() + " has been updated success!");
    }

    @PostMapping("/candidates/update")
    public String update(@ModelAttribute("candidate") Candidate candidate, Model model, RedirectAttributes redirectAttributes) {
        Candidate oldCandidate = candidateService.findCandidateById(candidate.getId()).get();
        if(oldCandidate.getPhone().equals(candidate.getPhone()) || candidateService.finCandidateByPhone(candidate.getPhone()) == null){
            handleUpdateCandidate(oldCandidate, candidate, redirectAttributes);
            return "redirect:/candidates";
        }
        model.addAttribute("messages", "This candidate has existed");
        model.addAttribute("candidate", candidate);
        model.addAttribute("countryCodes", CountryCode.values());
        return "/candidates/update";
    }

    @GetMapping("/candidates/delete")
    public String delete(@RequestParam("id") long id, RedirectAttributes redirectAttributes){
        candidateSkillService.deleteAllByCandidateId(id);
        experienceService.deleteAllByCandidateId(id);
        Optional<Candidate> candidate = candidateService.delete(id);
        redirectAttributes.addFlashAttribute("messages", "Candidate " + candidate.get().getFullName() + " has been deleted success!");
        return "redirect:/candidates";
    }

    @GetMapping("/login")
    public String showLoginPage(){
        return "candidates/login";
    }

    @GetMapping("/login/suggestJob")
    public String showSuggestJobPage(@RequestParam("phone") String phone, @RequestParam("page")Optional<Integer> page, @RequestParam("size") Optional<Integer> size, Model model, RedirectAttributes redirectAttributes){
        Candidate candidate = candidateService.finCandidateByPhone(phone);
        if(candidate == null){
            redirectAttributes.addFlashAttribute("messages", "The phone number is not correct!");
            return "redirect:/login";
        }
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(10);

        Page<Job> jobPage = jobService.getSuggestJob(candidate.getId(), currentPage - 1, pageSize);
        model.addAttribute("jobPage", jobPage);
        int totalPage = jobPage.getTotalPages();
        if(totalPage > 0){
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPage).boxed().collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        model.addAttribute("candidate", candidate);
        return "jobs/JobSuggest";
    }
}
