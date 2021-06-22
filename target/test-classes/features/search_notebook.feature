#language: pt
#encoding: utf-8

Funcionalidade: Testa pesquisa do google

Cenário: Deve validar pesquisa por <item>

Dado que estou na tela de pesquisa do google
Quando pesquiso por <item>
Então o título da página deve conter <searchResult>

Exemplos:
|item       |searchResult                 |
|"notebook" |"notebook - Pesquisa Google" |
|"geladeira"|"geladeira - Pesquisa Google"|