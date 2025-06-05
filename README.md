# 📘 Análises de Complexidade – Lab 3

Este repositório contém a implementação e análise de problemas clássicos da disciplina **Construção e Análise de Algoritmos**. Abaixo estão duas análises detalhadas de algoritmos resolvidos neste trabalho.


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

📌 Algoritmo 1 – Problema das 8 Damas (Backtracking)
Descrição:
Resolve o problema clássico de posicionar 8 rainhas em um tabuleiro 8×8 de forma que nenhuma delas se ataque. Utiliza estratégia de backtracking, tentando colocar rainhas linha por linha e voltando (backtrack) quando encontra um impasse.

Complexidade de Tempo – O(N ⋅ N!)

Em um tabuleiro N×N, há N! (fatorial de N) possibilidades de posicionamento, pois cada linha deve conter uma rainha em uma coluna diferente.

Para cada tentativa, o algoritmo verifica:

A coluna (O(N))

A diagonal superior à esquerda (O(N))

A diagonal superior à direita (O(N))

Logo, o custo total de validação é O(N) por posição testada.

No pior caso, são feitas N! chamadas recursivas, cada uma com custo O(N), totalizando:

T(N) = N! × O(N) = O(N ⋅ N!)

Complexidade de Espaço – O(N²)

O tabuleiro é representado por uma matriz N×N → ocupa O(N²) espaço.

A pilha de chamadas recursivas tem profundidade máxima de N, com O(1) por chamada → total O(N).

Espaço total:

S(N) = O(N²) + O(N) = O(N²)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

📌 Algoritmo 2 – Problema das N Damas (Backtracking)
Descrição:
Versão generalizada do problema anterior, recebendo o número N como entrada. Resolve o problema das N rainhas usando a mesma abordagem de backtracking.

Complexidade de Tempo – O(N ⋅ N!)

Igual ao caso anterior, mas agora N é variável.

O número de possíveis configurações ainda é N!, e cada uma exige validação O(N).

Portanto:

T(N) = O(N ⋅ N!)

Complexidade de Espaço – O(N²)

Matriz do tabuleiro: O(N²)

Pilha de recursão: O(N)

Resultado final:

S(N) = O(N²)


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


📌 Algoritmo 3  – Mochila com Estratégia Gulosa (Limitada)
Descrição:
Este algoritmo resolve o problema da mochila usando uma estratégia gulosa (greedy), ou seja, ele seleciona os itens com a maior razão valor/peso primeiro, tentando maximizar o valor transportado na mochila sem ultrapassar a capacidade. Cada item só pode ser usado uma única vez.

Atenção: embora seja eficiente, essa estratégia não garante a solução ótima para a mochila 0/1. Só funciona perfeitamente quando é permitido dividir itens (caso da mochila fracionária).

🛠️ Estratégia do Algoritmo
Calcula a eficiência de cada item (valor/peso).

Ordena os itens pela eficiência (maior para menor).

Seleciona os itens um a um até preencher a mochila ou não haver mais espaço suficiente.

📊 Complexidade de Tempo – O(n log n)
Cálculo da razão valor/peso para todos os n itens: O(n)

Ordenação dos itens com base nessa razão: O(n log n)

Processamento e seleção dos itens: O(n)

Portanto:

T(n) = O(n log n)

🧠 Complexidade de Espaço – O(n)
O algoritmo armazena todos os n itens em uma lista.

Além disso, mantém uma lista para registrar os itens escolhidos.

Logo:

S(n) = O(n)


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Algoritmo 4 – Mochila com Programação Dinâmica (Limitada – 0/1)
Descrição:
Dado um conjunto de itens, cada um com peso e valor, este algoritmo determina o maior valor possível que pode ser colocado em uma mochila com capacidade limitada, considerando que cada item pode ser incluído no máximo uma vez.

Complexidade de Tempo – O(n ⋅ W)

n é o número de itens.

W é a capacidade da mochila.

É usada uma matriz dp[n+1][W+1], onde cada célula depende apenas da linha anterior → complexidade é:

T(n, W) = O(n ⋅ W)

Complexidade de Espaço – O(n ⋅ W)

A matriz ocupa n × W células:

S(n, W) = O(n ⋅ W)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Algoritmo 5 – Mochila com Programação Dinâmica (Ilimitada)
Descrição:
Versão ilimitada do problema da mochila, onde cada item pode ser incluído quantas vezes forem necessárias. O algoritmo visa maximizar o valor transportado sem ultrapassar o peso.

Complexidade de Tempo – O(n ⋅ W)

n é o número de itens, W é a capacidade da mochila.

É usada uma abordagem de vetor linear dp[W+1].

Cada valor de dp[w] é calculado iterando sobre todos os itens, resultando em:

T(n, W) = O(n ⋅ W)

Complexidade de Espaço – O(W)

Usa apenas um vetor de tamanho W + 1.

S(n, W) = O(W)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Algoritmo 6 – Passeio do Cavalo (Knight Tour)
Descrição:
Dado um tabuleiro de xadrez N×N, o cavalo deve percorrer todas as casas exatamente uma vez, seguindo as regras do seu movimento. Utiliza backtracking para explorar caminhos possíveis.

Complexidade de Tempo:
- Em cada posição, o cavalo pode tentar até 8 movimentos diferentes.
- A profundidade da recursão é N², pois ele precisa visitar todas as casas.

    T(N) = O(8^{N²})

Complexidade de Espaço:
- Pilha de recursão: profundidade até N²
- Tabuleiro: matriz N×N

    S(N) = O(N²)


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Algoritmo 7 – Subset Sum com Força Bruta
Descrição:
Dado um vetor de inteiros (positivos e negativos), encontrar subconjuntos não vazios cuja soma seja zero, testando todas as combinações possíveis (força bruta).

Complexidade de Tempo:
- Gera todos os subconjuntos: 2^n
- Para cada subconjunto, soma os elementos (com custo até O(n))

    T(n) = O(2^n ⋅ n)

Complexidade de Espaço:
- Pilha recursiva: O(n)
- Subconjunto temporário: O(n)

    S(n) = O(n)


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Algoritmo 8 – Subset Sum com Backtracking
Descrição:
Mesma proposta do problema anterior, mas agora com backtracking. O algoritmo tenta construir subconjuntos de forma incremental e interrompe se a soma excede ou se uma solução é encontrada.

Complexidade de Tempo:
- Pior caso: percorre todos os subconjuntos possíveis

    T(n) = O(2^n)

- Melhor caso: encontra solução logo no início

    T(n) = O(n)

Complexidade de Espaço:
- Pilha recursiva: O(n)
- Lista de subconjunto temporário: O(n)

    S(n) = O(n)


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Algoritmo 9 – Casa de Praia dos Algoritmos (Estratégia Gulosa)
Descrição:
Seleciona os arquivos que devem ser armazenados em um pendrive com capacidade limitada. Cada arquivo tem um nome, número de páginas e peso. O objetivo é maximizar a quantidade total de páginas no pendrive, priorizando os arquivos com melhor razão páginas/peso.

Complexidade de Tempo – O(n log n)

Leitura dos dados: O(n), onde n é o número de arquivos.

Ordenação dos arquivos: O(n log n), com base na razão páginas/peso.

Seleção de arquivos: O(n), pois percorre os arquivos uma vez.

Impressão dos resultados: O(n).

Portanto:

T(n) = O(n log n)

Complexidade de Espaço – O(n)

A estrutura de lista para armazenar os arquivos consome O(n), que é o principal consumo de memória.

S(n) = O(n)


-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
📌 Algoritmo 10 – Problema do Caixeiro Viajante
1. Complexidade de Tempo
A análise da complexidade de tempo para este algoritmo depende principalmente de dois fatores:
1.1 Geração de Permutações
O método gerarPermutacoes gera todas as permutações das n cidades, o que tem complexidade:

    O(n!)

Isso ocorre porque existem n! permutações possíveis para um conjunto de tamanho n.

1.2 Cálculo da Distância
Para cada permutação, o algoritmo chama o método calcularDistancia, que percorre todas as cidades no percurso, com complexidade:

    O(n)

Como existem n! permutações e cada uma exige O(n) operações para calcular a distância total, o custo total é:

    O(n ⋅ n!)

Complexidade Total:
A geração de permutações domina a análise, então a complexidade de tempo total é:

    O(n ⋅ n!)

2. Complexidade de Espaço
A complexidade de espaço considera os seguintes fatores:

2.1 Armazenamento das Cidades
As cidades são armazenadas em uma lista com n elementos, cada um contendo duas coordenadas (x, y), ocupando:

    O(n)

2.2 Armazenamento das Permutações
O algoritmo armazena todas as permutações em memória. Como existem n! permutações e cada uma contém n inteiros, isso ocupa:

    O(n ⋅ n!)

2.3 Recursão no Gerador de Permutações
O método permutacoesHelper usa recursão com profundidade máxima n, exigindo:

    O(n)

Complexidade Total:
A complexidade de espaço é dominada pelo armazenamento das permutações, logo:

    O(n ⋅ n!)

3. Resumo Final
Tipo de Complexidade	Valor
Tempo	O(n ⋅ n!)
Espaço	O(n ⋅ n!)

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
