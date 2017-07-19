package br.com.caelum.ingresso.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import br.com.caelum.ingresso.model.descontos.Desconto;

@Entity
public class Ingresso {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@ManyToOne
	private Sessao sessao;
	
	@ManyToOne
	private Lugar lugar;
	
	private BigDecimal preco;

	
	/**
	 * @deprecated hibernate only
	 */
	public Ingresso () {
	}
	
	
	//construtor
	public Ingresso (Sessao sessao , Desconto tipoDeDesconto, Lugar lugar) {
		this.sessao = sessao;
		this.preco = tipoDeDesconto.aplicarDescontoSobre(sessao.getPreco());
		this.lugar = lugar;
	}
	
	
	@Enumerated (EnumType.STRING)
	private TipoDeIngresso tipoDeIngresso;
	public Ingresso (Sessao sessao , TipoDeIngresso tipoDeDesconto , Lugar lugar) {
		this.sessao = sessao;
		this.setTipoDeIngresso(tipoDeDesconto);
		this.preco = this.getTipoDeIngresso().aplicaDesconto(sessao.getPreco());
		this.lugar = lugar;
	}
	
	
	public Lugar getLugar() {
		return lugar;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public void setSessao(Sessao sessao) {
		this.sessao = sessao;
	}


	public void setLugar(Lugar lugar) {
		this.lugar = lugar;
	}


	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}


	public Sessao getSessao() {
		return sessao;
	}


	public BigDecimal getPreco() {
		return preco;
	}


	public TipoDeIngresso getTipoDeIngresso() {
		return tipoDeIngresso;
	}


	public void setTipoDeIngresso(TipoDeIngresso tipoDeIngresso) {
		this.tipoDeIngresso = tipoDeIngresso;
	}
	
	

}
