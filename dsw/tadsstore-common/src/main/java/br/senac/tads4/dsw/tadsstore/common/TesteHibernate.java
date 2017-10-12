package br.senac.tads4.dsw.tadsstore.common;

import javax.persistence.Persistence;

/**
 *
 * @author gabriel.malta
 */
public class TesteHibernate {

    public static void main(String[] args) {
        Persistence.generateSchema("TADSSTORE_PU", null);
    }
}
