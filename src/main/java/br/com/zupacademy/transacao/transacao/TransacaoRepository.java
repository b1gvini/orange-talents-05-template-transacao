package br.com.zupacademy.transacao.transacao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransacaoRepository extends JpaRepository<Transacao, String>{

	Page<Transacao> findByCartaoId(String idCartao, Pageable paginacao);

}
