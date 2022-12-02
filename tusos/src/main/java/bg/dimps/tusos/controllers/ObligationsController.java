package bg.dimps.tusos.controllers;

import bg.dimps.tusos.entities.MonetaryObligation;
import bg.dimps.tusos.repositories.ObligationsRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/obligations")
public class ObligationsController {

    private final ObligationsRepository obligationsRepo;

    public ObligationsController(ObligationsRepository obligationsRepostory) {
        this.obligationsRepo = obligationsRepostory;
    }

    @GetMapping("/fetch")
    public List<MonetaryObligation> getAllObligations() {
        return obligationsRepo.findAll();
    }

    @PostMapping("/add")
    public MonetaryObligation addObligation(@RequestBody MonetaryObligation obligation){
        return obligationsRepo.save(obligation);
    }

    @PutMapping("/update")
    public MonetaryObligation updateObligation(@RequestBody MonetaryObligation obligation){
        return  obligationsRepo.save(obligation);
    }

}
