
package com.hospital.sys.service;

import com.hospital.sys.model.HistoriaClinica;
import com.hospital.sys.repository.HistoriaClinicaRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class HistoriaClinicaService {
    private final HistoriaClinicaRepository historiaClinicaRepository;
    
    public HistoriaClinicaService(HistoriaClinicaRepository hcr){
        this.historiaClinicaRepository=hcr;
    }
        public List<HistoriaClinica> Listar(){
        return historiaClinicaRepository.findAll();
    }
    public HistoriaClinica unaHistoriaClinica(Integer id){
        return historiaClinicaRepository.findById(id).orElseThrow(()->{
            return new ResponseStatusException(HttpStatus.NOT_FOUND,"no se encontro una historia");
        });
    } 
      public HistoriaClinica registrar(HistoriaClinica hc){
        return historiaClinicaRepository.save(hc);
    }
    private void validar(HistoriaClinica hc){
        if (hc==null || hc.getDiagnostico()== null || hc.getDiagnostico().isBlank()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"el motivo es obligatorio");
        }
        hc.setDiagnostico(hc.getDiagnostico().trim());
    }
    public HistoriaClinica actualizar(Integer id,HistoriaClinica hc){
        validar(hc);
        HistoriaClinica actualOException=unaHistoriaClinica(id);
        actualOException.setId(hc.getId());
        actualOException.setMedicoId(hc.getMedicoId());
        actualOException.setPacienteId(hc.getPacienteId());
        actualOException.setFecha(hc.getFecha());
        actualOException.setDiagnostico(hc.getDiagnostico());
        actualOException.setObservaciones(hc.getObservaciones());
        actualOException.setTratatmiento(hc.getTratatmiento());
        return historiaClinicaRepository.save(actualOException);
    }
    public void borrar(Integer id){
       historiaClinicaRepository.delete(unaHistoriaClinica(id));
    }
}

