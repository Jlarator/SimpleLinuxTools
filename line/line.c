#include <stdio.h>
#include <string.h>
#include <stdlib.h>


int main(int argc, char* argv[]){


  if(argc != 3){
    fprintf(stderr, "line needs a line number and a file name\n");
    exit(0);     
  }
  
  int lineNumber = atoi(argv[1]);
  int counter = 1; 
  char *fileName = argv[2];

  FILE *fileReader = fopen(fileName, "r");
  if(fileReader == NULL){
    fprintf(stderr, "Failed to open file\n"); 
    exit(0); 
  }

  size_t lineSize = 0;
  char* line = NULL;

  while(counter < lineNumber){
    getline(&line, &lineSize, fileReader);
    counter++; 
  }
  
  getline(&line, &lineSize, fileReader);  
  printf("%s\n", line); 	
    
  fclose(fileReader); 
  return 0; 
}
