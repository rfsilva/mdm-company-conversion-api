package br.com.rodrigo.mdm.company.controller;

import br.com.rodrigo.mdm.company.dto.*;
import br.com.rodrigo.mdm.company.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping("/id/{id}")
    public ResponseEntity<CompanyDTO> idToCompany(@PathVariable Long id) {
        CompanyDTO company = companyService.convertToObject(id);
        return Optional.ofNullable(company)
                .map(cc -> ResponseEntity.ok().body(cc))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/company")
    public ResponseEntity<Long> companyToId(@RequestParam Long identity, @RequestParam Long verifDigit, @RequestParam Integer type) {
        Long companyId = companyService.convertToId(identity, verifDigit, type);
        return Optional.ofNullable(companyId)
                .map(id -> ResponseEntity.ok().body(id))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
