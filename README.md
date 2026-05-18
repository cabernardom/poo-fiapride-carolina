# Projeto FiapRide

## Informações do Aluno

- **Nome:** Carolina Monteiro Bernardo
- **RM:** 564651
- **Turma:** 2CCPW
- **Curso:** Ciência da Computação
- **GitHub:** cabernardom

---

## Descrição do Projeto

Este projeto acompanha os desafios das aulas 1 a 9 de Programação Orientada a Objetos. Nesta primeira etapa, foi criada a base do sistema **FiapRide**, com a classe `Passageiro` representando um usuário do aplicativo de mobilidade urbana.

---

## Checklist de Implementação

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [ ] Aula 8 - Classes Abstratas
- [ ] Aula 9 - Interfaces

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Não seria mais fácil apenas criar variáveis soltas no main, como `String nomeAna = "Ana"` e `double saldoAna = 50.0`? E se o FiapRide tiver 1 milhão de usuários? Como a classe ajuda a resolver isso?

**Sua Resposta:**

Criar a classe `Passageiro` deixa o sistema organizado porque ela funciona como um molde para todos os usuários do FiapRide. Se usássemos variáveis soltas no `main`, cada novo passageiro exigiria novas variáveis separadas, o que ficaria confuso e difícil de manter. Com uma classe, todos os passageiros seguem a mesma estrutura, mas cada objeto pode ter seus próprios valores de `nome` e `saldo`. Isso também facilita o crescimento do sistema, porque criar 1 milhão de usuários significa criar 1 milhão de objetos do mesmo tipo, não inventar 1 milhão de conjuntos de variáveis. Além disso, a classe ajuda a aproximar o código do mundo real, tornando mais claro que o sistema trabalha com passageiros reais do aplicativo. Essa organização é a base para adicionar comportamentos, validações e regras de negócio nas próximas aulas.

---

### Aula 2 - Métodos

**Pergunta:** Se nós podemos simplesmente fazer `passageiro.saldo = passageiro.saldo + 100` diretamente no código principal, por que dá tanto trabalho criar um método específico chamado `adicionarSaldo(valor)` para fazer isso? Quais seriam os riscos para a nossa startup de mobilidade se deixássemos qualquer programador alterar o saldo diretamente?

**Sua Resposta:**

Criar um método como `adicionarSaldo(valor)` é importante porque ele concentra a regra de negócio em um lugar só. Se cada programador alterasse o saldo diretamente, alguém poderia adicionar um valor negativo, apagar o saldo por engano ou criar uma lógica diferente em cada parte do sistema. Em uma startup de mobilidade, isso seria perigoso porque o saldo representa dinheiro do passageiro. O método permite validar o valor antes de mudar o atributo e deixa claro qual ação está acontecendo. Além disso, quando a regra mudar no futuro, por exemplo, para registrar histórico de recargas, emitir recibo ou aplicar promoção, a mudança pode ficar dentro do próprio método. Assim, o objeto deixa de ser apenas uma lista de dados e passa a proteger melhor o próprio estado.

---

### Aula 3 - Encapsulamento

**Pergunta:** No nosso código, os atributos são `private`, mas os métodos `getSaldo()` e `getNome()` são `public`. Por que é seguro deixar o `get` público, mas perigoso deixar o atributo original público?

**Sua Resposta:**

O `get` público é mais seguro porque ele apenas entrega uma leitura do valor, sem permitir que outra classe altere diretamente o atributo original. Quando o atributo fica público, qualquer parte do sistema pode mudar o saldo, o nome ou o CPF sem passar por nenhuma regra de validação. No caso do FiapRide, isso poderia permitir saldo negativo, recargas falsas ou dados importantes sendo apagados por engano. A diferença é parecida com mostrar uma cópia de um documento em vez de entregar o documento original para alguém rasurar. Com os atributos `private`, a classe `Passageiro` continua dona dos seus dados. Outras classes conseguem consultar informações pelos getters, mas as alterações precisam passar por métodos controlados, como `adicionarSaldo()` e `pagarViagem()`.

---

### Aula 4 - Construtores

**Pergunta:** Na nossa classe `Veiculo`, nós tomamos duas decisões arquitetônicas muito importantes: não criamos o método `setModelo()` público e o `setPlaca()` foi criado como privado, com um método público chamado `atualizarPlaca()` para acessá-lo. Por que é um erro gerar getters e setters para tudo automaticamente?

**Sua Resposta:**

Gerar getters e setters para tudo automaticamente é perigoso porque transforma os atributos em dados quase públicos, só que com outro nome. Nem tudo em um objeto deve poder mudar livremente. No caso de um veículo, o modelo faz parte da identidade do carro: um Toyota Corolla não vira outro modelo apenas porque alguém chamou um método. Por isso, não existe `setModelo()` público. Já a placa até pode mudar, mas, no mundo real, isso exige um processo, como uma atualização no Detran. O método `atualizarPlaca()` deixa essa intenção clara e chama internamente a validação feita por `setPlaca()`. Assim, o código evita fraudes, bloqueia placas vazias e representa melhor uma regra de negócio real, em vez de permitir alterações soltas sem significado.

---

### Aula 5 - Associação

**Pergunta:** No construtor da `Viagem`, nós exigimos o objeto inteiro (`Passageiro solicitante`). Se o resumo só precisa imprimir o nome da pessoa, não seria mais fácil pedir apenas a `String` do nome no construtor da `Viagem`?

**Sua Resposta:**

Pedir o objeto inteiro é melhor porque a viagem não depende apenas do nome do passageiro. O nome serve para exibir um resumo, mas as regras de negócio precisam acessar outros dados e comportamentos, como consultar saldo e pagar a corrida. Se a `Viagem` guardasse apenas a String `"Ana Silva"`, ela não conseguiria chamar `getSaldo()` nem `pagarViagem()`, porque texto não tem esses comportamentos. Ao receber um `Passageiro`, a classe `Viagem` fica associada ao usuário real do sistema. Isso também mostra a passagem por referência: se o saldo da Ana mudar depois da viagem ser criada, a viagem continuará enxergando o mesmo objeto atualizado. Assim, o relacionamento fica mais rico, mais fiel ao mundo real e preparado para regras futuras.

---

### Aula 6 - Herança

**Pergunta:** No nosso código, a mãe `Veiculo` possui os atributos `placa` e `modelo` como `private`. Quando o `Carro` herda de `Veiculo`, ele recebe esses atributos, mas o código dentro de `Carro` não consegue fazer `this.placa = "ABC"`. Ele é obrigado a usar o `super()` ou os métodos da classe mãe. Por que o Java não deixa a filha alterar as variáveis privadas da mãe diretamente?

**Sua Resposta:**

O Java não permite esse acesso direto porque `private` significa que somente a própria classe controla aquele dado. Mesmo que `Carro` seja um tipo de `Veiculo`, ele não deve quebrar as regras internas da classe mãe. Se a filha pudesse alterar `placa` diretamente, ela poderia ignorar a validação criada em `Veiculo` e colocar uma placa vazia ou inválida. Isso protegeria mal o sistema e quebraria o encapsulamento aprendido na Aula 3. O uso de `super()` no construtor respeita a regra de nascimento definida pela mãe, enquanto os getters e métodos públicos permitem acesso controlado. Assim, a herança reaproveita código sem destruir a segurança dos dados.

---

### Aula 7 - Polimorfismo

**Pergunta:** No nosso loop `for (Veiculo veiculo : frota)`, a variável `veiculo` é do tipo genérico `Veiculo`. Se esquecêssemos de criar o método `calcularAutonomia()` na classe mãe `Veiculo`, conseguiríamos chamá-lo dentro do loop, mesmo sabendo que ele existe em `Carro` e `Moto`?

**Sua Resposta:**

Não conseguiríamos chamar o método no loop se ele não existisse na classe mãe, porque o compilador olha primeiro para o tipo da variável, que nesse caso é `Veiculo`. Mesmo que, em tempo de execução, o objeto real seja um `Carro` ou uma `Moto`, o contrato precisa estar declarado na base da hierarquia. Esse contrato diz que todo `Veiculo` sabe calcular autonomia, ainda que cada filho faça a conta de um jeito diferente. Por isso, o método existe em `Veiculo` e é sobrescrito com `@Override` nas classes filhas. Assim, o `main` não precisa fazer `if` para descobrir o tipo do objeto; ele apenas chama `calcularAutonomia()` e deixa o próprio objeto responder corretamente.

---

## Desafios Técnicos Implementados

### Aula 1

Foram criadas a classe `Passageiro`, com os atributos `nome` e `saldo`, e a classe `SistemaPrincipal`, que instancia dois objetos diferentes para demonstrar a diferença entre classe e objeto.

### Aula 2

Foram adicionados os métodos `adicionarSaldo(double valor)` e `pagarViagem(double custo)` na classe `Passageiro`. Os dois métodos recebem parâmetros, retornam `boolean` para indicar sucesso ou falha e validam os dados antes de alterar o saldo. A classe `SistemaPrincipal` foi atualizada para testar recargas válidas, recarga inválida, pagamento com saldo suficiente, pagamento com saldo insuficiente e custo inválido.

### Aula 3

Os atributos `nome`, `cpf` e `saldo` da classe `Passageiro` foram alterados para `private`. Também foram criados getters públicos para leitura e setters privados com validação, impedindo alterações diretas fora da própria classe. O `SistemaPrincipal` foi atualizado para usar o construtor e acessar os dados somente pelos métodos públicos.

### Aula 4

Foi criada a classe `Veiculo`, com os atributos privados `placa` e `modelo`. A classe possui um construtor padrão que usa `this()` para reaproveitar o construtor customizado, além de um construtor customizado que recebe placa e modelo. Também foram usados `this.` nos acessos internos, getters públicos para leitura, `setPlaca()` privado com validação e o método público `atualizarPlaca()` para representar a troca de placa como uma ação de negócio.

### Aula 5

Foi criada a classe `Viagem`, associando objetos de `Passageiro` e `Veiculo` por meio dos atributos `solicitante` e `veiculoUtilizado`. O construtor da viagem exige destino, passageiro e veículo, e o método `exibirResumo()` navega pelos objetos associados para imprimir o nome do passageiro, o modelo e a placa do veículo. O `SistemaPrincipal` também testa a passagem por referência ao alterar o saldo do passageiro depois da viagem criada.

### Aula 6

Foram criadas as classes `Carro` e `Moto`, ambas herdando de `Veiculo` com `extends`. A classe `Carro` adiciona o atributo exclusivo `capacidadePassageiros`, enquanto a classe `Moto` adiciona o atributo `isEletrica`. Os construtores das subclasses usam `super()` para reaproveitar a inicialização obrigatória da classe mãe, e o `SistemaPrincipal` testa os métodos herdados e os atributos específicos de cada filha.

### Aula 7

Foi criado o método `calcularAutonomia()` na classe mãe `Veiculo` como contrato polimórfico. As classes `Carro` e `Moto` sobrescrevem esse método com `@Override`, usando regras diferentes de consumo. A classe `Veiculo` também passou a controlar `nivelCombustivel` e o método `abastecer(double quantidade)`. No `SistemaPrincipal`, uma `List<Veiculo>` recebe objetos `Carro` e `Moto`, e o mesmo comando `calcularAutonomia()` gera respostas diferentes para cada tipo.
