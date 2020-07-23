package com.arrudamoreira.cursomc.domain;

import java.util.Date;

import javax.persistence.Entity;

import com.arrudamoreira.cursomc.domain.enums.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPagamento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataVenciamento;
	
	public PagamentoComBoleto() {
	}

	public PagamentoComBoleto(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVenciamento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public Date getDataVenciamento() {
		return dataVenciamento;
	}

	public void setDataVenciamento(Date dataVenciamento) {
		this.dataVenciamento = dataVenciamento;
	}
	
}
