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
    ILP_Object ilptmp151;
    ilptmp151 = ILP_Integer2ILP (2);

    {
      ILP_Object x1 = ilptmp151;
      {
	ILP_Object ilptmp152;
	ilptmp152 = ILP_Integer2ILP (3);

	{
	  ILP_Object y2 = ilptmp152;
	  {
	    ILP_Object ilptmp153;
	    ILP_Object ilptmp154;
	    ilptmp153 = x1;
	    ilptmp154 = x1;
	    return ILP_Times (ilptmp153, ilptmp154);
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
