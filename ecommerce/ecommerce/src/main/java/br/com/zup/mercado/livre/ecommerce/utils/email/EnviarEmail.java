package br.com.zup.mercado.livre.ecommerce.utils.email;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import br.com.zup.mercado.livre.ecommerce.produto.pergunta.PerguntaModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class EnviarEmail {

    @Autowired
    private Mailer mailer;

    public void novaPergunta(@NotNull @Valid PerguntaModel pergunta) {
        mailer.send("<html>...</html>","Nova pergunta...",pergunta.getUsuario().getLogin(),"novapergunta@nossomercadolivre.com",pergunta.getUsuario().getLogin());
    }
}
