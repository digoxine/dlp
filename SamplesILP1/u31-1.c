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
    ILP_Object ilptmp565;
    ilptmp565 = ILP_Integer2ILP (22);

    {
      ILP_Object i1 = ilptmp565;
      {
	ILP_Object ilptmp566;
	ilptmp566 = ILP_Float2ILP (6.3);

	{
	  ILP_Object f2 = ilptmp566;
	  {
	    ILP_Object ilptmp567;
	    ILP_Object ilptmp568;
	    ilptmp567 = f2;
	    ilptmp568 = i1;
	    return ILP_Plus (ilptmp567, ilptmp568);
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
