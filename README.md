# PathVisualizer

## purpose
Use the characters to visualize the file tree of the file system.  
It can produce a string like this:

	+---a
	|   +---A1.java
	|   +---A2.java
	|   \---A3.java
	\---b
	    +---B1.java
	    +---B2.java
	    +---BB
	        +---BB1.java
					+---BB2.java
					\---BB3.java

## Specfications

+ a *file object* is a file or a directory
+ one line maps to one *file object*
+ `+` is *node*, which connects the sibling *file object*
+ `---` is *decoration*, which bonds the *node* and *file object*
+ `|` is *connector*, which connects the *node*

## Usage

Input this following statement to get the string representation of the tree.

	PathVisualizer.visualize("/the/directory/to/be/visualized");

*node*, *decoration*, *connector* can all be altered by invoking the corresponding setters.