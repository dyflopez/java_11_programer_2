package Controller;

import dtos.ViewClientesCargosDTO;
import service.VewService;

import java.util.List;

public class ViewController {

    VewService vewService = new VewService();

    public List<ViewClientesCargosDTO> getView(){
        return vewService.getViewClientes();
    }

}
