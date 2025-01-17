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
    ILP_Object ilptmp13;
    ilptmp13 = ILP_Integer2ILP (0);

    {
      ILP_Object i1 = ilptmp13;
      while (1)
	{
	  ILP_Object ilptmp14;
	  {
	    ILP_Object ilptmp15;
	    ILP_Object ilptmp16;
	    ilptmp15 = i1;
	    ilptmp16 = ILP_Integer2ILP (5);
	    ilptmp14 = ILP_LessThan (ilptmp15, ilptmp16);
	  }
	  if (ILP_isEquivalentToTrue (ilptmp14))
	    {
	      {
		ILP_Object ilptmp17;
		{
		  ILP_Object ilptmp18;
		  {
		    ILP_Object ilptmp19;
		    ILP_Object ilptmp20;
		    ilptmp19 = i1;
		    ilptmp20 = ILP_Integer2ILP (1);
		    ilptmp18 = ILP_Plus (ilptmp19, ilptmp20);
		  }
		  ilptmp17 = (i1 = ilptmp18);
		}
		{
		  ILP_Object ilptmp21;
		  {
		    ILP_Object ilptmp22;
		    ILP_Object ilptmp23;
		    ilptmp22 = i1;
		    ilptmp23 = ILP_Integer2ILP (3);
		    ilptmp21 = ILP_Equal (ilptmp22, ilptmp23);
		  }
		  if (ILP_isEquivalentToTrue (ilptmp21))
		    {
		      {
			ILP_Object ilptmp24;
			ilptmp24 = i1;
			ilptmp17 = ILP_print (ilptmp24);
		      }

		    }
		  else
		    {
		      continue;

		    }
		}
		(void) ilptmp17;
	      }

	    }
	  else
	    {
	      break;

	    }
	}
      return ILP_FALSE;

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
