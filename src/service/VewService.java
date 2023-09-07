package service;

import dtos.ViewClientesCargosDTO;
import model.repository.ViewRepository;

import java.util.List;

public class VewService {


    ViewRepository viewRepository = new ViewRepository();
    public List<ViewClientesCargosDTO> getViewClientes(){
        return viewRepository.findViewClient();
    }
}
