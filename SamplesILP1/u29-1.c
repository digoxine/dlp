#include <stdio.h>
#include <stdlib.h>
#include "ilp.h"

/* Global variables */

/* Global prototypes */

/* Global functions */


ILP_Object
ilp_program ()
{
  {
    ILP_Object ilptmp527;
    ilptmp527 = ILP_Integer2ILP (3);

    {
      ILP_Object x1 = ilptmp527;
      {
	ILP_Object ilptmp528;
	{
	  ILP_Object ilptmp529;
	  ILP_Object ilptmp530;
	  ilptmp529 = x1;
	  ilptmp530 = x1;
	  ilptmp528 = ILP_Plus (ilptmp529, ilptmp530);
	}

	{
	  ILP_Object x2 = ilptmp528;
	  {
	    ILP_Object ilptmp531;
	    ILP_Object ilptmp532;
	    ilptmp531 = x2;
	    ilptmp532 = x2;
	    return ILP_Times (ilptmp531, ilptmp532);
	  }

	}
      }

    }
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
