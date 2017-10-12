package br.senac.tads4.dsw.tadsstore.common.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Produto.class)
public abstract class Produto_ {

	public static volatile SingularAttribute<Produto, BigDecimal> preco;
	public static volatile ListAttribute<Produto, ImagemProduto> imagens;
	public static volatile SingularAttribute<Produto, Date> dtCadastro;
	public static volatile ListAttribute<Produto, Categoria> categorias;
	public static volatile SingularAttribute<Produto, String> nome;
	public static volatile SingularAttribute<Produto, Long> id;
	public static volatile SingularAttribute<Produto, String> descricao;

}

