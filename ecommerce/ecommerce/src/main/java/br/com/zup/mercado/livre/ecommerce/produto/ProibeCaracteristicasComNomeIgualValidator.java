package br.com.zup.mercado.livre.ecommerce.produto;

import java.util.Set;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class ProibeCaracteristicasComNomeIgualValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return ProdutoRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()) {
            return;
        }

        ProdutoRequest request = (ProdutoRequest) target;
        Set<String> nomesIguais = request.buscaCaracteristicasIguais();
        if(!nomesIguais.isEmpty()) {
            errors.rejectValue("caracteristicas", null, "Você tem caracteristicas iguais " + nomesIguais);
        }
    }

}
