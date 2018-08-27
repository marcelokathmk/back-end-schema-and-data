# Considerações de desenvolvimento

* Foi criado apenas o arquivo import.sql, que realizou a carga de dados das tabelas "category" e "product". Foi desconsiderado os arquivos data.sql e schema.sql, pois a propriedade ddl-auto foi setada para 'create-drop'. Para utilizar o arquivo schema.sql, a propriedade ddl-auto precisa estar desabilitada. Esta informação obtive através do link 'https://docs.spring.io/spring-boot/docs/current/reference/html/howto-database-initialization.html', na seção 81.3 Initialize a Database.

* Ocorreram diversos problemas de encoding, mais especificamente em palavras com acentuação, onde o mesmo não gravava corretamente o valor no banco. Realizei alteração do arquivo para o formato UTF-8 via ide (spring tool suite) e o problema foi resolvido.

* Os testes unitários implementados estão rodando com sucesso. Porém ao tentar criar o pacote .war do projeto, o mesmo aponta falhas nos testes por conta do problema de encoding nas palavras com acentuação, citado no bloco anterior. Mas ao rodar a aplicação e os testes de maneira separada, os mesmos retornam corretamente os valores e sem erros.
