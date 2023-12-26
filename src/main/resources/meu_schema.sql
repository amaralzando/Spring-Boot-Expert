CREATE Table CLIENTE(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    NOME VARCHAR(255)
    CPF VARCHAR(11),
);

CREATE Table PRODUTO(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    DESCRICAO VARCHAR(255) ,
    PRECO_UNITARIO NUMERIC(20, 2)
);

CREATE Table PEDIDO(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    CLIENTE_ID INTEGER REFERENCES Cliente(clienteId),
    DATA_PEDIDO TIMESTAMP ,
    STATUS VARCHAR(20),
    TOTAL NUMERIC(20, 2)
);

CREATE Table ITEM_PEDIDO(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    PEDIDO_ID INTEGER REFERENCES Pedido(pedidoId),
    PRODUTO_ID INTEGER REFERENCES Produto(produtoId),
    QUANTIDADE INTEGER
);

CREATE TABLE USUARIO(
    ID INTEGER PRIMARY KEY AUTO_INCREMENT,
    LOGIN VARCHAR(50) NOT NULL,
    SENHA VARCHAR(255) NOT NULL,
    ADMIN BOOL DEFAULT FALSE
);
