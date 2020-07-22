package com.arrudamoreira.cursomc.domain;

import java.util.Date;

import com.arrudamoreira.cursomc.domain.enums.EstadoPagamento;

public class PagamentoComBoleto extends Pagamento{
	private static final long serialVersionUID = 1L;
	
	private Date dataPagamento;
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
