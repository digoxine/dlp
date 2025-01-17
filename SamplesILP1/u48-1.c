#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */
ILP_Object print;

/* Global prototypes */

/* Global functions */


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp636;
    {
      ILP_Object ilptmp637;
      ilptmp637 = ILP_TRUE;
      if (ILP_isEquivalentToTrue (ilptmp637))
	{
	  {
	    ILP_Object ilptmp638;
	    ilptmp638 = ILP_String2ILP ("invisible");
	    ilptmp636 = ILP_print (ilptmp638);
	  }

	}
      else
	{
	  ilptmp636 = ILP_FALSE;

	}
    }
    ilptmp636 = ILP_Integer2ILP (48);
    return ilptmp636;
  }

}

static ILP_Object
ilp_caught_program ()
{
  struct ILP_catcher *current_catcher = ILP_current_catcher;
  struct ILP_catcher new_catcher;

  if (0 == setjmp (new_catcher._jmp_buf))
    {
      ILP_establish_catcher (&new_catcher);
      return ilp_program ();
    };
  return ILP_current_exception;
}

int
main (int argc, char *argv[])
{
  ILP_START_GC;
  ILP_print (ilp_caught_program ());
  ILP_newline ();
  return EXIT_SUCCESS;
}
