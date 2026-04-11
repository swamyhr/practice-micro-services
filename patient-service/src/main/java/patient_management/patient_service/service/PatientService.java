package patient_management.patient_service.service;

import org.springframework.stereotype.Service;
import patient_management.patient_service.dto.PatientRequestDTO;
import patient_management.patient_service.dto.PatientResponseDTO;
import patient_management.patient_service.exception.EmailAlreadyExistsException;
import patient_management.patient_service.mapper.PatientMapper;
import patient_management.patient_service.model.Patient;
import patient_management.patient_service.repository.PatientRepository;

import java.util.List;

@Service
public class PatientService {

  private final PatientRepository patientRepository;

  public PatientService(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }

  public List<PatientResponseDTO> getPatients() {
    List<Patient> patients = patientRepository.findAll();

    return patients.stream().map(PatientMapper::toDTO).toList();
  }

  public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {

    if(patientRepository.existsByEmail(patientRequestDTO.getEmail())) {
      throw new EmailAlreadyExistsException("Email already exists {}" + patientRequestDTO.getEmail());
    }

    Patient newPatient = patientRepository.
        save(PatientMapper.toModel(patientRequestDTO));

    return PatientMapper.toDTO(newPatient);
  }
}
