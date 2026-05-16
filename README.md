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
- [ ] Aula 4 - Construtores
- [ ] Aula 5 - Associacao
- [ ] Aula 6 - Heranca
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

## Desafios Tecnicos Implementados

### Aula 1

Foram criadas a classe `Passageiro`, com os atributos `nome` e `saldo`, e a classe `SistemaPrincipal`, que instancia dois objetos diferentes para demonstrar a diferenca entre classe e objeto.

### Aula 2

Foram adicionados os metodos `adicionarSaldo(double valor)` e `pagarViagem(double custo)` na classe `Passageiro`. Os dois metodos recebem parametros, retornam `boolean` para indicar sucesso ou falha e validam os dados antes de alterar o saldo. A classe `SistemaPrincipal` foi atualizada para testar recargas validas, recarga invalida, pagamento com saldo suficiente, pagamento com saldo insuficiente e custo invalido.

### Aula 3

Os atributos `nome`, `cpf` e `saldo` da classe `Passageiro` foram alterados para `private`. Tambem foram criados getters publicos para leitura e setters privados com validacao, impedindo alteracoes diretas fora da propria classe. O `SistemaPrincipal` foi atualizado para usar o construtor e acessar os dados somente pelos metodos publicos.
