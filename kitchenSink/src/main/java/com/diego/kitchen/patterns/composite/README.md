# Composite
Composite pattern is used where we need to treat a group of objects in similar way as a single object. Composite pattern composes objects in term of a tree structure to represent part as well as whole hierarchy. This type of design pattern comes under structural pattern as this pattern creates a tree structure of group of objects. This pattern creates a class that contains group of its own objects. This class provides ways to modify its group of same objects. We are demonstrating use of composite pattern via following example in which we will show employees hierarchy of an organization.

## Implementation
We have a class Employee which acts as composite pattern actor class. CompositePatternDemo, our demo class will use Employee class to add department level hierarchy and print all employees.

![UML Diagram](https://github.com/diegurrio/kitchen-sink/blob/main/kitchenSink/src/main/java/com/diego/kitchen/patterns/composite/composite_pattern_uml_diagram.jpg?raw=true)
