
package com.hospital.sys.service;

import com.hospital.sys.model.Medicos;
import com.hospital.sys.repository.MedicosRepository;
import java.util.List;
import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class MedicosService {
    private final MedicosRepository medicosRepository;
    
    public MedicosService(MedicosRepository mr){
        this.medicosRepository=mr;
    }
    public List<Medicos> Listar(){
        return medicosRepository.findAll();
    }

    public Medicos unMedico(Integer id){
        return medicosRepository.findById(id).orElseThrow(() -> {
            return new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"no se encontro un usuario");
        });
    }
    public Medicos registrarMedico(Medicos med){
        return medicosRepository.save(med);
    }
    private void validarMedico(Medicos med){
        if (med==null || med.getNombre() == null || med.getNombre().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"El nombre es obligatorio");
        }
        med.setNombre(med.getNombre().trim());
    }
    public Medicos actualizarMedico(Integer is, Medicos med){
        validarMedico(med);
        Medicos actualOExistente = unMedico(id);
        actualOExistente.setNombre(med.getNombre());
        actualOExistente.setApellido(med.getApellido());
        actualOExistente.setDocumento(med.getDocumento());
        actualOExistente.setEspecialidad(med.getEspecialidad());
        actualOExistente.setTelefono(med.getTelefono());
        actualOExistente.setCorreo(med.getCorreo());
        return medicosRepository.save(actualOExistente);
    }
}