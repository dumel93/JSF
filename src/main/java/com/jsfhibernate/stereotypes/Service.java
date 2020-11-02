package com.jsfhibernate.stereotypes;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Stereotype;
import javax.transaction.Transactional;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@ApplicationScoped
@Transactional
@Stereotype
@Target({TYPE})
@Retention(RUNTIME)
public @interface Service {
}

