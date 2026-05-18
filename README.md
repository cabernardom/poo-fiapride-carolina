# Projeto FiapRide

## Informações do Aluno

- **Nome:** Carolina Monteiro Bernardo
- **RM:** 564651
- **Turma:** 2CCPW
- **Curso:** Ciência da Computação
- **GitHub:** cabernardom

---

## Descrição do Projeto

Este projeto acompanha os desafios das aulas 1 a 9 de Programação Orientada a Objetos. O sistema **FiapRide** simula conceitos de um aplicativo de mobilidade urbana usando classes como `Passageiro`, `Veiculo`, `Carro`, `Moto`, `CarroEletrico`, `Viagem` e `Celular`.

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
- [x] Aula 9 - Interfaces

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos

**Pergunta:** Por que precisamos criar uma classe `Passageiro`? Não seria mais fácil apenas criar variáveis soltas no main?

**Sua Resposta:**

Criar a classe `Passageiro` deixa o sistema organizado porque ela funciona como um molde para todos os usuários do FiapRide. Se usássemos variáveis soltas no `main`, cada novo passageiro exigiria novas variáveis separadas, o que ficaria confuso e difícil de manter. Com uma classe, todos os passageiros seguem a mesma estrutura, mas cada objeto pode ter seus próprios valores de `nome` e `saldo`.

---

### Aula 2 - Métodos

**Pergunta:** Por que criar `adicionarSaldo(valor)` em vez de alterar `saldo` diretamente?

**Sua Resposta:**

Criar um método como `adicionarSaldo(valor)` é importante porque ele concentra a regra de negócio em um lugar só. Se cada programador alterasse o saldo diretamente, alguém poderia adicionar um valor negativo, apagar o saldo por engano ou criar uma lógica diferente em cada parte do sistema. O método permite validar o valor antes de mudar o atributo e deixa claro qual ação está acontecendo.

---

### Aula 3 - Encapsulamento

**Pergunta:** Por que é seguro deixar getters públicos, mas perigoso deixar atributos públicos?

**Sua Resposta:**

O getter público apenas entrega uma leitura do valor, sem permitir que outra classe altere diretamente o atributo original. Quando o atributo fica público, qualquer parte do sistema pode mudar saldo, nome ou CPF sem passar por nenhuma regra. Com os atributos `private`, a classe `Passageiro` continua dona dos seus dados.

---

### Aula 4 - Construtores

**Pergunta:** Por que é um erro gerar getters e setters para tudo automaticamente?

**Sua Resposta:**

Gerar getters e setters para tudo automaticamente é perigoso porque nem tudo em um objeto deve poder mudar livremente. O modelo de um veículo faz parte da identidade dele, por isso não existe `setModelo()` público. Já a placa pode mudar, mas isso representa um processo real, então a alteração passa por `atualizarPlaca()`.

---

### Aula 5 - Associação

**Pergunta:** Por que `Viagem` recebe um objeto `Passageiro` inteiro em vez de apenas o nome?

**Sua Resposta:**

Pedir o objeto inteiro é melhor porque a viagem não depende apenas do nome do passageiro. O nome serve para exibir um resumo, mas as regras de negócio precisam acessar outros dados e comportamentos, como consultar saldo e pagar a corrida. Se a `Viagem` guardasse apenas texto, ela não conseguiria chamar métodos do passageiro.

---

### Aula 6 - Herança

**Pergunta:** Por que a filha não pode alterar diretamente atributos privados da mãe?

**Sua Resposta:**

O Java não permite esse acesso direto porque `private` significa que somente a própria classe controla aquele dado. Mesmo que `Carro` seja um tipo de `Veiculo`, ele não deve quebrar as regras internas da classe mãe. Isso protege o encapsulamento e permite reaproveitar código sem destruir a segurança dos dados.

---

### Aula 7 - Polimorfismo

**Pergunta:** Por que `calcularAutonomia()` precisa existir na classe mãe `Veiculo`?

**Sua Resposta:**

O contrato precisa existir na classe mãe porque, em um loop `for (Veiculo veiculo : frota)`, o compilador olha para o tipo `Veiculo`. Mesmo que o objeto real seja `Carro` ou `Moto`, o método só pode ser chamado se a base da hierarquia declarar que todo veículo sabe calcular autonomia.

---

### Aula 8 - Classes Abstratas

**Pergunta:** Por que precisamos dizer explicitamente ao Java que `Veiculo` é `abstract`?

**Sua Resposta:**

No mundo real, não faz sentido comprar apenas "um veículo" genérico, sem ser carro, moto ou outro tipo concreto. O Java não deduz essa intenção sozinho, então precisamos escrever `abstract`. Se esquecermos, alguém pode criar `new Veiculo()` e gerar um objeto sem identidade real no sistema.

---

### Aula 9 - Interfaces

**Pergunta:** Por que Java permite herança simples, mas múltiplas implementações de interfaces?

**Sua Resposta:**

Java evita herança múltipla de classes porque duas mães poderiam ter código concreto com o mesmo método, gerando conflito sobre qual implementação deveria ser herdada. Se `Veiculo` e `Bateria` tivessem um método `ligar()`, o `CarroEletrico` poderia ficar ambíguo. Interfaces resolvem isso porque funcionam como contratos: elas dizem quais métodos uma classe deve ter, mas a classe concreta implementa a regra uma vez. Assim, `CarroEletrico` pode herdar de `Veiculo` e implementar `Recarregavel` sem conflito.

---

## Desafios Técnicos Implementados

### Aula 1

Foram criadas a classe `Passageiro` e a classe `SistemaPrincipal`.

### Aula 2

Foram adicionados os métodos `adicionarSaldo(double valor)` e `pagarViagem(double custo)` na classe `Passageiro`.

### Aula 3

Os atributos `nome`, `cpf` e `saldo` foram alterados para `private`, com getters públicos e setters privados.

### Aula 4

Foi criada a classe `Veiculo`, com construtor padrão, construtor customizado, uso de `this()` e `this.`.

### Aula 5

Foi criada a classe `Viagem`, associando `Passageiro` e `Veiculo`.

### Aula 6

Foram criadas as classes `Carro` e `Moto`, ambas herdando de `Veiculo` com `extends` e `super()`.

### Aula 7

Foi criado o contrato `calcularAutonomia()`, com sobrescrita em `Carro` e `Moto`.

### Aula 8

A classe `Veiculo` foi transformada em `abstract`, com os métodos abstratos `exibirTipo()` e `calcularAutonomia()`.

### Aula 9

Foi criada a interface `Recarregavel`, com as constantes `CARGA_MAXIMA` e `CARGA_MINIMA` e o método `recarregar(int percentual)`. A classe `CarroEletrico` herda de `Veiculo` e implementa `Recarregavel`, enquanto `Celular` implementa `Recarregavel` sem fazer parte da hierarquia de veículos. O `SistemaPrincipal` testa o polimorfismo de interface usando um array de `Recarregavel`.