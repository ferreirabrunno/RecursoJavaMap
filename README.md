<h1> Colletion Map Java </h1> 

### Implementação em map de votação por meio da leitura de arquivo texto.

## Definição de Map

Map é uma class generics que é expressa na forma Map<K,V>, onde usa dois parametros do tipo K onde seriam as chaves(Keys) e o tipo V que seriam os valores(values) atribuidos as keys, ou seja, cada elemento do map contém um par composto por uma chave e por um valor.

- E portanto:

         - Não admite repetições do objeto chave(Key);
         - Os elementos são indexados pelo objeto chave (não possuem posição);
         - Acesso, inserção e remoção de elementos são rápidos. 

 **uso comum:** cookies, local storage e qualquer modelo chave-valor(Key-Value).

- **Vantagens:**
Tem um acesso muito rápido aos elementos na ordem de 1, e o acesso é baseado em hash, além de que, é uma ótima opção para verificar com mais agilidade cada linha de entrada de dados, trazendo um resultado mais eficiente em relação a tipo lista, que é um processo de verificação por linha mais lenta.
- **Desvantagem:**
Não mantém a ordem dos elementos. E na medida que são adicionados e solicitado percorrer-los, não serão na mesma posição.

- **Principais implemetações:**

  **HashMap** - mais rápido (operações O(1) em tabela hash) e não ordenado;

  **TreeMap** - mais lento (operações O(log(n)) em árvore rubro-negra) e ordenado pelo compareTo do objeto (ou Comparetor);

  **LinkedHashMap** - velocidade intermediaria e elementos na ordem em que são adicionados.
 
## Detalhes do algorítimo de votação em Map<K,V>
A princípio, as keys e as Values necessitam que o tipo seja especificado, assim como também, deve ser instanciado para que possa ser definindo uma implementação, neste caso foi utilizado a HashMap.
~~~java
Map<String, Integer> map = new HashMap<>();
~~~

Também foi utilizada um algoritmo para contagem de votos "obtido de uma urna de votos". Para isso a implementação conta com um trecho de código que ler um arquivo texto em formato .csv que está disponível no package aqui no gitHub e que pode ser salvo no disco local para ser executado, como mostra o código abaixo.

~~~java
System.out.print("Digite o caminho do arquivo texto, Ex: C:\temp\nome do arquivo.txt: ");
String path = input.nextLine();
try (BufferedReader br = new BufferedReader(new FileReader(path))) {
~~~

o código ultiliza o BufferedReader br para abrir o arquivo que foi guardado na variável de referência path, dentro do try catch caso ocorra uma exceção, exibindo a mensagem de erro.
### Exemplo do Map<K,V> aplicado
 Ex:. <Francisco Melo,35>, onde “Francisco Melo” que é o nome do candidato que faz referência a chave<Key> e, portanto, foi definido do tipo String e o valor<Value> “35” que é a quantidade de votos, do tipo Integer, como mostra a instância no início do código.
   
Logo abaixo, o código começa com a leitura de uma linha através do método readLine() da classe BufferedReader, enquanto a linha não for nula definida no while logo abaixo. Em seguida foi criada um vetor para os campos nome e valores String[] fields, recebendo um line.split baseado na vírgula (“,”) onde o split que seria uma das funções da classe String que permite recortar com base no que foi definido dentro das aspas “ ” no caso a vírgula , . Então foi declarado a variável nome do tipo String recebendo a fields na posição 0 e a fields votos recebendo fields na posição 1, porém, por ser uma String foi necessária a conversão para Integer.parseInt(fields[1]).
~~~java
String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String nome = fields[0];
				int votos = Integer.parseInt(fields[1]);
 
~~~
Vale ressaltar que o map não permitir repetições de dados. Portanto, quando é encontrado outros campos com mesma chave e valor após executar o put, uma sobrescrita acontece permitindo com que sejam guardadas as informações da última iteração. Caso essa repetição for algo planejado, o código deve contar com um acumulador na medida que a leitura das linhas fosse feita, para que seja possível exibir o somatório posteriormente. Para testar se existem campos iguais foi utilizado o if, que a princípio verifica se ainda não existe campos iguais, caso contrário ele passa para o else onde vai somando e guardando a medida que vai lendo as linhas até finalizar, mostrando o resultado final.  
  
~~~java

                                if (map.get(nome) == null){
                                    map.put(nome, votos);
                                }else {
                                   map.put(nome, votos + map.get(nome));
                                } 
				line = br.readLine();
			}
~~~

E finalizando, aqui foi criada um for para percorrer o map para cada chave que for exibida na tela.

~~~java
			for (String key : map.keySet()) {
				System.out.println(key + ": " + map.get(key));
			}
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}		input.close();
	}
    }
~~~
