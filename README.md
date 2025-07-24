# Gestor de Consultes de Recursos

Aquest projecte en Java implementa una aplicació de consola per gestionar consultes d’usuaris a diferents recursos. L’aplicació permet carregar dades des d’un fitxer, gestionar consultes i mostrar estadístiques sobre l’ús dels recursos.

## Estructura del projecte

- **`Aplicacio/UsaLlistaPersones.java`**: Classe principal de l’aplicació. Gestiona el menú d’usuari, la lectura de dades i la interacció amb l’usuari.
- **`Dades/LlistaPersones.java`**: Classe que emmagatzema i gestiona una llista d’objectes `Persona`. Inclou funcionalitats com afegir, esborrar o consultar dades.
- **`Dades/Persona.java`**: Classe que representa una persona amb atributs com la data de consulta, l’àlies i el recurs consultat.
- **`LlistaPersones.txt`**: Fitxer amb les dades inicials per carregar a l’aplicació.

## Funcionalitats principals

A través del menú de l’aplicació, l’usuari pot:

1. **Afegir dades**: Registrar una nova consulta d’un usuari.
2. **Esborrar dades d’un recurs**: Eliminar totes les consultes associades a un recurs.
3. **Esborrar dades d’una data i recurs**: Esborrar consultes per a un recurs en una data concreta.
4. **Mostrar usuaris per recurs**: Veure quins usuaris han consultat un recurs determinat.
5. **Mostrar usuaris per recurs i data**: Mostrar quins usuaris han consultat un recurs en una data específica.
6. **Mostrar el recurs més consultat**.
7. **Mostrar recursos consultats per un usuari determinat**.
8. **Comprovar si un usuari ha vist un recurs concret**.
9. **Sortir del programa**.

## Requisits

- Java 8 o superior.
- Fitxer `LlistaPersones.txt` a la mateixa carpeta del projecte o indicar el path correcte en el codi.

## Execució

1. Compila els arxius `.java`:
   ```bash
   javac Aplicacio/UsaLlistaPersones.java Dades/LlistaPersones.java Dades/Persona.java
2. Executa el programa:
   java Aplicacio.UsaLlistaPersones
