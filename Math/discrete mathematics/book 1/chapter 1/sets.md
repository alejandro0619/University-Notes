### Introduction
Use of the word $set$ as formal mathematical term was introduced in 1879 by Georg Cantor. For most mathematical purposes we can think of a set, as cantor did, simply as a collection of elements.

For instance, if $C$ is the set of all countries that are currently in the United Nations, then the United States is an element of $C$, and if $I$ is the set of integers from 1 to 100, then the number 57 is an element of $I$.

### Sets

#### Set-roster notation
If $S$ is a set, the notation $x \in S$ means that $x$ is an element of $S$. The notation $x \notin S$ means $x$ is not an element of $S$. A set may be specified using the set-roster notation by writing all of its elements between braces. For example, $\{1, 2, 3\}$ denotes the set whose elements are are $1, 2$ and $3$. A variation of the notation s sometimes used to describe a very large set, as when we write $\{1, 2, 3, ..., 100\}$ to refer to the set of all integers from 1 to 100. A similar notation can also describe an infinite set, as we write: $\{1, 2, 3, ...\}$.


The **axiom of extension** says that a set is a completely determined by what its elements are - not the order in which they might be listed or the fact that some elements might be listed more than once.

##### Examples
1. Let $A = \{1, 2, 3\}, B = \{3, 1, 2\},$ and $C = \{1, 1, 2, 3, 3, 3\}$. 
 1.1. What are the elements of $A, B$ and $C$?
 **Ans**: The elements are 1, 2 and 3
 1.2. How $A, B$ and $C$ are related?
 **Ans**: They are the same set, because they have the same elements.

2. Is $\{0\} = 0$?
 **Ans**: No, $\{0\}$ means an empty set, while 0 represents a number.

3. How many elements are in the set $\{1, \{1\}\}$?
**Ans**: Only two elements. 1 and the set that only has 1 element.

4. For each nonnegative $U_n = \{n, -n\}$. Find $U_1, U_2$ and $U_0$.
 **Ans**: For $n = 1, U_n = \{1, -1\}$. For $n = 2, U_n = \{2, -2\}$. For $n = 0, U_n = \{0, -0\} = \{0, 0\} = \{0\}$.
 -----
 Certain sets of numbers are so frequently referred to that they are given symbolic names. These are shown in the following table:

| Symbol       | Set                             |
| ------------ | ------------------------------- |
| $\mathbb{R}$ | The set of all real numbers     |
| $\mathbb{Z}$ | The set of all integers         |
| $\mathbb{Q}$ | The set of all rational numbers |             |                                 |

Addition of a superscript + or - or the letters *nonneg* indicates that only the positive or negative or nonnegative elements of the set, respectively, are to be included. Therefore $\mathbb{R}^+$ denotes the set of positive real numbers, and $\mathbb{Z}^{\text{noneng}}$ refers to the setof nonnegative integers: 0, 1, 2, ... . Some authors refer to the set of nonnegative integers as the set of **natural numbers** and denote it as $\mathbb{N}$.

-----
#### Set-builder notation
Let $S$ denote a ser and let $P_(x)$ be a property that elements of $S$ may or may not satisfy. We may define a new set to be the set of all the elements $x$ in $S$ in such that $P_(x)$ is true.

We can denote this set as follows: $\{x \in S | P_(x)\}$.

Occasionally we will write $\{x | P_(x)\}$ without being specific about where the $x$ element comes from. It is not a good notation to use because the unrestricted use of it could lead to contradictions in set theory.

##### Examples
Given that $\mathbb{R}$ denotes the set of all real numbers, $\mathbb{Z}$ the set of all integers, and $\mathbb{Z^+}$ the set of all positive integers, describe each of the following sets

1. $\{x \in \mathbb{R}\ | -2 < x < 5\}$.
**Ans:** The open interval of real numbers between -2 and 5.

2. $\{x \in \mathbb{Z} | -2 < x < 5\}$.
**Ans:** The open interval of integers between -2 and 5.

3. $\{x \in \mathbb{Z^+} | -2 < x < 5\}$.
**Ans:** It's not correct, because -2 is not an element of $Z^+$. In that case, it would be the interval of: {1, 2, 3, 4}.
----
### Subsets
A basic relation bewteen sets is that of subset.

#### Definition
If $A$ and $B$ are sets, then $A$ is called a subset of $B$, written $A \subseteq B$ , if, and only if every element of $A$ is also an element of $B$.

Symbolically: $A \subseteq B$ means that for every element $x$, if $x \in A$ then $x \in B$.

The phrases $A$ is contained in $B$ and $B$ contains $A$ are alternative ways of saying that $A$ is a subset of $B$.

----
It follows fronm the definitions of subset that for a $A$ not to be a subset of $B$ means that there is at least one element of $A$ that is not an element of $B$. 

Symbolically: $A \nsubseteq B$ means that there is at least one element $x$ s.t $x \in A$ but $x \notin B$.

