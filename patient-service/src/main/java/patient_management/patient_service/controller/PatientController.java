package patient_management.patient_service.controller;

import jakarta.validation.groups.Default;
import lombok.Builder;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import patient_management.patient_service.dto.PatientRequestDTO;
import patient_management.patient_service.dto.PatientResponseDTO;
import patient_management.patient_service.service.PatientService;
import patient_management.patient_service.validators.CreatePatientValidators;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/patients")
public class PatientController {

  private final PatientService patientService;

  public PatientController(PatientService patientService) {
    this.patientService = patientService;
  }

  @GetMapping
  public ResponseEntity<List<PatientResponseDTO>> getPatients() {
    List<PatientResponseDTO> patientResponseDTOS = patientService.getPatients();

    return ResponseEntity.ok().body(patientResponseDTOS);
  }

  @PostMapping("/create")
  public ResponseEntity<PatientResponseDTO> createPatient(@Validated({
      Default.class, CreatePatientValidators.class
  }) @RequestBody PatientRequestDTO patientRequestDTO) {

    return ResponseEntity.ok().body(patientService.createPatient(patientRequestDTO));
  }

  @PutMapping("/{id}")
  public ResponseEntity<PatientResponseDTO> updatePatient(@PathVariable UUID id,
                                                          @Validated({Builder.Default.class})
                                                          @RequestBody PatientRequestDTO patientRequestDTO) {
    return ResponseEntity.ok().body(patientService.updatePatient(id, patientRequestDTO));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletePatient(@PathVariable UUID id) {
    patientService.deleteById(id);
    return ResponseEntity.noContent().build();
  }
}
