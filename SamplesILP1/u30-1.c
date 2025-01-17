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
    ILP_Object ilptmp557;
    ilptmp557 = ILP_Integer2ILP (22);

    {
      ILP_Object i1 = ilptmp557;
      {
	ILP_Object ilptmp558;
	ilptmp558 = ILP_Float2ILP (3.3);

	{
	  ILP_Object f2 = ilptmp558;
	  {
	    ILP_Object ilptmp559;
	    ILP_Object ilptmp560;
	    ilptmp559 = i1;
	    ilptmp560 = f2;
	    return ILP_Plus (ilptmp559, ilptmp560);
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
