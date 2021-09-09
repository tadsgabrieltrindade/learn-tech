package AlgaLogAPI;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	@GetMapping("/result")
	public String listar() {
		return "Deu tudo certo com a requisição, Gabriel!";
	}
}
