package vn.edu.iuh.fit.lab05;

import com.neovisionaries.i18n.CountryCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import vn.edu.iuh.fit.lab05.backend.models.Address;
import vn.edu.iuh.fit.lab05.backend.models.Candidate;
import vn.edu.iuh.fit.lab05.backend.services.AddressService;
import vn.edu.iuh.fit.lab05.backend.services.CandidateService;

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
//    @Bean
    CommandLineRunner initData(){
        return args ->{
            Random rnd = new Random();
            for (int i = 1; i<1000; i++){
                Address address = new Address(rnd.nextInt(1,1000)+"", "Qung Trung", "HCM", CountryCode.VN, rnd.nextInt(70000, 80000)+"");
                addressService.add(address);
                Candidate candidate = new Candidate("Name #"+i, LocalDate.of(1999, rnd.nextInt(1,13), rnd.nextInt(1, 29)), rnd.nextLong(1111111111L, 9999999999L)+"", "email" +i, address);
                candidateService.add(candidate);
                System.out.println("Added: "+candidate);
            }
        };
    }
}
