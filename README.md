# java-option

## the option pattern
Option pattern is a cool thing to avoid the null values and all the disgusting null pointer exceptions! You should never ever set any object value to null. Why? Let me explain this problem with this [simple presentation](insert link here)
Further reading in this topic:
https://code.google.com/p/guava-libraries/wiki/UsingAndAvoidingNullExplained

## I still dont get it, what is that?
We all like examples, so think about this. Instead of code
```java
User user = null;
...
if (user != null)
   sendEmail(user.getEmail());
```
you should write this:
```java
User user = Option.none();
...
if (user.isDefined())
   sendEmail(user.get());
```

It may seems to be useless at first, but think about this. If you don't have null references, you dont need to check for nulls any more. Setting something as empty, has a syntactical meaning!

## yeah, thats pretty much the guava's optional
I know. But if you are coming from the Scala world, and you have to code in Java, you may find usefull to have the Scala like syntax/class names.

