# Projeto FiapRide

## Informações do Aluno

- **Nome:** Carolina Monteiro Bernardo
- **RM:** 564651
- **Turma:** 2CCPW
- **Curso:** Ciência da Computação
- **GitHub:** cabernardom

---

## Descrição do Projeto

Este projeto acompanha os desafios das aulas 1 a 9 de Programação Orientada a Objetos. O sistema **FiapRide** simula conceitos de um aplicativo de mobilidade urbana usando classes como `Passageiro`, `Veiculo`, `Carro`, `Moto` e `Viagem`.

---

## Checklist de Implementação

- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores
- [x] Aula 5 - Associação
- [x] Aula 6 - Herança
- [x] Aula 7 - Polimorfismo
- [x] Aula 8 - Classes Abstratas
- [ ] Aula 9 - Interfaces

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Não seria mais fácil apenas criar variáveis soltas no main, como `String nomeAna = "Ana"` e `double saldoAna = 50.0`? E se o FiapRide tiver 1 milhão de usuários? Como a classe ajuda a resolver isso?

**Sua Resposta:**

Criar a classe `Passageiro` deixa o sistema organizado porque ela funciona como um molde para todos os usuários do FiapRide. Se usássemos variáveis soltas no `main`, cada novo passageiro exigiria novas variáveis separadas, o que ficaria confuso e difícil de manter. Com uma classe, todos os passageiros seguem a mesma estrutura, mas cada objeto pode ter seus próprios valores de `nome` e `saldo`. Isso também facilita o crescimento do sistema, porque criar 1 milhão de usuários significa criar 1 milhão de objetos do mesmo tipo, não inventar 1 milhão de conjuntos de variáveis.

---

### Aula 2 - Métodos

**Pergunta:** Se nós podemos simplesmente fazer `passageiro.saldo = passageiro.saldo + 100` diretamente no código principal, por que dá tanto trabalho criar um método específico chamado `adicionarSaldo(valor)`?

**Sua Resposta:**

Criar um método como `adicionarSaldo(valor)` é importante porque ele concentra a regra de negócio em um lugar só. Se cada programador alterasse o saldo diretamente, alguém poderia adicionar um valor negativo, apagar o saldo por engano ou criar uma lógica diferente em cada parte do sistema. Em uma startup de mobilidade, isso seria perigoso porque o saldo representa dinheiro do passageiro. O método permite validar o valor antes de mudar o atributo e deixa claro qual ação está acontecendo.

---

### Aula 3 - Encapsulamento

**Pergunta:** No nosso código, os atributos são `private`, mas os métodos `getSaldo()` e `getNome()` são `public`. Por que é seguro deixar o `get` público, mas perigoso deixar o atributo original público?

**Sua Resposta:**

O `get` público é mais seguro porque ele apenas entrega uma leitura do valor, sem permitir que outra classe altere diretamente o atributo original. Quando o atributo fica público, qualquer parte do sistema pode mudar o saldo, o nome ou o CPF sem passar por nenhuma regra de validação. Com os atributos `private`, a classe `Passageiro` continua dona dos seus dados. Outras classes conseguem consultar informações pelos getters, mas as alterações precisam passar por métodos controlados.

---

### Aula 4 - Construtores

**Pergunta:** Por que é um erro gerar getters e setters para tudo automaticamente? Como as decisões de não criar `setModelo()` público e deixar `setPlaca()` privado protegem o sistema?

**Sua Resposta:**

Gerar getters e setters para tudo automaticamente é perigoso porque transforma os atributos em dados quase públicos, só que com outro nome. Nem tudo em um objeto deve poder mudar livremente. No caso de um veículo, o modelo faz parte da identidade do carro. Já a placa pode mudar, mas isso representa um processo real. O método `atualizarPlaca()` deixa essa intenção clara e chama internamente a validação feita por `setPlaca()`.

---

### Aula 5 - Associação

**Pergunta:** Se o resumo da `Viagem` só precisa imprimir o nome, não seria mais fácil pedir apenas `String nomeDoPassageiro` em vez do objeto `Passageiro` inteiro?

**Sua Resposta:**

Pedir o objeto inteiro é melhor porque a viagem não depende apenas do nome do passageiro. O nome serve para exibir um resumo, mas as regras de negócio precisam acessar outros dados e comportamentos, como consultar saldo e pagar a corrida. Se a `Viagem` guardasse apenas a String `"Ana Silva"`, ela não conseguiria chamar `getSaldo()` nem `pagarViagem()`. Ao receber um `Passageiro`, a classe `Viagem` fica associada ao usuário real do sistema.

---

### Aula 6 - Herança

**Pergunta:** Por que o Java não deixa a filha alterar diretamente as variáveis privadas da mãe?

**Sua Resposta:**

O Java não permite esse acesso direto porque `private` significa que somente a própria classe controla aquele dado. Mesmo que `Carro` seja um tipo de `Veiculo`, ele não deve quebrar as regras internas da classe mãe. Se a filha pudesse alterar `placa` diretamente, ela poderia ignorar a validação criada em `Veiculo`. Isso protege o encapsulamento aprendido na Aula 3 e permite reaproveitar código sem destruir a segurança dos dados.

---

### Aula 7 - Polimorfismo

**Pergunta:** Se esquecêssemos de criar `calcularAutonomia()` na classe mãe `Veiculo`, conseguiríamos chamá-lo em um loop `for (Veiculo veiculo : frota)`?

**Sua Resposta:**

Não conseguiríamos chamar o método no loop se ele não existisse na classe mãe, porque o compilador olha primeiro para o tipo da variável, que nesse caso é `Veiculo`. Mesmo que, em tempo de execução, o objeto real seja um `Carro` ou uma `Moto`, o contrato precisa estar declarado na base da hierarquia. Esse contrato diz que todo `Veiculo` sabe calcular autonomia, ainda que cada filho faça a conta de um jeito diferente.

---

### Aula 8 - Classes Abstratas

**Pergunta:** Por que precisamos dizer explicitamente ao Java que `Veiculo` é `abstract`? Qual é o risco de esquecer isso?

**Sua Resposta:**

No mundo real, não faz sentido comprar apenas "um veículo" genérico, sem ser carro, moto ou outro tipo concreto. Mesmo assim, o Java não deduz essa intenção sozinho, porque uma classe comum sempre pode ser instanciada se tiver um construtor acessível. Por isso, precisamos escrever `abstract` explicitamente. Se esquecermos, alguém pode criar `new Veiculo()` e gerar um objeto sem identidade real no sistema, com comportamento genérico demais para as regras do FiapRide. Ao transformar `Veiculo` em abstrata, ela vira um molde: define atributos e contratos, mas obriga o sistema a trabalhar com classes concretas como `Carro` e `Moto`.

---

## Desafios Técnicos Implementados

### Aula 1

Foram criadas a classe `Passageiro`, com os atributos `nome` e `saldo`, e a classe `SistemaPrincipal`, que instancia objetos para demonstrar a diferença entre classe e objeto.

### Aula 2

Foram adicionados os métodos `adicionarSaldo(double valor)` e `pagarViagem(double custo)` na classe `Passageiro`, com parâmetros, retorno `boolean` e validações.

### Aula 3

Os atributos `nome`, `cpf` e `saldo` da classe `Passageiro` foram alterados para `private`. Também foram criados getters públicos e setters privados com validação.

### Aula 4

Foi criada a classe `Veiculo`, com atributos privados, construtor padrão usando `this()`, construtor customizado, getters, `setPlaca()` privado e método público `atualizarPlaca()`.

### Aula 5

Foi criada a classe `Viagem`, associando objetos de `Passageiro` e `Veiculo` por meio dos atributos `solicitante` e `veiculoUtilizado`.

### Aula 6

Foram criadas as classes `Carro` e `Moto`, ambas herdando de `Veiculo` com `extends` e usando `super()` nos construtores.

### Aula 7

Foi criado o contrato `calcularAutonomia()` em `Veiculo`, com sobrescrita em `Carro` e `Moto`. O `SistemaPrincipal` usa uma `List<Veiculo>` para demonstrar polimorfismo.

### Aula 8

A classe `Veiculo` foi transformada em `abstract`, impedindo instanciação direta. Também foram criados os métodos abstratos `exibirTipo()` e `calcularAutonomia()`, obrigando `Carro` e `Moto` a implementarem seus próprios comportamentos.