package patient_management.patient_service.mapper;

import patient_management.patient_service.dto.PatientResponseDTO;
import patient_management.patient_service.model.Patient;

public class PatientMapper {

  public static PatientResponseDTO toDTO(Patient patient) {
    PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
    patientResponseDTO.setAddress(patient.getAddress());
    patientResponseDTO.setName(patient.getName());
    patientResponseDTO.setEmail(patient.getEmail());
    patientResponseDTO.setId(patient.getId().toString());
    patientResponseDTO.setDateOfBirth(patient.getDateOfBirth().toString());
    return patientResponseDTO;
  }
}
