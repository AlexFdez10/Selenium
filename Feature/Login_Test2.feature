Feature: Login Action


Scenario: Abrimos el navegador y navegamos a la pagina
Given Abrimos navegador


Scenario Outline: Login
 Given Introducimos usuario y contrasenia "<user>" y "<pass>" para el login
 Then Login correcto
 Given iniciamos_segunda_compra
 Then Checkout_2


Examples:
|user|pass|
|standard_user|secret_sauce|
|locked_out_user|secret_sauce|
|problem_user|secret_sauce|
|performance_glitch_user|secret_sauce|
 
 
Scenario: Cerramos navegador
And Cerramos navegador