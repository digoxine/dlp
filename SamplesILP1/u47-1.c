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
    ILP_Object ilptmp630;
    {
      ILP_Object ilptmp631;
      ilptmp631 = ILP_FALSE;
      if (ILP_isEquivalentToTrue (ilptmp631))
	{
	  {
	    ILP_Object ilptmp632;
	    ilptmp632 = ILP_String2ILP ("invisible");
	    ilptmp630 = ILP_print (ilptmp632);
	  }

	}
      else
	{
	  ilptmp630 = ILP_FALSE;

	}
    }
    ilptmp630 = ILP_Integer2ILP (47);
    return ilptmp630;
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
