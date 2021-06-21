package br.com.zupacademy.transacao.transacao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsultaTransacaoController {

	@Autowired
	private TransacaoRepository transacaoRepository;

	@GetMapping("/transacoes/{idCartao}")
	public ResponseEntity<?> consultar(@PathVariable("idCartao") String idCartao,
			@PageableDefault(direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {

		Page<Transacao> transacoes = transacaoRepository.findByCartaoId(idCartao, paginacao);

		return transacoes.isEmpty() ? ResponseEntity.notFound().build()
				: ResponseEntity.ok().body(transacoes.map(EventoTransacaoResponse::new));
	}
}
