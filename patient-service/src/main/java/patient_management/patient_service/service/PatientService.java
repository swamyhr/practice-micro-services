package patient_management.patient_service.service;

import org.springframework.stereotype.Service;
import patient_management.patient_service.repository.PatientRepository;

@Service
public class PatientService {

  private PatientRepository patientRepository;

  public PatientService(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }
}
