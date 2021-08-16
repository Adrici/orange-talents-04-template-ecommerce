package br.com.zup.mercado.livre.ecommerce.utils;


import org.springframework.util.Assert;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class ExistsIdValidation implements ConstraintValidator<ExistsId, Long> {

    private String campo;

    private Class<?> targetClass;

    private boolean aceitaNull;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(ExistsId constraintAnnotation) {
        campo = constraintAnnotation.campo();
        targetClass = constraintAnnotation.targetClass();
        aceitaNull = constraintAnnotation.aceitaNull();
    }


    @Override
    public boolean isValid(Long value, ConstraintValidatorContext context) {
        if(aceitaNull && value == null){
            return true;
        }

        Assert.isTrue(value != null, "O id não pode ser nulo");

        Query query = entityManager.createQuery("Select 1 from " + targetClass.getName() + " where " + campo + "= :value");
        query.setParameter("value", value);
        List<?> listaResultado = query.getResultList();

        Assert.state(listaResultado.size() <= 1, "PROBLEMA; VOCÊ TEM ID REPETIDO");

        return listaResultado.size() == 1;
    }


}
