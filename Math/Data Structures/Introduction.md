## What is a data structure?
A way of organizing data so it can be used easily and effectively. Help us to read and understand the data, and to code it in a cleaner way.

## Abstract Data Types (ADT)
Is an **abstraction** of a **data structure** which provides only the interface to which a data structure must be adhere to.  **It does not provide implementation details.**

| Abstract Data Type (ADT) | Implementation (DS)                                                         |
|--------------------------|-----------------------------------------------------------------------------|
| List                     | Dynamic array<br>Linked List                                                |
| Queue                    | Linked list based queue<br>Array list based queue<br>Stack list based queue |
| Map                      | Tree Map<br>Hash Table                                                      |

## Computational Complexity Analysis
It does answer two questions:
- How much **time** does this algorithm need to finish?
- How much **space** does this algorithm need for its computiation.

### Big-O notation.
**Big-O notation** gives an upper bound of the complexty in the worst case, helping to quantify performance as the input size becomes a **arbitrary large**.

**n** is the size of the input: Complexities are ordered in from smallest to largest.

----
**Constant time:**  O(n1)
**Logarithmic time:** O($log(n)$$)
**Linear time:** O(n)
**Linearithmic time:** O($nlog(n)$)
**Quadratic time:** O($n^2$)
**Cubic time:** O($n^3$)
**Exponential time:** O($b^n$), $b > 1$
**Factorial time:** O($n!$)

----



