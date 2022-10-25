### Exchange header

É um sistema de roteamento de mensagens que usa argumentos com cabeçalhos e valores opcionais para rotear mensagens. As trocas de cabeçalho são
idênticas às trocas de tópicos, exceto que, em vez de usar chaves de roteamento, as mensagens são roteadas com base nos valores de cabeçalho.
Se o valor do cabeçalho for igual ao valor de fornecimento durante a ligação, a mensagem corresponderá.
A propriedade “x-match” tem dois valores possíveis: “ any ” e “ all ”, sendo “all” o padrão. Um valor de "all" indica que todos os pares de
cabeçalho (chave, valor) devem corresponder, enquanto "any" indica que pelo menos um par deve corresponder.
