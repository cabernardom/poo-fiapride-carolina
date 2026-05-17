# Projeto FiapRide

## Informacoes do Aluno

- **Nome:** Carolina Monteiro Bernardo
- **RM:** 564651
- **Turma:** 2CCPW
- **Curso:** Ciência da Computação
- **GitHub:** cabernardom

---

## Descricao do Projeto

Este projeto acompanha os desafios das aulas 1 a 9 de Programacao Orientada a Objetos. Nesta primeira etapa, foi criada a base do sistema **FiapRide**, com a classe `Passageiro` representando um usuario do aplicativo de mobilidade urbana.

---

## Checklist de Implementacao

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Metodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associacao
- [x] Aula 6 - Heranca
- [ ] Aula 7 - Polimorfismo
- [ ] Aula 8 - Classes Abstratas
- [ ] Aula 9 - Interfaces

---

## Perguntas de Reflexao

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Nao seria mais facil apenas criar variaveis soltas no main, como `String nomeAna = "Ana"` e `double saldoAna = 50.0`? E se o FiapRide tiver 1 milhao de usuarios? Como a classe ajuda a resolver isso?

**Sua Resposta:**

Criar a classe `Passageiro` deixa o sistema organizado porque ela funciona como um molde para todos os usuarios do FiapRide. Se usassemos variaveis soltas no `main`, cada novo passageiro exigiria novas variaveis separadas, o que ficaria confuso e dificil de manter. Com uma classe, todos os passageiros seguem a mesma estrutura, mas cada objeto pode ter seus proprios valores de `nome` e `saldo`. Isso tambem facilita o crescimento do sistema, porque criar 1 milhao de usuarios significa criar 1 milhao de objetos do mesmo tipo, nao inventar 1 milhao de conjuntos de variaveis. Alem disso, a classe ajuda a aproximar o codigo do mundo real, tornando mais claro que o sistema trabalha com passageiros reais do aplicativo. Essa organizacao e a base para adicionar comportamentos, validacoes e regras de negocio nas proximas aulas.

---

### Aula 2 - Metodos

**Pergunta:** Se nos podemos simplesmente fazer `passageiro.saldo = passageiro.saldo + 100` diretamente no codigo principal, por que da tanto trabalho criar um metodo especifico chamado `adicionarSaldo(valor)` para fazer isso? Quais seriam os riscos para a nossa startup de mobilidade se deixassemos qualquer programador alterar o saldo diretamente?

**Sua Resposta:**

Criar um metodo como `adicionarSaldo(valor)` e importante porque ele concentra a regra de negocio em um lugar so. Se cada programador alterasse o saldo diretamente, alguem poderia adicionar valor negativo, apagar o saldo por engano ou criar uma logica diferente em cada parte do sistema. Em uma startup de mobilidade, isso seria perigoso porque o saldo representa dinheiro do passageiro. O metodo permite validar o valor antes de mudar o atributo e deixa claro qual acao esta acontecendo. Alem disso, quando a regra mudar no futuro, por exemplo para registrar historico de recargas, emitir recibo ou aplicar promocao, a mudanca pode ficar dentro do proprio metodo. Assim, o objeto deixa de ser apenas uma lista de dados e passa a proteger melhor o proprio estado.

---

### Aula 3 - Encapsulamento

**Pergunta:** No nosso codigo, os atributos sao `private`, mas os metodos `getSaldo()` e `getNome()` sao `public`. Por que e seguro deixar o `get` publico, mas perigoso deixar o atributo original publico?

**Sua Resposta:**

O `get` publico e mais seguro porque ele apenas entrega uma leitura do valor, sem permitir que outra classe altere diretamente o atributo original. Quando o atributo fica publico, qualquer parte do sistema pode mudar o saldo, o nome ou o CPF sem passar por nenhuma regra de validacao. No caso do FiapRide, isso poderia permitir saldo negativo, recargas falsas ou dados importantes sendo apagados por engano. A diferenca e parecida com mostrar uma copia de um documento em vez de entregar o documento original para alguem rasurar. Com os atributos `private`, a classe `Passageiro` continua dona dos seus dados. Outras classes conseguem consultar informacoes pelos getters, mas as alteracoes precisam passar por metodos controlados, como `adicionarSaldo()` e `pagarViagem()`.

---

### Aula 4 - Construtores

**Pergunta:** Na nossa classe `Veiculo`, nos tomamos duas decisoes arquitetonicas muito importantes: nao criamos o metodo `setModelo()` publico e o `setPlaca()` foi criado como privado, com um metodo publico chamado `atualizarPlaca()` para acessa-lo. Por que e um erro gerar getters e setters para tudo automaticamente?

**Sua Resposta:**

Gerar getters e setters para tudo automaticamente e perigoso porque transforma os atributos em dados quase publicos, so que com outro nome. Nem tudo em um objeto deve poder mudar livremente. No caso de um veiculo, o modelo faz parte da identidade do carro: um Toyota Corolla nao vira outro modelo apenas porque alguem chamou um metodo. Por isso, nao existe `setModelo()` publico. Ja a placa ate pode mudar, mas no mundo real isso exige um processo, como uma atualizacao no Detran. O metodo `atualizarPlaca()` deixa essa intencao clara e chama internamente a validacao feita por `setPlaca()`. Assim, o codigo evita fraudes, bloqueia placas vazias e representa melhor uma regra de negocio real, em vez de permitir alteracoes soltas sem significado.

---

### Aula 5 - Associacao

**Pergunta:** No construtor da `Viagem`, nos exigimos o objeto inteiro (`Passageiro solicitante`). Se o resumo so precisa imprimir o nome da pessoa, nao seria mais facil pedir apenas a `String` do nome no construtor da `Viagem`?

**Sua Resposta:**

Pedir o objeto inteiro e melhor porque a viagem nao depende apenas do nome do passageiro. O nome serve para exibir um resumo, mas as regras de negocio precisam acessar outros dados e comportamentos, como consultar saldo e pagar a corrida. Se a `Viagem` guardasse apenas a String "Ana Silva", ela nao conseguiria chamar `getSaldo()` nem `pagarViagem()`, porque texto nao tem esses comportamentos. Ao receber um `Passageiro`, a classe `Viagem` fica associada ao usuario real do sistema. Isso tambem mostra a passagem por referencia: se o saldo da Ana muda depois da viagem ser criada, a viagem continua enxergando o mesmo objeto atualizado. Assim, o relacionamento fica mais rico, mais fiel ao mundo real e preparado para regras futuras.

---

### Aula 6 - Heranca

**Pergunta:** No nosso codigo, a mae `Veiculo` possui os atributos `placa` e `modelo` como `private`. Quando o `Carro` herda de `Veiculo`, ele recebe esses atributos, mas o codigo dentro de `Carro` nao consegue fazer `this.placa = "ABC"`. Ele e obrigado a usar o `super()` ou os metodos da classe mae. Por que o Java nao deixa a filha alterar as variaveis privadas da mae diretamente?

**Sua Resposta:**

O Java nao permite esse acesso direto porque `private` significa que somente a propria classe controla aquele dado. Mesmo que `Carro` seja um tipo de `Veiculo`, ele nao deve quebrar as regras internas da classe mae. Se a filha pudesse alterar `placa` diretamente, ela poderia ignorar a validacao criada em `Veiculo` e colocar uma placa vazia ou invalida. Isso protegeria mal o sistema e quebraria o encapsulamento aprendido na Aula 3. O uso de `super()` no construtor respeita a regra de nascimento definida pela mae, enquanto os getters e metodos publicos permitem acesso controlado. Assim, a heranca reaproveita codigo sem destruir a seguranca dos dados.

---

## Desafios Tecnicos Implementados

### Aula 1

Foram criadas a classe `Passageiro`, com os atributos `nome` e `saldo`, e a classe `SistemaPrincipal`, que instancia dois objetos diferentes para demonstrar a diferenca entre classe e objeto.

### Aula 2

Foram adicionados os metodos `adicionarSaldo(double valor)` e `pagarViagem(double custo)` na classe `Passageiro`. Os dois metodos recebem parametros, retornam `boolean` para indicar sucesso ou falha e validam os dados antes de alterar o saldo. A classe `SistemaPrincipal` foi atualizada para testar recargas validas, recarga invalida, pagamento com saldo suficiente, pagamento com saldo insuficiente e custo invalido.

### Aula 3

Os atributos `nome`, `cpf` e `saldo` da classe `Passageiro` foram alterados para `private`. Tambem foram criados getters publicos para leitura e setters privados com validacao, impedindo alteracoes diretas fora da propria classe. O `SistemaPrincipal` foi atualizado para usar o construtor e acessar os dados somente pelos metodos publicos.

### Aula 4

Foi criada a classe `Veiculo`, com os atributos privados `placa` e `modelo`. A classe possui um construtor padrao que usa `this()` para reaproveitar o construtor customizado, alem de um construtor customizado que recebe placa e modelo. Tambem foram usados `this.` nos acessos internos, getters publicos para leitura, `setPlaca()` privado com validacao e o metodo publico `atualizarPlaca()` para representar a troca de placa como uma acao de negocio.

### Aula 5

Foi criada a classe `Viagem`, associando objetos de `Passageiro` e `Veiculo` por meio dos atributos `solicitante` e `veiculoUtilizado`. O construtor da viagem exige destino, passageiro e veiculo, e o metodo `exibirResumo()` navega pelos objetos associados para imprimir nome do passageiro, modelo e placa do veiculo. O `SistemaPrincipal` tambem testa a passagem por referencia ao alterar o saldo do passageiro depois da viagem criada.

### Aula 6

Foram criadas as classes `Carro` e `Moto`, ambas herdando de `Veiculo` com `extends`. A classe `Carro` adiciona o atributo exclusivo `capacidadePassageiros`, enquanto a classe `Moto` adiciona o atributo `isEletrica`. Os construtores das subclasses usam `super()` para reaproveitar a inicializacao obrigatoria da classe mae, e o `SistemaPrincipal` testa os metodos herdados e os atributos especificos de cada filha.
