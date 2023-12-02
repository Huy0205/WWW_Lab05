package vn.edu.iuh.fit.lab05;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.lab05.backend.models.*;
import vn.edu.iuh.fit.lab05.backend.services.*;

import java.time.LocalDate;
import java.util.Random;

@SpringBootApplication
public class Lab05Application {

    public static void main(String[] args) {
        SpringApplication.run(Lab05Application.class, args);
    }
    @Autowired
    private CandidateService candidateService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private CandidateSkillService candidateSkillService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private ExperienceService experienceService;
    @Autowired
    private JobService jobService;
    @Autowired
    private JobSkillService jobSkillService;
    @Autowired
    private SkillService skillService;
//    @Bean
    CommandLineRunner initData(){
        return args ->{
            Random rnd = new Random();
            for (int i = 1; i<10; i++){
                Address address = new Address(rnd.nextInt(1,1000)+"", "Qung Trung", "HCM", CountryCode.VN, rnd.nextInt(70000, 80000)+"");
                addressService.add(address);

                Candidate candidate = new Candidate("Name #"+i, LocalDate.of(1999, rnd.nextInt(1,13), rnd.nextInt(1, 29)), rnd.nextLong(1111111111L, 9999999999L)+"", "email" +i, address);
                candidateService.add(candidate);

                Skill skill = new Skill("skill "+i, (byte) 1, "description skill " + i);
                skillService.add(skill);

                Company company = new Company("Company "+i, "email company "+i, rnd.nextLong(1111111111L, 9999999999L)+"", "about "+i, "webURL "+i, address);
                companyService.add(company);

                Job job = new Job("Job "+i, "description "+i, company);
                jobService.add(job);

                Experience experience = new Experience("role "+i, LocalDate.of(2020, 02, 02), LocalDate.of(2023, 01, 01), "work description "+ i, candidate, company);
                experienceService.add(experience);

                JobSkill jobSkill = new JobSkill(job, skill, (byte) 3, "moreInfos job skill "+ i);
                jobSkillService.add(jobSkill);

                CandidateSkill candidateSkill = new CandidateSkill(candidate, skill, (byte) 2, "moreInfos candidate skill "+ i);
                System.out.println(candidateSkill);
                candidateSkillService.add(candidateSkill);
            }
        };
    }
}
