## About the Project

This project is a **DFA-based lexical analyzer** in Java.  
It checks if an input string belongs to the language defined by the DFA.

### Important Notes

- Users may not be familiar with formal symbols like `| |`, `*`, or `+`.... used in theoretical descriptions.  
- To make it simple, the program **does not require understanding these symbols**.  
- Instead, the DFA enforces rules directly:
  - The **letter 'a' can repeat any number of times** (`a+`)  
  - The **letter 'b' must follow** the sequence of 'a
  - The **letter 'c' comes last**  
- This ensures that **the input follows the correct order and repetition rules** without needing to understand formal logic symbols.

Example DFA path for input: aabc

q0 --a--> q1 --a--> q1 --b--> q2 --c--> q3 (ACCEPT)
