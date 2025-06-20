Simple calculator (calc.Java)
## description
A simple calculator with GUI, capable of processing multiple operations in a single input.

## Features in 1.0
- Basic arithmetic operations: addition, subtraction, multiplication, division
- Supports compound expressiosn with proper operator precedence (no parenthesis, but "-7+3" works)
- Input validation and basic error handling

## Technologies & Concepts
- Written in Java & JavaFX
- GUI added in 2.0
- Implemented algorithms:
    - tokenization (String to List of Strings)
    - Shunting Yard algorithm (infix to postfix)
    - Reverse Polish Notation (postfix evaluation)
- used Language features:
    - switch statements
    - regular expressions
    - data structures:
        - Stacks
        - Lists

# What I learned
- How to analyze and evaluate mathematical expressions programmatically
- Understanding of operator precedence and expression parsing
- Basic knowledge of Javas standard libraries
- Basic Frontend GUI implementation with JavaFX

## possible future Improvements
- GUI (done in 2.0)
- Support for parenthesis (done)

## Project Motivation
Preperation for studying computer science: I gained deeper knowledge of basic data structures, stacks and Java libraries.
I used ChatGPT to understand specific concepts, such as switch cases or the Shunting Yard algorithm

### Starting prompt:
mvn clean javafx:run