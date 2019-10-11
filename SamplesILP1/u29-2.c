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
    ILP_Object ilptmp187;
    ILP_Object ilptmp188;
    ilptmp187 = ILP_Integer2ILP (11);
    ilptmp188 = ILP_Integer2ILP (22);

    {
      ILP_Object x1 = ilptmp187;
      ILP_Object y2 = ilptmp188;
      {
	ILP_Object ilptmp189;
	ILP_Object ilptmp190;
	{
	  ILP_Object ilptmp191;
	  ILP_Object ilptmp192;
	  ilptmp191 = x1;
	  ilptmp192 = y2;
	  ilptmp189 = ILP_Plus (ilptmp191, ilptmp192);
	}
	{
	  ILP_Object ilptmp193;
	  ILP_Object ilptmp194;
	  ilptmp193 = x1;
	  ilptmp194 = y2;
	  ilptmp190 = ILP_Times (ilptmp193, ilptmp194);
	}

	{
	  ILP_Object x3 = ilptmp189;
	  ILP_Object y4 = ilptmp190;
	  {
	    ILP_Object ilptmp195;
	    ILP_Object ilptmp196;
	    ilptmp195 = x3;
	    ilptmp196 = y4;
	    return ILP_Times (ilptmp195, ilptmp196);
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
