"def" is a simple program that uses brave to search for the definition
of a given word.

To run it as a regular command. add the shbang at the top
of the file.

   #! /usr/bin/python3

make sure it is the first line in the file (before the doc string).
Then you will be able to remove the .py extension and run it as
a regular command from anywhere. 


Usage (without the shbang, then with it):

             python3 def <query>

	     def <query>          
Example (without the shbang, then with it):

             python3 def.py prolithic

	     def prolithic        
Result:
    
     -- --  -- --  -- --  -- --  -- --  -- --  -- --  -- --  -- --  -- --
    pronunciation  prə-lĭf′ĭk
    
    adjective
             1- Producing offspring or fruit in great abundance; fertile.
    
             2- Producing or characterized by abundant works or results: synonym:  fertile.
