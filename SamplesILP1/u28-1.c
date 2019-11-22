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
    ILP_Object ilptmp507;
    ilptmp507 = ILP_Integer2ILP (2);

    {
      ILP_Object x1 = ilptmp507;
      {
	ILP_Object ilptmp508;
	ilptmp508 = ILP_Integer2ILP (3);

	{
	  ILP_Object y2 = ilptmp508;
	  {
	    ILP_Object ilptmp509;
	    ILP_Object ilptmp510;
	    ilptmp509 = x1;
	    ilptmp510 = x1;
	    return ILP_Times (ilptmp509, ilptmp510);
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
