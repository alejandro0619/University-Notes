 ### Introduction
Use of the word $set$ as formal mathematical term was introduced in 1879 by Georg Cantor. For most mathematical purposes we can think of a set, as cantor did, simply as a collection of elements.

For instance, if $C$ is the set of all countries that are currently in the United Nations, then the United States is an element of $C$, and if $I$ is the set of integers from 1 to 100, then the number 57 is an element of $I$.

### Sets

#### Set-roster notation
If $S$ is a set, the notation $x \in S$ means that $x$ is an element of $S$. The notation $x \notin S$ means $x$ is not an element of $S$. A set may be specified using the set-roster notation by writing all of its elements between braces. For example, $\{1, 2, 3\}$ denotes the set whose elements are are $1, 2$ and $3$. A variation of the notation s sometimes used to describe a very large set, as when we write $\{1, 2, 3, ..., 100\}$ to refer to the set of all integers from 1 to 100. A similar notation can also describe an infinite set, as we write: $\{1, 2, 3, ...\}$.


The **axiom of extension** says that a set is a completely determined by what its elements are - not the order in which they might be listed or the fact that some elements might be listed more than once.

----

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
| $\mathbb{Q}$ | The set of all rational numbers |             
|              |                                 |

Addition of a superscript + or - or the letters *nonneg* indicates that only the positive or negative or nonnegative elements of the set, respectively, are to be included. Therefore $\mathbb{R}^+$ denotes the set of positive real numbers, and $\mathbb{Z}^{\text{noneng}}$ refers to the setof nonnegative integers: 0, 1, 2, ... . Some authors refer to the set of nonnegative integers as the set of **natural numbers** and denote it as $\mathbb{N}$.

-----
#### Set-builder notation
Let $S$ denote a ser and let $P_{(x)}$ be a property that elements of $S$ may or may not satisfy. We may define a new set to be the set of all the elements $x$ in $S$ in such that $P_(x)$ is true.

We can denote this set as follows: $\{x \in S | P_(x)\}$.

Occasionally we will write $\{x | P_(x)\}$ without being specific about where the $x$ element comes from. It is not a good notation to use because the unrestricted use of it could lead to contradictions in set theory.

----

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

#### Definition
Let $A$ and be $B$ be sets. $A$ is a proper subset $B$ iff every element of $A$ is at least one element of $B$ that is not in $A$.

----

##### Examples
1. Let $A$ = $\mathbb{Z^+}, B = \{n \in \mathbb{Z} | 0 \le n \le 100\}$ and $C = \{100, 200, 300, 400, 500, 600\}$. Evaluate the truth and falsity of each following statements.

1.2. $B \subseteq A$ 
**Ans**: False, there are elements in $A$ that are not in $B$. Because 0 is not a positive integer.

1.3. $C$ is a proper subset of $A$.
**Ans**: True, because there are at least infinite elements in $A$ that are not in $B$.

1.4. $C$ and $B$ have at least one element in common.
**Ans**: True, the element in common is 100.

1.5. $C \subseteq B$.
Ans: False, only one element is in $C$ that is in $B$.

1.6. $C \subseteq C$.
**Ans**: True, every set is a subset of itself.

----

2. Which of the following are true statements:

2.1. $2 \in \{1, 2, 3\}$.
**Ans**: True.

2.2. $\{2\} \in \{1, 2, 3\}$.
**Ans**: False.

2.3. $2 \subseteq \{1, 2, 3\}$.
**Ans**: False, 2 is not a set.

2.4. $\{2\} \subseteq \{1, 2, 3\}$.
**Ans**: True.

2.5. $\{2\} \in \{\{1\}, \{2\}\}$.
**Ans**: True.


----
### Cartesian Products
With the introduction of Georg Cantor's set theory in the late nineteenth century, it began to seem possible to put mathematics on a firm logical foundation by developing all of its various branchs from set theory and logic alone.

A major stumbling block was how to use sets to define an ordered pair because the definition of a set is unaffected by the order in which its element are listed. For example $\{a, b\}$ and $\{b, a\}$ represent the same set, whereas in an ordered pair we want to be able to indicate which element comes first.

In 1914, crucial breakthroughts were made by Norbert Wiener,a young American who had recently received his Ph.D from Hardvard, and the German mathematician Felix Hausdorff. Both gave definitions showing that an ordered pair can be defined as a certain type of set, but both definitions were somewhat awkward. Finally in 1921, the Polish mathematician Kazimierz Kuratowski publish the following definition, which has since become standard. 

It says that an ordered pair is a set of the form: $\{\{a\}, \{a,b\}\}$

This set has element, $\{a\}$ and $\{a,b\}$. If $a \ne b$, then the two sets are distinct and $a$ is in both sets, whereas $b$ is not. This allows us to distinguish between $a$ and $b$ and say that $a$ is the first element of the ordered pair and $b$ is the second element of the pair. If $a = b$, then we can simply say that $a$ is both the first and second element in the ordered pair. In this case the set that describes the ordered pair is: $\{\{a\}, \{a, a\}\}$, which is equal to $\{\{a\}\}$.

However, it was only long after ordered pairs had been used extensively in mathematics that mathematicians realized that it was possible to define them entirely in terms of sets, and, in any case, the set notation would be cumbersome to use on a regular basis. The usual notation for ordered pairs referes to $\{\{a\}, \{a,b\}\}$ more simply as $(a, b)$.

#### Notation
Given elements $a$ and $b$, the symbol $(a,b)$ denotes the ordered pair consisting of $a$ and $b$ together with the specification that $a$ is the first element, of the pair and $b$ is the second element. Two order pairs $(a, b)$ and $(c, d)$ are equal if, and only if $a = c$ and $b = d$. 

Symbolically: $(a, b) = (c, d)$ means that $a = c$ and $b =d$. 

----

##### Examples
1. Is $(1, 2) = (2, 1)$?
**Ans**: No, by definition $(a, b) \ne (b, a)$.

2. Is $(3, \frac{5}{10}) = (\sqrt{9}, \frac{1}{2})$?
**Ans**: Yes, they are the same, just different representations.

3. What is the first element of $(1, 1)$?
**Ans**: The number 1.

----

The notation for an ordered n-tuple generalizes the notation for an ordered pair to a set with any finite number of elements. It also takes both order and multiplicity into account.

#### Definition
Let $n$ be a positive integer and let $x_1, x_2,..., x_n$ be (not necessarily distinct) elements. The ordered n-tuple, $(x_1, x_2,...,x_n)$, consists of $x_1, x_2,..., x_n$ together with the ordering: first, $x_1$, then $x_2$ and so forth up to $x_n$. And ordered 2-tuple is called an ordered pair, and an ordered 3-tuple is called an ordered triple.

Two ordered n-tuples $(x_1, x_2, ..., x_3)$ and $(y_1, y_2, ..., y_n)$ are equal if, only if $x_1 = y_1, x_2 = y_2,..., x_n =y_n$.

Symbolically: $(x_1, x_2, ..., x_n) = (y_1, y_2,...y_n) \iff x_1 = y_2, x_2 = y_2,..., x_n = y_n$.

----
##### Examples
1. Is $(1, 2, 3, 4) = (1, 2, 4, 3)$?
**Ans**: No, they aren't the same because $3 \ne 4$.

2. Is $(3, (-2)^2, \frac{1}{2}) = (\sqrt{9}, 4, \frac{3}{6})$?
**Ans**: Yes, they are the same because: $3 = \sqrt{9}, (-2)^2 = 4$ and $\frac{1}{2} = \frac{3}{6}$.

----

#### Definition of cartesian product

Given sets $A_1, A_2,... A_n$, the cartesian product of $A_1, A_2,... A_n$, denoted by $A_1 \times A_2, \times ... \times A_n$, is the set of all ordered n-tuples $(a_1, a_2,...a_n)$ where $a_1 \in A_1, a_2 \in A_2,... a_n \in A_n$.

Symbolically: $A_1 \times A_2, \times ... \times A_n = \{(a_1, a_2,...a_n) | a_1 \in A_1, a_2 \in A_2,...,a_n \in A_n \}$.

In particular:
$A_1 \times A_2 = \{(a_1, a_2) | a_1 \in A_1, a_2 \in A_2\}$
is the cartesian product of $A_1$ and $A_2$.

----
##### Examples
Let $A = \{x, y\}, B = \{1, 2, 3\}$ and $C = \{a, b\}$.

1. Find $A \times B$.
**Ans**: $A \times B = \{(x, 1), (y, 1), (x, 2), (y, 2), (x, 3), (y, 3)\}$.

2. Find $B \times A$.
**Ans**: $B \times A = \{(1, x), (1, y), (2, x), (2, y), (3, x), (3, y)\}$.

3. Find $A \times A$.
**Ans**: $A \times A = \{(x, x), (x, y), (y, x), (y, y)\}$.

4. How many elements are in $A \times B, B \times A$ and $A \times A$.
**Ans**: $A \times B$: 6 ordened pairs. $B \times B$: 6 ordened pairs. $A \times A$: 4 ordened pairs

5. Find $(A\times B) \times C$.
**Ans**: We know $A \times B = \{(x, 1), (y, 1), (x, 2), (y, 2), (x, 3), (y, 3)\}$  let $D = A \times B$ such that $D \times C = \{(d, c)| d \in D, c\in C\}$.
$\therefore D \times C = \{((x, 1),a), ((y, 1),a), ((x,1), b), ((y,1),b), ((x, 2),a), ((y, 2), a),$
$... ((x, 2),b), ((y, 2), b), ((x, 3), a), ((y, 3), a), ((x, 3), b), ((y, 3), b)$.

6. Find $A \times B \times C$.
**Ans**: By the definition of Cartesian Product:
$A \times B = \{(a_1, b_1),...,(a_n, b_m) | a  \in A, b \in B\}$.
For instance:
$A \times B \times C$ wil be an ordered 3-tuple:
$A \times B \times C = \{(x, 1, a), (x, 1, b), (x, 2, a), (x, 2, b), (x, 3, a), (x, 3, b)$.
$... , (y, 1, a), (y, 1, b), (y, 2, a), (y, 2, b), (y, 3, a), (y, 3, b)\}$.

7. Let $\mathbb{R}$ denote the set of all real numbers. Describe $\mathbb{R} \times \mathbb{R}$.
**Ans**: By definition, the set $\mathbb{R} \times \mathbb{R} = \mathbb{R}^2$.
### Exercises
1. When the elements of a set are given using the set roster notation, he order in which they are listed does not matter.
2. The symbol $\mathbb{R}$ denotes the set of all real numbers.
3. The symbol $\mathbb{Z}$ denotes the set of all integers.
4. The symbol $\mathbb{Q}$ denotes the set of all rational numbers.
5. The notation $\{x| P(x)\}$ the set of element $x$ such that $P_{(x)}$.
6. For a set $A$ to be a subset of $B$ means that $A$ is contained in $B$, by definition: $\forall x(x \in A \implies x \in B)$.
7. Given sets $A$ and $B$, the cartesian product $A \times B$ is a ordered pair $(a, b)$ where $a \in A$ and $b \in B$.
8. Given sets $A, B$ and $C$, the Cartesian product $A \times B \times C$ is a ordered triple $a, b, c$ such that $a \in A, b \in B, c \in C$.
9. A string of length $n$ over a set $S$ id an ordered n-tuple of elements of $S$ written without  parentheses or commas.

----

1. Which of the following sets are equal?
 $A = \{a, b, c, d\}$, $B = \{d, e, a, c\}$, $C = \{d, b, a, c\}$, $D = \{a, a, d, e, c, e\}$.
$A = C$ and $B = D$.

2. Write in words how to read each of the following out.
2.1. $\{x \in \mathbb{R}^+ | 0 > x < 1\}$.
**Ans**: The set of all real positives numbers such that $x$ is between in 0 and 1.

2.2. $\{x \in \mathbb{R} | x \le 0 \text{ or } x \ge 1\}$.
**Ans**: The set of all real numbers such that $x$ is less than or equal to 0, or greater than equal to 1.

2.3. $n \in \mathbb{Z} | n \text{ is a factor of } 6$.
**Ans**: The set of all integers such that $n$ is a factor of 6.

2.4. $n \in \mathbb{Z}^+ | n \text{ is a factor of } 6$.
**Ans**: The set of all positive integers such that $n$ is a factor of 6.

3. Answers the questions.
3.1. Is $4 = \{4\}$?
**Ans**: No, 4 is a number and $\{4\}$ is a set which only element is a four.

3.2. How many elements are in the set $\{3, 4, 3, 5\}$?
**Ans**: There are 3 elements.

3.3. How many elements are in the set $\{1, \{1\}, \{1, \{1\}\}\}$?
**Ans**: There are 3 elements.

4. Answers the questions.
4.1. Is $2 \in \{2\}$?
**Ans**: Yes.

4.2. How many elements are in the set $\{2, 2, 2, 2\}$?
**Ans**: 1 element.

4.3. Is $\{0\} \in \{\{0\}, \{1\}\}$?
**Ans**: Yes, it is.

4.4. Is $0 \in \{\{0\}, \{1\}\}$?
**Ans**: No, it is not.

5. Which of the following sets are equal?
 $A = \{0, 1, 2\}$
 $B = \{x \in \mathbb{R} | -1 \le x < 3\}$
 $C = \{x \in \mathbb{R} | -1 < x < 3\}$
 $D = \{x \in \mathbb{Z}| -1 < x < 3\}$
 $E = \{x \in \mathbb{Z}^+ | -1 < x < 3\}$

$A = C = D$

6. For each integer $n$, let $T_n = \{n, n^2\}$. How many elements are in each of $T_2, T_{-3}, T_1, T_0$? Justify.
**Ans**: For $T_2 = \{2, 4\}$. For $T_{-3} = \{-3, 9\}$. For $T_1 = \{1, 1\}$. For $T_o = \{0\}$.
For $T_2, T_{-3},$ It has 2 elements, for $T_o$ it has 0 elements: It's a empty set, and for $T_1$ There is only one element, because $\{n, n\} = \{n\}$.

7. Use the set-roster notation to indicate the elements in each of the following sets:

7.1. $S = \{n \in \mathbb{Z} | n = (-1)^k\}$
**Ans**: $\{-1, 1\}$.

7.2. $T = \{ m \in \mathbb{Z} | m = 1 + (-1)^i$, for some integer $i\}$.
**Ans**: $\{0, 2\}$.

7.3. $U = \{r \in \mathbb{Z} | 2 \le 2 y \le -2\}$.
**Ans**: $\emptyset$.

7.4. $V = \{s \in \mathbb{Z} | s > 2$ or $s < 3\}$.
**Ans**:$\mathbb{Z}$.

7.5. $W = \{t \in \mathbb{Z} | 1 < t < -3\}$.
**Ans**: $\{-3,..., 1\}$.

7.6. $X  = \{u \in \mathbb{Z} | u \le 4$  or $u \ge 1\}$.

----
