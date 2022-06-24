## Overview
When we face a mathematical problem we are used to start by playing around with the formulas, drawing pictures that tries to describe grafically what is given within the statement of the problem. A good point to start is to acknowledge the importance of discovering the unknown, in order to complete this step, we must understand the language that is being speaked.

To speak a *mathematical language* is a requisite, because there's no particularly (and good) reason to make the problem more complex, on the other hand it does simplify it by avoiding some confusion led by our grammar and the way english is interpreted.

This chapter will give us a good grasp of *what speaking mathematically* really is and how it does looks like, by learning its foundations : variables, sets, relations and functions.

## Variables
A variable can act as a "John Doe" for math, because it can be used as a placeholder when we want to talk about something but either:

1. We imagine that it has one or more **values** but we don't know what they are.
2. We want to afirm something to be equally true for **all the elements of a given set**.

Let's illustrate each of the uses:
``
>Is there a number with the following property: Doubling it and adding 3 gives the same result as squaring it?

In this sentence we can introduce a variable to replace the potentially ambigous word "it":

> Is there any $x$ with the property that: $2x + 3 = x^2$?

And the advantage of using a variable is that it allows you to use a temporary name to perform some concrete calculations with it to discover its possible values.

For the second one use, let's consider the next statement:

> No matter what number might be chose, if it is greater than 2, then its square is greater than 4.

In this case, we are saying that no matter what arbitrary number we choose, if that number is greater than 2, its square will be greater than 4. We avoid the ambiguity of "it" by giving a name to that number:

> No matter what number $n$ might be chosen, if $n$ is greater than 2, then $n^2$ is greater than 4.

#### Examples
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

> For every animal $a$, if $a$ is a dog, then $a$ is a mammal.

A important fact of universal conditional statements is that they can be rewritting to be expressed as a universal statement, when its universal nature is explicit, and on the other hand: conditional statement when its conditional nature is explicit.]

> If $a$ is a dog, then $a$ is a mammal.

 Although the statement can also be expressed so as to make its universal nature explicit and its conditional nature implicit:

> For every dog $a$, $a$ is a mammal.

The crucial point is that the ability to translate among various ways of expressing universal conditional statements is enormously useful for doing mathematics.