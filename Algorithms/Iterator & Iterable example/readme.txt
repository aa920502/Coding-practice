An Iterable is a simple representation of a series of elements that can be iterated over. It does not have any iteration state such as a "current element". Instead, it has one method that produces an Iterator.

An Iterator is the object with iteration state. It lets you check if it has more elements using hasNext() and move to the next element (if any) using next().

Typically, an Iterable should be able to produce any number of valid Iterators.