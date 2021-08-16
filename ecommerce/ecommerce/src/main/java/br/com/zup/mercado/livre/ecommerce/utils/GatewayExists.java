package br.com.zup.mercado.livre.ecommerce.utils;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {GatewayExistsValidation.class})
public @interface GatewayExists {
    String message() default "O campo não existe";
    Class<?>[] groups() default { };
    Class<? extends Payload>[] payload() default { };


}