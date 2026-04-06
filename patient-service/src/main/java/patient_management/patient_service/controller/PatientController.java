package patient_management.patient_service.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import patient_management.patient_service.dto.PatientResponseDTO;
import patient_management.patient_service.service.PatientService;

import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {

  private final PatientService patientService;

  public PatientController(PatientService patientService) {
    this.patientService = patientService;
  }


  @GetMapping
  public ResponseEntity<List<PatientResponseDTO>> getPatients() {
    List<PatientResponseDTO>  patientResponseDTOS = patientService.getPatients();

    return ResponseEntity.ok().body(patientResponseDTOS);
  }

}
