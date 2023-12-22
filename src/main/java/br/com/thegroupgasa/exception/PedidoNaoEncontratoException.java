package br.com.thegroupgasa.exception;

public class PedidoNaoEncontratoException extends RuntimeException{

        public PedidoNaoEncontratoException() {
            super("Pedido não encontrado.");
        }
}
