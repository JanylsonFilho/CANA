# 📘 Análises de Complexidade – Lab 3

Este repositório contém a implementação e análise de problemas clássicos da disciplina **Construção e Análise de Algoritmos**. Abaixo estão duas análises detalhadas de algoritmos resolvidos neste trabalho.

-------------------------------------------------------------------------------------------------------------

## ♟️ Algoritmo 2 – Problema das N Damas

### 🧩 Descrição
Colocar `N` damas em um tabuleiro `N x N` de forma que nenhuma delas se ataque. Isso significa que não podem estar na mesma linha, coluna ou diagonal. O algoritmo utiliza **backtracking** (tentativa e erro).

---

### 📊 Análise de Complexidade

#### 🧠 Exploração de Configurações
- O número de combinações possíveis é `N!` (fatorial de N), pois cada linha tenta colocar uma dama em cada coluna válida.

#### 🔍 Validação de Posições
A função `podeColocarRainha()` verifica:
- Coluna: `O(N)`
- Diagonal superior à esquerda: `O(N)`
- Diagonal superior à direita: `O(N)`
- Custo total da verificação: `O(N)`

#### 🔁 Chamadas Recursivas
- No pior caso, até `N!` chamadas recursivas são feitas.
- Cada chamada realiza uma validação `O(N)`.

✅ **Complexidade de Tempo:**  
```math
O(N · N!)




---------------------------------------------------------------------------


## 📊 Análise de Complexidade

### Algoritmo 9 – Casa de praia dos algoritmos

#### 🔁 Complexidade de Tempo

- **Leitura dos dados:** O(n), onde *n* é o número de arquivos.
- **Ordenação dos arquivos:** O(n log n), pois os arquivos são ordenados com base na razão páginas/peso de cada arquivo.
- **Seleção dos arquivos:** O(n).
- **Impressão dos resultados:** O(n).

**🔹 Complexidade de Tempo Total:** O(n log n)

#### 🧠 Complexidade de Espaço

-  A complexidade de espaço total é O(n), já que a lista de arquivos é o maior consumidor de memória.
- **🔸 Complexidade de Espaço Total:** O(n)

