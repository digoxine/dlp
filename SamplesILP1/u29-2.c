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
    ILP_Object ilptmp543;
    ILP_Object ilptmp544;
    ilptmp543 = ILP_Integer2ILP (11);
    ilptmp544 = ILP_Integer2ILP (22);

    {
      ILP_Object x1 = ilptmp543;
      ILP_Object y2 = ilptmp544;
      {
	ILP_Object ilptmp545;
	ILP_Object ilptmp546;
	{
	  ILP_Object ilptmp547;
	  ILP_Object ilptmp548;
	  ilptmp547 = x1;
	  ilptmp548 = y2;
	  ilptmp545 = ILP_Plus (ilptmp547, ilptmp548);
	}
	{
	  ILP_Object ilptmp549;
	  ILP_Object ilptmp550;
	  ilptmp549 = x1;
	  ilptmp550 = y2;
	  ilptmp546 = ILP_Times (ilptmp549, ilptmp550);
	}

	{
	  ILP_Object x3 = ilptmp545;
	  ILP_Object y4 = ilptmp546;
	  {
	    ILP_Object ilptmp551;
	    ILP_Object ilptmp552;
	    ilptmp551 = x3;
	    ilptmp552 = y4;
	    return ILP_Times (ilptmp551, ilptmp552);
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
