package com.hospital.sys.service;

import com.hospital.sys.model.Pacientes;
import com.hospital.sys.repository.PacientesRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PacientesService {

    private final PacientesRepository pacientesRepository;
    
    public PacientesService(PacientesRepository p){
        this.pacientesRepository=p;
    }
    public List<Pacientes> listarPacientes(){
        return pacientesRepository.findAll();
    }
    
    public Pacientes unPaciente(Integer id){
        return pacientesRepository.findById(id).orElseThrow(() -> {
            return new ResponseStatusException(
                    HttpStatus.NOT_FOUND,"no se encontro un paciente");
        });
    }
    public Pacientes registrarPaciente(Pacientes pac){
        return pacientesRepository.save(pac);
    }
    
       public Pacientes actualizarPaciente(Integer id, Pacientes pac){
        validarPaciente(pac);
        Pacientes actualOExistente = unPaciente(id);
        actualOExistente.setNombre(pac.getNombre());
        actualOExistente.setApellido(pac.getApellido());
        actualOExistente.setDocumento(pac.getDocumento());
        actualOExistente.setFechaNacimiento(pac.getFechaNacimiento());
        actualOExistente.setDireccion(pac.getDireccion());
        actualOExistente.setTelefono(pac.getTelefono());
        actualOExistente.setEps(pac.getEps());
        actualOExistente.setGenero(pac.getGenero());
        return pacientesRepository.save(actualOExistente);
    }
    private void validarPaciente(Pacientes pac){
        if (pac == null || pac.getNombre()== null || pac.getNombre().isBlank()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "El usuario es obligatorio");
        }
        pac.setNombre(pac.getNombre().trim());
    }
    public void borrar(Integer id){
        pacientesRepository.delete(unPaciente(id));
    }
 
}
