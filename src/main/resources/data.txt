CREATE Table Cliente(
    clienteId INTEGER PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(255)
);

CREATE Table Produto(
    produtoId INTEGER PRIMARY KEY AUTO_INCREMENT,
    descricao VARCHAR(255) ,
    preco_unitario NUMERIC(20, 2)
);

CREATE Table Pedido(
    pedidoId INTEGER PRIMARY KEY AUTO_INCREMENT,
    clienteId INTEGER REFERENCES Cliente(clienteId),
    data_pedido TIMESTAMP ,
    total_pedido NUMERIC(20, 2)
);

CREATE Table Item_Pedido(
    item_PedidoId INTEGER PRIMARY KEY AUTO_INCREMENT,
    pedidoId INTEGER REFERENCES Pedido(pedidoId),
    produtoId INTEGER REFERENCES Produto(produtoId),
    quantidade INTEGER
);