#include <stdio.h> 
#include <stdlib.h> 
#include "ilp.h" 

/* Global variables */ 
ILP_Object vec;
ILP_Object length;
ILP_Object vector;

/* Global prototypes */ 

/* Global functions */ 


ILP_Object ilp_program () 
{ 
{ 
  ILP_Object ilptmp4; 
{ 
  ILP_Object ilptmp5; 
{ 
  ILP_Object ilptmp6; 
  ILP_Object ilptmp7; 
ilptmp6 = ILP_Integer2ILP(5); 
ilptmp7 = ILP_Float2ILP(5.6); 
ilptmp5 = ILP_vector(ilptmp6, ilptmp7);
}
ilptmp4 = (vec = ilptmp5); 
} 
{ 
  ILP_Object ilptmp8; 
ilptmp8 = vec; 
ilptmp4 = ILP_length(ilptmp8);
}
return ilptmp4; 
} 

} 

static ILP_Object ilp_caught_program () {
  struct ILP_catcher* current_catcher = ILP_current_catcher;
  struct ILP_catcher new_catcher;

  if ( 0 == setjmp(new_catcher._jmp_buf) ) {
    ILP_establish_catcher(&new_catcher);
    return ilp_program();
  };
  return ILP_current_exception;
}

int main (int argc, char *argv[]) 
{ 
  ILP_START_GC; 
  ILP_print(ilp_caught_program()); 
  ILP_newline(); 
  return EXIT_SUCCESS; 
} 
