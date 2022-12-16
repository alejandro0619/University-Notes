# Static and Dynamic Arrays
*It is a fundamental building block for other data structures*.

### Glossary
- Discussion and examples about Arrays
	- Definition
	- When and where is used?
	- Static array usage
- Dynamic array implementation details
- Code implementation

## Definition
A static array is a fixed length container containing n elements indexable from the range $[0, n-1]$.
- **Indexable** means that each slot/index in the array can be referenced with a number. 
- They are contiguous chunks of memory.
- It can't grow larger or shrink and be smaller.

## When and where is used?
1. Storing and accessing sequential data
2. Temporarily storing objects
3. Used by IO as buffers
4. Lookup tables and reverse lookup tables
5. Can be used to return multiple values from a function
6. Used in dynamic programming to cache answers to subproblems

#### Graph how array is visualized
![[pic1.jpg]]

To index in an array we use the square brackets notation this way:
```
A[0] = 44
A[2] = -5
A[10] = index out of bounds
```
