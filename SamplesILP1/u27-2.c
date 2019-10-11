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
    ILP_Object ilptmp144;
    ILP_Object ilptmp145;
    ilptmp144 = ILP_Integer2ILP (1);
    ilptmp145 = ILP_Integer2ILP (2);

    {
      ILP_Object x1 = ilptmp144;
      ILP_Object y2 = ilptmp145;
      {
	ILP_Object ilptmp146;
	ilptmp146 = ILP_Integer2ILP (3);

	{
	  ILP_Object y3 = ilptmp146;
	  return y3;

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
