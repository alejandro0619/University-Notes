## Variables
A variable can act as a "John Doe" for math, because it can be used as a placeholder when we want to talk about something but either:

1. We imagine that it has one or more **values** but we don't know what they are.
2. We want to afirm something to be equally true for **all the elements of a given set**.

Let's illustrate each of the uses:
``
>Is there a number with the following property: Doubling it and adding 3 gives the same result as squaring it?

In this sentence we can introduce a variable to replace the potentially ambigous word "it":

>Is there any $x$ with the property that: $2x + 3 = x^2$?

And the advantage of using a variable is that it allows you to use a temporary name to perform some concrete calculations with it to discover its possible values.

For the second one use, let's consider the next statement:

>No matter what number might be chose, if it is greater than 2, then its square is greater than 4.

In this case, we are saying that no matter what arbitrary number we choose, if that number is greater than 2, its square will be greater than 4. We avoid the ambiguity of "it" by giving a name to that number:

>No matter what number $n$ might be chosen, if $n$ is greater than 2, then $n^2$ is greater than 4.

##### Examples
Use variables to rewrite the following sentences more formally:

1. Are there numbers with the property that the sum of their squares equals the square of their sum?

**Answer:**
Are there number with the property that: $a^2 + b^2 = (a+b)^2$ ?

2. Given any real number, its square is non-negative.

**Answer:**
Given $r, r \in \mathbb{R}/ r^2 \ge 0$.

### Some important kind of Mathematical statement
Three of the most important kinds of sentences in mathematics are **universal statements**, and **existential statements**:

#### Universal statements
Says that a certain property is true for all elements in a set. (For example: All positives numbers are greater than zero.)

#### Conditional statements
Says that if one thing is true then some other thing also has to be true. (For example: If $378$ is divisible by $18$, then is also divisible by $6$.)

Given a property that may or may not be true, an existential statement says that there is a least one thing for which the property is true. (For exampple: There is a prime number that is even.)

##### Notes:
In later section we will define each kind of statement carefully. The aim here is to realize that combinations of these statement can be expressed in a variety of different ways. One way uses ordinary, everyday language and another expresses the statement using one or more variables. 

#### Universal Conditioanl Statements
Universal statements contain some variation of the words *"for every"* And conditional statements contain a versions of the word *"If-then"*. A **Universal conditional statement** is a statement that is both universal and conditional. Here is an example:

>For every animal $a$, if $a$ is a dog, then $a$ is a mammal.

A important fact of universal conditional statements is that they can be rewritting to be expressed as a universal statement, when its universal nature is explicit, and on the other hand: conditional statement when its conditional nature is explicit.]

>If $a$ is a dog, then $a$ is a mammal.

 Although the statement can also be expressed so as to make its universal nature explicit and its conditional nature implicit:

>For every dog $a$, $a$ is a mammal.

The crucial point is that the ability to translate among various ways of expressing universal conditional statements is enormously useful for doing mathematics.

##### Examples
Rewrite the next statement:

>For every real number $x$, if $x$ is nonzero then $x^2$ is positive.


1. If a real number is nonzero, then its square is **positive.**
2. For every nonzero real number $x$, $x^2 > 0$.
3. If $x$ is a nonzero real number, then $x^2$ is positive.
4. The square of any nonzero real number is **positive.**
5. All nonzero real number has positive squares.

### Universal Existential Statements
Is a statement that is part universal, and part existential. The universal part is given because it says that a certain property is true for all the elements of a given set, on the other hand it is existential because asserts the existence of something. For example:

>Every real number has an additive inverse.

In this statement, the property "Has an additive inverse" aplies universally to all real numbers. "Has additive inverse", however, asserts the existence of something, that something is an additive inverse. By the way, it is good to remark that the nature of the additive inverse depends on the real number; different real numbers have different additive inverses.

Since we know that an additive inverse is a real number, we can rewrite this statement in several ways as is shown below:

>All real numbers have additive inverses.
1. For every real number $r$, there is an additive inverse for $r$.
2. For every real number $r$, there is a real number $s$ such that $s$ is the additive inverse for $r$.

It is also good to point that when $r$ is negative, then $s$ is positive, and viceversa. And when $r$ is zero, the $s$ is also zero.

##### Examples
Rewrite the next statement: 

>Every pot has a lid.

1. All pots has a lid.
2. For every pot $P$, there is a lid $S$.
3. For every pot $P$, there is a lid $S$, such that $S$ is a lid for $P$.


### Existential universal statements

An existential universal statement is a statement that is existential because its first part does assert that a certain object exists. And it is universal because its second part says that the object satisfies a certain property for all things of a certain kind. For example:

> There is a positive integer that is less than or equal to every positive integer.

This statement is true because the number one is a positive integer, and it satisfies the property of being less than or equal to every positive integer. Let's rewrite it in a more informal and formal way:

> Some positive integer is less than or equal than to every positive integer.

1. There is a positive integer $m$ that is less than or equal to every positive integer.
2. There is a positive integer $m$ such that every positive integer is greater than or equal to $m$.
3. There is a positive integers $m$ with the property that for every positive integer $n$, $n \ge m$ or $m \le n$.

##### Examples
Rewrite the following statement:

>There is a person in my class who is at least as old as every person in my class.

1. Some person is at least as old as every person in my class.
2. There is a person $p$ in my class such that $p$ is as old as every person in my class.
3. There is a person $p$ in my class with the property that for every person $q$ in my class, $p$ is as old as $q$.

## Important
Some of the most important mathematical concepts, such as the **definition of limit of a sequence**, can only be defined using phrases that are universal, existential, and conditional, and they require the use of all three phrases "for every," "there is," and "if-then." For example, if $a_1, a_2, a_3,...$ is a sequence of real numbers, saying that

>The limit of $a_n$ as $n$ approaches infinity is $L$.

means that:
For every positive real number $\epsilon$, there is an integer $N$ such that for every integer $n$, if $n>N$ then $- \epsilon < a_n - L < \epsilon$.

## Exercises

### Fill the blanks spaces using variable or variables to rewrite the statement.

1. Is there a real number whose square is $-1$?
Ans: 
 - Is there a real number $x$ such that $x^2$ is $-1$?
 - Does there exist a real number $x$ such that $x^2 = -1$?
------
 
2. Is there an integer that has a remainder of 2 when it is divided by 5 and a remainder of 3 when it is devided by 6?
Ans:
- Is there an integer $n$ such that $n$ has a remainder of 2 when $n$ is divided by 5, and 3 when $n$ is divided by 6.
- Does there exist an integer $n$ such that if $n$ is divided by 5 the remainder is 2, and if $n$ is divided by 6 the remainder is 3.
----

3. Given any two distinct real numbers, there is a real number between them.
Ans:
 - Given any two distinct real numbers $a$ and $b$, there is a real number $c$ such that $c$ is between $a$ and $b$.
 - For any two real numbers $a$ and $b$, exist a real number $c$ such that $c$ is between $a$ and $b$.
-----

4. Given any real number, there is a real number that is greater.
Ans:
 - Given any real number $r$, there is a real number $s$ that is greater.
 - For any real number $r$ there is a real number $s$ such that $s > r$.
  -----

5. The reciprocal of any positive real number is positive.
Ans:
 - Given any positive real number $r$, the reciprocal of $r$ is positive.
 - For any real number $r$, if $r$ is positive, then the reciprocal is positive.
 - If a real number $r$ is positive, then $\frac{1}{x} > 0.$
 -----

6. The cube root of any negative real number is negative.
Ans:
 - Given any negative real number $s$, the cube root of $s$ is negative.
 - For any real number $s$, if $s$ is negative, then $\sqrt[3]{s}$  is negative.
 - If a real number $s$, $s$ > 0, then $\sqrt[3]{s} > 0$.
-----
#### Rewrite the following statements less formally, without using variables. Determine as best as you can whether the statement is true or false.
7. 

7.1. There're real numbers $u$ and $v$ with the property that $u + v < u - v$
Ans: There are real numbers such sum is less than the rest of the given numbers.
 - True, for example: $u = 1, v = -1$ so that $u +v < u -v = u - v > u + v \rightarrow 1 - (-1) > 1 + (-1) = 2 > 0$ which is true.
 
7.2. There is a real number $x$ such that $x^2 < x$.
Ans: There is a real number such that its square is less than the integer.
 - False. For every real number $x$, its square will be greater than the integer itself.

7.3. For every positive integer $n, n^2 \ge n$.
Ans: For every positive integer, its square is greater than the integer.

7.4. For all real numbers $a$ and $b$, $|a+b| \le |a|+|b|$.
Ans: For all real numbers, the absolute value of the sum of two real numbers, is less than or equal to the sum of two absolute values.
Ans: True.
 - For example, if 
 $a = 1, b = -5$
$\rightarrow |a + b| \le |a| + |b| \rightarrow |1 + (-5)| \le |1| + |-5|$
$\rightarrow |-4| \le 1 + 5 \\ \rightarrow 4 < 6$.

-----
#### Rewrite the following statements.
8.
>For every object $J$, if $J$ is a square, then $J$ has four sides.

8.1. All square has four sides.
8.2. Every square has four sides.
8.3. If an object is a square, then it has four sides.
8.4. If $J$ is a square, then $J$ has four sides.
8.5. For every square $J$, $J$ has four sides.



9. 
>For every equation $E$, if $E$ is quadratic then $E$ has at most two real solutions.

9.1. All quadratic equations has at most two real solutions.

9.2. Every quadratic equation has at most two real solutions.

9.3. If an equation is quadratic, then it has at most two real solutions.

9.4. If $E$ is quadratic, then it has at most two real solutions.

9.5. For every quadratic equations $E$, $E$ has at most two real solutions.

10. 
>Every nonzero real number has a reciprocal.

10.1. All nonzero real numbers has a reciprocal.

10.2. For every nonzero real number $r$, there is a reciprocal for $r$.

10.3. For every nonzero real number $r$, there is a real number $s$ such that $s$ is a reciprocal for $r$.

11. 
>Every positive integer has a positive square root.

11.1. All positive number has a positive square root.

11.2. For every positive number $e$, there is a positive square root of $e$.

11.3. For every positive number $e$, there is a positive number $r$ such that $r$ is the square root for $e$.

12. 
> There is a real number whose product with every number leaves the number unchanged.

12.1. Some real number has the property that its product with every number leaves the number unchanged.

12.2. There is a number $r$ such that the product of $r$ with every number leaves the number unchaged.

12.3. For every real number $r$ with the property that for every real number $s$, $r \cdot s = s$.

13.

>There is a real number whose with every real number equals zero.

13.1. Some that has property that its productt with every real number equals zero.

13.2. There is a real number $a$ such that the product of $a$ with every real numbers equals to zero.

13.3. There is a real number $a$ with the property that for every real number $b$, $a \cdot b = 0$.
